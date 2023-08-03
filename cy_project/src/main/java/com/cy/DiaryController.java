package com.cy;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cy.dto.Criteria;
import com.cy.dto.DiaryDto;
import com.cy.dto.MainDto;
import com.cy.dto.MemDto;
import com.cy.dto.PageDto;
import com.cy.service.DiaryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DiaryController {
	
	@Autowired
	private DiaryService diaryService;
	
	@RequestMapping("/diary")
	public String diary(Model model, Criteria cri, HttpSession session) {
  	log.info("@# diary");
		log.info("@# cri===>"+cri);
	
      // 다이어리 리스트를 가져옴
      MainDto mainDto = (MainDto) session.getAttribute("mainDto");
      cri.setHostId(mainDto.getId());
      
      ArrayList<DiaryDto> diary = diaryService.diary(cri);
      
		int total = 0;
		try {
			total = diary.get(0).getCount();
		} catch (Exception e) {
		}
      
      log.info("@# list ===>"+ diary);
      model.addAttribute("diary", diary);
      model.addAttribute("pageMaker", new PageDto(total, cri));

      return "diary";
  }
	  
	  @RequestMapping("/diaryWrite")
	  public String diaryWrite(@RequestParam HashMap<String, String> param, HttpSession session) {
	      log.info("@# DiaryController.write() start");
	      log.info("@#@@#@#@#@#param"+param);
	      
	      MemDto memDto = (MemDto) session.getAttribute("memDto");
	      param.put("hostId", memDto.getId());
	      
	      // 다이어리 작성 서비스 호출
	      diaryService.diaryWrite(param);
	      
	      log.info("@# DiaryController.write() end");
	
	      return "redirect:/diary";
	  }
	
	  @RequestMapping("/diary_writeView")
	  public String diaryWriteView() {
	      return "diary_writeView";
	  }
	
	  @RequestMapping("/diary_view")
	  public String diaryView(@RequestParam HashMap<String, String> param, Model model) {
	      // 다이어리 내용 가져옴
	      DiaryDto dto = diaryService.diaryView(param);
	      log.info("@# dto"+dto);
	      model.addAttribute("diary_view", dto);
	
	      return "diary_view";
	  }
	  
	  
	  @RequestMapping("/diaryModify")
	  public String diaryModify(@RequestParam HashMap<String, String> param, HttpSession session) {
		  log.info("@# DiaryController.diaryModify() start");
	      log.info("@#@@#@#@#@#param"+param);
	      
	      // 다이어리 수정 서비스 호출
		  diaryService.diaryModify(param);
		  
		  log.info("@# DiaryController.diaryModify() end");
	
	      return "redirect:/diary";
	  }
	
	  @RequestMapping("/diaryDelete")
	  public String diaryDelete(@RequestParam HashMap<String, String> param) {
	      // 다이어리 삭제 서비스 호출
		  diaryService.diaryDelete(param);
	
	      return "redirect:/diary";
	  }
	  
	  @RequestMapping("/diaryCommentWrite")
	  public String diaryCommentWrite(@RequestParam HashMap<String, String> param, HttpSession session, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
	      log.info("@# DiaryController.diaryCommentWrite() start");
	      log.info("@#@@#@#@#@#param"+param);
	      
	      MemDto memDto = (MemDto) session.getAttribute("memDto");
	      param.put("commenter", memDto.getId());
	      
//			페이지 이동시 뒤에 페이지번호, 글 갯수 추가
		  rttr.addAttribute("pageNum", cri.getPageNum());
		  rttr.addAttribute("amount", cri.getAmount());
			
	      // 다이어리 댓글 작성 서비스 호출
	      diaryService.diaryCommentWrite(param);
	      
	      log.info("@# DiaryController.diaryCommentWrite() end");
	
	      return "redirect:/diary";
	  }
	  
	  @RequestMapping("/diaryCommentDelete")
	  public String diaryCommentDelete(@RequestParam HashMap<String, String> param, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
	      // 다이어리 댓글 삭제 서비스 호출
		  diaryService.diaryCommentDelete(param);
	
//			페이지 이동시 뒤에 페이지번호, 글 갯수 추가
		  rttr.addAttribute("pageNum", cri.getPageNum());
		  rttr.addAttribute("amount", cri.getAmount());
		  
	      return "redirect:/diary";
	  }
}
