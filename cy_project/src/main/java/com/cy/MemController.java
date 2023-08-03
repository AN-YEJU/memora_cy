package com.cy;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cy.dto.MemDto;
import com.cy.service.MainService;
import com.cy.service.MemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
	
	@Autowired
	private MemService service;
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping("/login")
	public String login() {
		log.info("@# login");
		
		return "login";
	}
	
	@RequestMapping("/login_yn")
	public String login_yn(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
		log.info("@# login_yn");
		
		MemDto memDto = service.loginYn(param);
		
		if (memDto == null) {
			return "redirect:login";
		} else {
			if (param.get("pwd").equals(memDto.getPwd())) {
				log.info("@# memDto"+memDto);
			    session.setAttribute("memDto", memDto);
			    model.addAttribute("memDto", memDto);
				return "login_ok";
			} else {
				return "redirect:login";
			}
		}
	}
	
	@RequestMapping("/login_ok")
	public String login_ok() {
		log.info("@# login_ok");
		
		return "login_ok";
	}
	
	@RequestMapping("/register")
	public String register() {
		log.info("@# register");
		
		return "register";
	}
	
//	유저등록
	@RequestMapping("/registerOk")
	public String registerOk(@RequestParam HashMap<String, String> param) {
		log.info("@# registerOk");
		
		log.info("@# param" + param);
		
		service.write(param);
		param.put("mainTitle", param.get("name")+"님의 미니홈피");
		mainService.register(param);
		
		return "redirect:login";
	}
	
}