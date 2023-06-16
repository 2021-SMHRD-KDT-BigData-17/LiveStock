package kr.or.livestock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.livestock.entity.infection_info;
import kr.or.livestock.entity.livestock_info;
import kr.or.livestock.entity.vaccine_info;
import kr.or.livestock.entity.wrapper;
import kr.or.livestock.mapper.calandar_mapper;

@Controller
public class calanderController {

	@Autowired
	calandar_mapper mapper;
	
	@RequestMapping("/calander")
	public void calander(Model model) {
		
		Object user_id = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		List<livestock_info> list = mapper.load((String)user_id); // user_id, calender date
		
		model.addAttribute("list", list);
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < list.size(); i++) {
			
			map.put(list.get(i).getLivestock_name(), list.get(i).getLivestock_cnt());
//			list.get(i).getLivestock_name();
//			list.get(i).getLivestock_cnt();
		}
		
//		List<livestock_info> livestock = mapper.get();
		
		model.addAttribute("livestock", map);
		
		//user_id
		
		
		
		//date info
	}
	
	@RequestMapping("/calandar.do")
	public String calanderDo(Optional<vaccine_info> vaccine, Optional<infection_info> infection) {
//		vaccine != null ? vaccine : infection
		
		int check = vaccine != null ? mapper.vaccine(vaccine) : mapper.infection(infection);
		
//		int check = wrapper.getVaccine() != null ? mapper.vaccine(vaccine) : mapper.infection(infection);
		
//		mapper.vaccine();
//		mapper.infection();
		
		return "redirect:/calander";
	}
}
