package kr.or.livestock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.livestock.mapper.entrance_info_mapper;

@Controller
public class farmingController {
	
	@Autowired
	entrance_info_mapper mapper;
	
	@RequestMapping("/farming")
	public void farming() {
		// user_id
		
	}
	
	@RequestMapping("/farming.do")
	public String farmingDo(Model model) {
		// flask > /farming.do > farming
		
		// file 업로드
		
		int x = 0; // entrance_info
		
		model.addAttribute("entrance_info", x);
		
		return "farming";
	}
}
