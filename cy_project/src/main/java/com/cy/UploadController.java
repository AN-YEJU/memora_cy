package com.cy;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

@Slf4j
@RestController
public class UploadController {
	
    @Value("${com.example.upload.path}") // application.properties의 변수
    private String uploadPath;

    @PostMapping("/uploadAjax")
    public ResponseEntity<Map<String, String>> uploadFile(MultipartFile[] uploadFiles){
    	String saveName2 = "";
//        List<UploadResultDTO> resultDTOList = new ArrayList<>();
        for (MultipartFile uploadFile : uploadFiles) {

            // 이미지 파일만 업로드 가능
            if(uploadFile.getContentType().startsWith("image") == false){
                // 이미지가 아닌경우 403 Forbidden 반환
            	return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            // 실제 파일 이름 IE나 Edge는 전체 경로가 들어오므로
            String originalName = uploadFile.getOriginalFilename();

            String fileName = originalName.substring(originalName.lastIndexOf("/") + 1);

            // 날짜 폴더 생성
            String folderPath = makeFolder();

            //UUID
            String uuid = UUID.randomUUID().toString();

            //저장할 파일 이름 중간에 "_"를 이용해 구분
            String saveName = uploadPath + "/"  + folderPath + "/"  + uuid + "_" + fileName;

            Path savePath = Paths.get(saveName);
            log.info("@#@#saveName"+saveName);
            try {
                uploadFile.transferTo(savePath);// 실제 이미지 저장(원본 파일)

                //섬네일 생성 -> 섬네일 파일 이름은 중간에 s_로 시작
                String thubmnailSaveName = uploadPath + "/"  + folderPath + "/"  +"s_" + uuid +"_"+ fileName;

                File thumbnailFile = new File(thubmnailSaveName);
                // 섬네일 생성
                Thumbnailator.createThumbnail(savePath.toFile(),thumbnailFile,100,100);
                log.info("@#@#thumbnailFile"+thumbnailFile);
                
                log.info("@#@#thumbnailFile"+thumbnailFile);
//                resultDTOList.add(new UploadResultDTO(fileName,uuid,folderPath));
                saveName2 = saveName;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        log.info("@#@#saveName2"+saveName2);
        Map<String, String> responseData = new HashMap<>();
        responseData.put("filePath", saveName2); // 파일 경로를 "filePath" 키로 저장

        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/uploadAjax2")
    public ResponseEntity<Map<String, String>> uploadFile2(MultipartFile[] uploadFiles, HttpSession session){
    	if (uploadFiles == null) {
    		Map<String, String> responseData = new HashMap<>();
    		String tempPhotoPath = (String) session.getAttribute("tempPhotoPath");
    		responseData.put("filePath", tempPhotoPath);
    		
    		return ResponseEntity.ok(responseData);
		}
    	String saveName2 = "";

    	//게시물 수정했을때 이전 사진 삭제
    	String tempPhotoPath = (String) session.getAttribute("tempPhotoPath");
    	removeFile(tempPhotoPath);
    	
    	for (MultipartFile uploadFile : uploadFiles) {
    		
    		// 이미지 파일만 업로드 가능
    		if(uploadFile.getContentType().startsWith("image") == false){
    			// 이미지가 아닌경우 403 Forbidden 반환
    			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    		}
    		
    		// 실제 파일 이름 IE나 Edge는 전체 경로가 들어오므로
    		String originalName = uploadFile.getOriginalFilename();
    		
    		String fileName = originalName.substring(originalName.lastIndexOf("/") + 1);
    		
    		// 날짜 폴더 생성
    		String folderPath = makeFolder();
    		
    		//UUID
    		String uuid = UUID.randomUUID().toString();
    		
    		//저장할 파일 이름 중간에 "_"를 이용해 구분
    		String saveName = uploadPath + "/"  + folderPath + "/"  + uuid + "_" + fileName;
    		
    		Path savePath = Paths.get(saveName);
    		log.info("@#@#saveName"+saveName);
    		try {
    			uploadFile.transferTo(savePath);// 실제 이미지 저장(원본 파일)
    			
    			//섬네일 생성 -> 섬네일 파일 이름은 중간에 s_로 시작
    			String thubmnailSaveName = uploadPath + "/"  + folderPath + "/"  +"s_" + uuid +"_"+ fileName;
    			
    			File thumbnailFile = new File(thubmnailSaveName);
    			// 섬네일 생성
    			Thumbnailator.createThumbnail(savePath.toFile(),thumbnailFile,100,100);
    			log.info("@#@#thumbnailFile"+thumbnailFile);
    			
    			log.info("@#@#thumbnailFile"+thumbnailFile);
//                resultDTOList.add(new UploadResultDTO(fileName,uuid,folderPath));
    			saveName2 = saveName;
    		}catch (IOException e){
    			e.printStackTrace();
    		}
    	}
    	log.info("@#@#saveName2"+saveName2);
    	Map<String, String> responseData = new HashMap<>();
    	responseData.put("filePath", saveName2); // 파일 경로를 "filePath" 키로 저장
    	
    	return ResponseEntity.ok(responseData);
    }

    
    @GetMapping("/display")
    public ResponseEntity<byte[]> getFile(String fileName, String size){
    	log.info("@#@#display"+fileName);
    	
    	ResponseEntity<byte[]> result = null;
        // 매개변수로 받은 파일 경로로 파일 객체 생성
        File file = new File(fileName);

        try {

            // 파일을 HTTP 응답으로 전송하기 위해 필요한 헤더와 데이터를 설정 (헤더 객체 생성)
            HttpHeaders header = new HttpHeaders();

            // Content-Type 헤더 설정(파일의 MIME 타입을 가져와서 Content-Type 헤더에 추가)
            header.add("Content-Type", Files.probeContentType(file.toPath()));

            // FileCopyUtils.copyToByteArray(file)를 사용하여 파일의 내용을 byte[]로 복사하여 응답 데이터로 설정
            result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

        } catch (NoSuchFileException ne) {
            log.info("★ 해당 경로에 프로필 사진이 없어서 에러 발생");
        } catch (InvalidPathException ipe) {
            log.info("★ 프로필 사진 요청하는 경로 상태가 ..? ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/removeFile")
    public ResponseEntity<Boolean> removeFile(String fileName){
        String srcFileName = null;
        try {
            srcFileName = URLDecoder.decode(fileName,"UTF-8");
            File file = new File(srcFileName);
            
            boolean result = file.delete();

            File thumbnail = new File(file.getParent(),"s_" + file.getName());

            result = thumbnail.delete();

            return new ResponseEntity<>(result,HttpStatus.OK);

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    private String makeFolder() {
        String folderPath = ""
        		+ "";
        
        // make folder ----
        File uploadPatheFolder = new File(uploadPath,folderPath);

        if(uploadPatheFolder.exists() == false){
            uploadPatheFolder.mkdirs();
        }

        return folderPath;
    }
}