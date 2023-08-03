package com.cy;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cy.dto.ContentDto;
import com.cy.dto.MainDto;
import com.cy.dto.MemDto;
import com.cy.service.MainService;
import com.cy.service.MemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

	@Autowired
	private MainService service;

	@Autowired
	private MemService memService;

	 @RequestMapping("/home")
	 public String home(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
		 log.info("@#@#param"+param);
		 
		 MemDto memDto = (MemDto) session.getAttribute("memDto");
		 MainDto mainDto;
		 
		 if (param.get("guestId") == null) {
			 mainDto = service.home(memDto.getId());
		}else {
			mainDto = service.home(param.get("guestId"));
		}
		 
		 if (!memDto.getId().equals(mainDto.getId())) {
			 service.totalPlus(mainDto.getMainID());
		}
		 
		 model.addAttribute("mainDto", mainDto);
		 model.addAttribute("memDto", memDto);
		 session.setAttribute("today", service.today(mainDto.getMainID()));
		 session.setAttribute("total", service.total(mainDto.getMainID()));
		 
		 String hostId = mainDto.getId();
		 
		 ArrayList<ContentDto> newList = service.newList(hostId);
		 ArrayList<ContentDto> newList2 = new ArrayList<ContentDto>();
		 
		 int max = Math.min(newList.size(), 4);
		 for (int i = 0; i < max; i++) {
			newList2.add(newList.get(i));
		}
		 log.info("@#newList"+newList);
		 log.info("@#newList2"+newList2);
		 model.addAttribute("newList", newList2);
		 model.addAttribute("todayDiary", service.todayDiary(hostId));
		 model.addAttribute("totalDiary", service.totalDiary(hostId));
		 model.addAttribute("todayVisit", service.todayVisit(hostId));
		 model.addAttribute("totalVisit", service.totalVisit(hostId));
		 model.addAttribute("todayPhoto", service.todayPhoto(hostId));
		 model.addAttribute("totalPhoto", service.totalPhoto(hostId));
		 
		 session.setAttribute("mainDto", mainDto);
		 
		 param.put("id", "yeju");
		 session.setAttribute("yeju", memService.loginYn(param));

		 param.put("id", "rerere");
		 session.setAttribute("rerere", memService.loginYn(param));
		 log.info("@#mainDto"+mainDto);

//		 세션유지시간 : 20분
		 session.setMaxInactiveInterval(1200);
		 return "home";
   }
//	 홈 버튼 눌렀을때 조회수 안올라가는 컨트롤러 ㅋㅋ
	 @RequestMapping("/home2")
	 public String home2(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
		 log.info("@#@#param"+param);
		 
		 MemDto memDto = (MemDto) session.getAttribute("memDto");
		 MainDto mainDto;
		 if (param.get("guestId") == null) {
			 mainDto = service.home(memDto.getId());
		}else {
			mainDto = service.home(param.get("guestId"));
		}
		
		 model.addAttribute("mainDto", mainDto);
		 model.addAttribute("memDto", memDto);
		 session.setAttribute("today", service.today(mainDto.getMainID()));
		 session.setAttribute("total", service.total(mainDto.getMainID()));
		 
		 String hostId = mainDto.getId();
		 
		 ArrayList<ContentDto> newList = service.newList(hostId);
		 ArrayList<ContentDto> newList2 = new ArrayList<ContentDto>();
		 
		 int max = Math.min(newList.size(), 4);
		 for (int i = 0; i < max; i++) {
			newList2.add(newList.get(i));
		}
		 
		 model.addAttribute("newList", newList2);
		 model.addAttribute("todayDiary", service.todayDiary(hostId));
		 model.addAttribute("totalDiary", service.totalDiary(hostId));
		 model.addAttribute("todayVisit", service.todayVisit(hostId));
		 model.addAttribute("totalVisit", service.totalVisit(hostId));
		 model.addAttribute("todayPhoto", service.todayPhoto(hostId));
		 model.addAttribute("totalPhoto", service.totalPhoto(hostId));
		 
		 session.setAttribute("mainDto", mainDto);
		 
		 param.put("id", "yeju");
		 session.setAttribute("yeju", memService.loginYn(param));

		 param.put("id", "rerere");
		 session.setAttribute("rerere", memService.loginYn(param));
		 log.info("@#mainDto"+mainDto);

//		 세션유지시간 : 20분
		 session.setMaxInactiveInterval(1200);
		 return "home";
   }

	@RequestMapping("/modifyTitle")
	public String modifyTitle(@RequestParam HashMap<String, String> param, HttpSession session) {
		log.info("@# /modify start");
		log.info("@#@#@#session"+session);
		MainDto mainDto = (MainDto) session.getAttribute("mainDto");
		
		log.info("@#mainDto"+mainDto);
		param.put("id", mainDto.getId());
		
		log.info("@# /param"+param);
		service.modifyTitle(param);
		
		return "redirect:/home";
	}

	@RequestMapping("/modifyContent")
	public String modifyContent(@RequestParam HashMap<String, String> param, HttpSession session) {
		log.info("@# /modify start");
		log.info("@#@#@#session"+session);
		MainDto mainDto = (MainDto) session.getAttribute("mainDto");
		
		log.info("@#mainDto"+mainDto);
		param.put("id", mainDto.getId());
		
		log.info("@# /param"+param);
		service.modifyContent(param);
		
		return "redirect:/home";
	}

	@RequestMapping("/modifyProfileImg")
	public String modifyProfileImg(@RequestParam HashMap<String, String> param) {
		service.modifyProfileImg(param);
		
		return "redirect:/home";
	}
	
}
