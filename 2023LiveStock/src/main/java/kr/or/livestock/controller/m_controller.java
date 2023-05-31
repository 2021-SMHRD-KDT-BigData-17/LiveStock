package kr.or.livestock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.livestock.mapper.user_info_mapper;

@Controller
public class m_controller {

	@Autowired
	user_info_mapper mapper;
	
	@RequestMapping("/login")
	public String login() {
		
		mapper.sign_in();
		
		return "";
	}
	
}
