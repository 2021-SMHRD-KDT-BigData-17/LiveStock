package kr.or.livestock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.livestock.entity.infection_info;
import kr.or.livestock.entity.vaccine_info;
import kr.or.livestock.mapper.calandar_mapper;

@Controller
public class calanderController {

	@Autowired
	calandar_mapper mapper;
	
	@RequestMapping("/calander")
	public void calander(Model model) {
		
		//user_id
	}
	
	@RequestMapping("/calandar.do")
	public String calanderDo() {
//		vaccine != null ? vaccine : infection
		
		return "redirect:/calander";
	}
}
