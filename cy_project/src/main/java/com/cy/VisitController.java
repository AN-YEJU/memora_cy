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
import com.cy.dto.MainDto;
import com.cy.dto.MemDto;
import com.cy.dto.PageDto;
import com.cy.dto.VisitDto;
import com.cy.service.VisitService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class VisitController {

	@Autowired
	private VisitService service;
	
	 @RequestMapping("/visit")
	 public String visit(Model model, Criteria cri, HttpSession session) {
		log.info("@# visit");
		log.info("@# cri===>"+cri);
		
		MainDto mainDto = (MainDto) session.getAttribute("mainDto");
		cri.setHostId(mainDto.getId());

		log.info("@# cri2===>"+cri);
		ArrayList<VisitDto> visit = service.visit(cri);
       
		int total = 0;
		try {
			total = visit.get(0).getCount();
		} catch (Exception e) {
		}
       
       log.info("@# visit ===>"+ visit);
       model.addAttribute("visit", visit);
       model.addAttribute("pageMaker", new PageDto(total, cri));

       return "visit";
   }
	 
		@RequestMapping("/visitWrite")
		public String visitWrite(@RequestParam HashMap<String, String> param) {
			log.info("@# param"+param);
			service.visitWrite(param);
			
			return "redirect:/visit";
		}

		@RequestMapping("/visitDelete")
		public String visitDelete(@RequestParam HashMap<String, String> param) {

			service.visitDelete(param);

			return "redirect:/visit";
		}
		
		 @RequestMapping("/visitCommentWrite")
		  public String visitCommentWrite(@RequestParam HashMap<String, String> param, HttpSession session, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		      log.info("@# VisitController.visitCommentWrite() start");
		      log.info("@#@@#@#@#@#param"+param);
		      
//				페이지 이동시 뒤에 페이지번호, 글 갯수 추가
			  rttr.addAttribute("pageNum", cri.getPageNum());
			  rttr.addAttribute("amount", cri.getAmount());
				
		      // 다이어리 댓글 작성 서비스 호출
		      service.visitCommentWrite(param);
		      
		      log.info("@# VisitController.visitCommentWrite() end");
		
		      return "redirect:/visit";
		  }
		  
		  @RequestMapping("/visitCommentDelete")
		  public String visitCommentDelete(@RequestParam HashMap<String, String> param, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		      // 다이어리 댓글 삭제 서비스 호출
			  service.visitCommentDelete(param);
		
//				페이지 이동시 뒤에 페이지번호, 글 갯수 추가
			  rttr.addAttribute("pageNum", cri.getPageNum());
			  rttr.addAttribute("amount", cri.getAmount());
			  
		      return "redirect:/visit";
		  }
}
