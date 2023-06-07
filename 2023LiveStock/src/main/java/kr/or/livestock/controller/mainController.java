package kr.or.livestock.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.livestock.entity.user_info;
import kr.or.livestock.mapper.user_info_mapper;

@Controller
public class mainController {

	@Autowired
	user_info_mapper mapper;
	
	@RequestMapping("/")
	public String main(Model model, RedirectAttributes reat) {
	
//		model.addAttribute("thymeleaf", 1);
		
//		int n = 1;
		
		return "index";
		
//		return "redirect:http://127.0.0.1:5000?n=" + n;
		
//		reat.addAttribute("n", n);
		
//		return "redirect:http://df91-35-239-131-236.ngrok-free.app?n=" + n;
		
//		return "redirect:https://ukjxrrnliw-496ff2e9c6d22116-5000-colab.googleusercontent.com";
		
//		return "redirect:https://ukjxrrnliw-496ff2e9c6d22116-5000-colab.googleusercontent.com/test";
	
	}
	
	@RequestMapping("/login")
	public void login() {}
	
	@RequestMapping("/login.do")
	public String loginDo(user_info user) {
		
		user_info u = mapper.sign_in(user);
		
		System.out.println(u.getUser_id() + " " + u.getUser_pw());
		
		return "index";
	}
	
	@RequestMapping("/registet")
	public void register() {}
	
	@RequestMapping("/register.do")
	public String registerDo(user_info user) {
		
		int n = mapper.sign_up(user);
		
		System.out.println(n);
		
		return "index";
	}

	@RequestMapping("/flask")
	public String flask(Model model, @RequestParam int n) {
		
		model.addAttribute("flask", n);
		
		return "flask";
	}
	
}
