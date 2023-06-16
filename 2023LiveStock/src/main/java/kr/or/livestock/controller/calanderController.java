package kr.or.livestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.livestock.entity.infection_info;
import kr.or.livestock.entity.livestock_info;
import kr.or.livestock.entity.vaccine_info;
import kr.or.livestock.mapper.calandar_mapper;

@Controller
public class calanderController {

	@Autowired
	calandar_mapper mapper;
	
	@RequestMapping("/calander")
	public void calander(Model model) {
		
		Object user_id = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		List<livestock_info> list = mapper.load((String)user_id);
		
		model.addAttribute("list", list);
		
		//user_id
	}
	
	@RequestMapping("/calandar.do")
	public String calanderDo() {
//		vaccine != null ? vaccine : infection
		
		return "redirect:/calander";
	}
}
