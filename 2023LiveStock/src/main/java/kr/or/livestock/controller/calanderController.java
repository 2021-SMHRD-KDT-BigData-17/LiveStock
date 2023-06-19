package kr.or.livestock.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		LocalDate date = LocalDate.now();
		
//		date.
		
		String year = Integer.toBinaryString(date.getYear());
		String month = date.getMonth().toString();
		
//		String calander = null;
		
		Map<String, String> map = new HashMap<>();
		
		map.put("user_id", (String)user_id);
		map.put("year", year);
		map.put("month", month);
		
		List<livestock_info> list = mapper.load(map); // user_id, calender date
		
		model.addAttribute("list", list);
		
		Map<String, Integer> map2 = new HashMap<>();
		
		for(int i = 0; i < list.size(); i++) {
			
			map2.put(list.get(i).getLivestock_name(), list.get(i).getLivestock_id());
//			list.get(i).getLivestock_name();
//			list.get(i).getLivestock_cnt();
		}
		
//		List<livestock_info> livestock = mapper.get();
		
		model.addAttribute("livestock", map2);
		
		//user_id
		
		
		
		//date info
	}
	
	@RequestMapping("/calander.do")
	public String calanderDo(Optional<vaccine_info> vaccine, Optional<infection_info> infection, @RequestParam String livestock_name) {
//		vaccine != null ? vaccine : infection
		
		Object user_id = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		List<livestock_info> livestock = mapper.find((String)user_id);
		
		int livestock_id = 0;
		
		for(int i = 0; i < livestock.size(); i++) {
			if(livestock.get(i).getLivestock_name() == livestock_name) {
				livestock_id = livestock.get(i).getLivestock_id();
				break;
			}
		}
		
		if(vaccine != null) {
			vaccine.get().setLivestock_id(livestock_id);
			mapper.vaccine(vaccine);
		}else {
			infection.get().setLivestock_id(livestock_id);
			mapper.infection(infection);
		}
		
//		int check = vaccine != null ? mapper.vaccine(vaccine) : mapper.infection(infection);
		
//		int check = wrapper.getVaccine() != null ? mapper.vaccine(vaccine) : mapper.infection(infection);
		
//		mapper.vaccine();
//		mapper.infection();
		
		return "redirect:/calander";
	}
}
