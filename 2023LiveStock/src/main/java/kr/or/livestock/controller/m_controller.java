package kr.or.livestock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.livestock.entity.user_info;
import kr.or.livestock.mapper.user_info_mapper;

@Controller
public class m_controller {

	@Autowired
	user_info_mapper mapper;
	
	@RequestMapping("/")
	public String main(Model model) {
	
		return "redirect:/resources/HTML/index.html";
	}
	
	@RequestMapping("/login")
	public String login(user_info user) {
		
		mapper.sign_in(user);
		
		return "redirect:/resources/HTML/index.html";
	}
	
	@RequestMapping("/register")
	public String register(user_info user) {
		
		int n = mapper.sign_up(user);
		
		System.out.println(n);
		
		return "redirect:/resources/HTML/index.html";
	}

}
