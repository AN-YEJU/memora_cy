package com.cy;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cy.dto.Criteria;
import com.cy.dto.MainDto;
import com.cy.dto.MemDto;
import com.cy.dto.PageDto;
import com.cy.dto.PhotoDto;
import com.cy.service.PhotoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private UploadController uploadController;
	
	@Value("${com.example.upload.path}") // application.properties의 변수
    private String uploadPath;
	
	@SuppressWarnings("unused")
	@RequestMapping("/photo")
	public String photo(Model model, Criteria cri, HttpSession session, @RequestParam HashMap<String, String> param) {
  	log.info("@# photo");
	log.info("@# cri===>"+cri);
	log.info("@# param===>"+param);
		
      // 사진첩 리스트를 가져옴
      MainDto mainDto = (MainDto) session.getAttribute("mainDto");
      cri.setHostId(mainDto.getId());
      
      ArrayList<PhotoDto> photo = photoService.photo(cri);
      
		int total = 0;
		try {
			total = photo.get(0).getCount();
		} catch (Exception e) {
		}
      
      log.info("@# list ===>"+ photo);
      log.info("@# cateList ===>"+ photoService.cateList(mainDto.getMainID()));
      
      //사진 전체보기 -1 로 지정
      Integer cateId = -1;
      try {
	  //카테고리 id 조회
    	  cateId = Integer.parseInt(param.get("cateId"));
	} catch (Exception e) {

	}
      //param으로 들어온 cateId가 없을 경우 (메인에서 사진첩을 누르는 순간)
      if (cateId == -1) {
    	  model.addAttribute("photo", photo);
    	  model.addAttribute("pageMaker", new PageDto(total, cri));
	}else {
		total = 0;
		 ArrayList<PhotoDto> photo2 = new ArrayList<PhotoDto>();
		for (int i = 0; i < photo.size(); i++) {
			if (photo.get(i).getCateId() == cateId) {
				photo2.add(photo.get(i));
				total++;
			}
		}
		model.addAttribute("photo", photo2);
		model.addAttribute("pageMaker", new PageDto(total, cri));
	}
      log.info("@# photo2"+photo);
      
//      카테고리 리스트 가져옴
      model.addAttribute("cateList", photoService.cateList(mainDto.getMainID()));
      model.addAttribute("cateId", cateId);
      return "photo";
  }
	
	  @RequestMapping("/photoWrite")
	  public String photoWrite(@RequestParam HashMap<String, String> param, HttpSession session, MultipartFile[] uploadFiles) {
	      log.info("@# PhotoController.photoWrite() start");
	      log.info("@#@@#@#@#@#param"+param);
	      
	      MemDto memDto = (MemDto) session.getAttribute("memDto");
	      param.put("hostId", memDto.getId());
	      
	      // 사진첩 작성 서비스 호출
	      photoService.photoWrite(param);
	      
	      log.info("@# PhotoController.photoWrite() end");
	
	      return "redirect:/photo";
	  }
	  
	  
	  @RequestMapping("/photo_writeView")
	  public String photoWriteView(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
		  log.info("@#param"+param);
		  
		  MainDto mainDto = (MainDto) session.getAttribute("mainDto");
		  model.addAttribute("cateList", photoService.cateList(mainDto.getMainID()));
	      return "photo_writeView";
	  }

	  @RequestMapping("/photoView")
	  public String photoView(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
	      // 다이어리 내용 가져옴
		  PhotoDto dto = photoService.photoView(param);
	      log.info("@# dto"+dto);
	      model.addAttribute("photoView", dto);
	      
		  MainDto mainDto = (MainDto) session.getAttribute("mainDto");
		  model.addAttribute("cateList", photoService.cateList(mainDto.getMainID()));
		  session.setAttribute("tempPhotoPath", dto.getPhotoPath());
	      return "photo_view";
	  }
	  
	  @RequestMapping("/photoModify")
	  public String photoModify(@RequestParam HashMap<String, String> param, HttpSession session) {
		  log.info("@# PhotoController.photoModify() start");
	      log.info("@#@@#@#@#@#param"+param);
	      
	      // 사진첩 수정 서비스 호출
	      photoService.photoModify(param);
		  
	      log.info("@# PhotoController.photoModify() end");
	
	      return "redirect:/photo";
	  }
	
	  @RequestMapping("/photoDelete")
	  public String photoDelete(@RequestParam HashMap<String, String> param) {
	      // 사진첩 삭제 서비스 호출
		  log.info("photoDelete_param"+param);
		  
		  PhotoDto dto = photoService.photoView(param);
		  photoService.photoDelete(param);
		  
		  uploadController.removeFile(dto.getPhotoPath());
		  
	      return "redirect:/photo";
	  }
	  
//	  댓글
	  @RequestMapping("/photoCommentWrite")
	  public String photoCommentWrite(@RequestParam HashMap<String, String> param, HttpSession session, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
	      log.info("@# PhotoController.photoCommentWrite() start");
	      log.info("@#@@#@#@#@#param"+param);
	      
	      MemDto memDto = (MemDto) session.getAttribute("memDto");
	      param.put("commenter", memDto.getId());
	      
//			페이지 이동시 뒤에 페이지번호, 글 갯수 추가
		  rttr.addAttribute("pageNum", cri.getPageNum());
		  rttr.addAttribute("amount", cri.getAmount());
			
	      //댓글 작성 서비스 호출
	      photoService.photoCommentWrite(param);
	      
	      log.info("@# PhotoController.photoCommentWrite() end");
	
	      return "redirect:/photo";
	  }
	  
	  @RequestMapping("/photoCommentDelete")
	  public String photoCommentDelete(@RequestParam HashMap<String, String> param, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
	      // 댓글 삭제 서비스 호출
		  photoService.photoCommentDelete(param);
	
//			페이지 이동시 뒤에 페이지번호, 글 갯수 추가
		  rttr.addAttribute("pageNum", cri.getPageNum());
		  rttr.addAttribute("amount", cri.getAmount());
		  
	      return "redirect:/photo";
	  }
	  
	  
//	  카테고리
	  @RequestMapping("/cateWrite")
	  public String cateWrite(@RequestParam HashMap<String, String> param, HttpSession session) {
	      log.info("@# PhotoController.cateWrite() start");
	      log.info("@#@@#@#@#@#param"+param);
	      
	      MainDto mainDto = (MainDto) session.getAttribute("mainDto");
	      param.put("mainId", String.valueOf(mainDto.getMainID()));
	      
	      // 카테고리 작성 서비스 호출
	      photoService.cateWrite(param);
	      
	      log.info("@# PhotoController.cateWrite() end");
	
	      return "redirect:/photo";
	  }

	  
	  @RequestMapping("/cateModify")
	  public String cateModify(@RequestParam HashMap<String, String> param, HttpSession session) {
		  log.info("@# PhotoController.cateModify() start");
	      log.info("@#@@#@#@#@#param"+param);
	      
	      // 카테고리 수정 서비스 호출
	      photoService.cateModify(param);
		  
	      log.info("@# PhotoController.cateModify() end");
	
	      return "redirect:/photo";
	  }
	
	  @RequestMapping("/cateDelete")
	  public String cateDelete(@RequestParam HashMap<String, String> param) {
	      // 카테고리 삭제 서비스 호출
		  photoService.cateDelete(param);
	
	      return "redirect:/photo";
	  }
}
