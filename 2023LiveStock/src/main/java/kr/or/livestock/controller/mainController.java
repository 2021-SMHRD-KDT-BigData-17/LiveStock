package kr.or.livestock.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.livestock.entity.addr;
import kr.or.livestock.entity.user_info;
import kr.or.livestock.mapper.user_info_mapper;

@Controller
public class mainController {

	@Autowired
	user_info_mapper mapper;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping("/")
	public String main(Model model, RedirectAttributes reat) {
	
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal != null) {
			
			model.addAttribute("NN", (String)principal);
			
		}
        
		
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
	
//	@RequestMapping("/login.do")
//	public String loginDo(user_info user) {
//		
//		String user_id = user.getUser_id();
//		
//		user_info u = mapper.sign_in(user_id);
//		
//		System.out.println(u.getUser_id() + " " + u.getUser_pw());
//		
//		return "index";
//	}
	
	@RequestMapping("/register")
	public void register(Model model) {model.addAttribute("addr", new addr());}
	
	@RequestMapping("/register.do")
	public String registerDo(user_info user) {
		
		String addr = user.getAddr().getAddr1() +" "+ user.getAddr().getAddr1() +" "+ user.getAddr().getAddr1();
		
		System.out.println(user.getAddr().getAddr1() +" "+ user.getAddr().getAddr1() +" "+ user.getAddr().getAddr1());
		
		System.out.println(addr);
		
		user.setUser_farm_addr(addr);
		user.setUser_pw(bcryptPasswordEncoder.encode(user.getUser_pw()));
		
		int n = mapper.sign_up(user);
		
		System.out.println(n);
		
		return "index";
	}
	
	@RequestMapping("/logout")
	public void logout() {}

	@RequestMapping("/flask")
	public String flask(Model model, @RequestParam int n) {
		
		model.addAttribute("flask", n);
		
		return "flask";
	}
	@RequestMapping("/farming")
	public void farming() {}
	@RequestMapping("/calander")
	public void calander() {}
	
}
