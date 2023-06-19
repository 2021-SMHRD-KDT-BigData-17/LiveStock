package kr.or.livestock.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import kr.or.livestock.entity.entrance_info;
import kr.or.livestock.mapper.entrance_info_mapper;

@Controller
public class farmingController {
	
	@Autowired
	entrance_info_mapper mapper;
	
	@RequestMapping("/farming")
	public void farming(Model model) {
		// user_id
		
		Object user_id = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		entrance_info entrance = mapper.load((String)user_id);
		
		model.addAttribute("entrance_info", entrance);
	}
	
	@RequestMapping("/farming.do")
	public String farmingDo(@RequestParam MultipartFile file, @RequestParam int entrance_id, Model model) {
		// flask > /farming.do > farming
		
		// flask if( 1 == 1){ request.post}
		
		int x = 0; // entrance_info
		
//		model.addAttribute("entrance_info", x);
		
		// file upload.
		
		// return
		
//		return "farming";
		
		String filename = file.getOriginalFilename();
		long size = file.getSize();
		
		System.out.println(filename + " " + size);
		
		String uploadPath = "/resources/UPLOAD/";
		
		if(!new File(uploadPath).exists()) {
			new File(uploadPath).mkdir();
		}
		
		String plate_photo = uploadPath + filename; // path
		
		try {
			file.transferTo(new File(plate_photo));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int check = mapper.path(plate_photo, entrance_id);
		
		System.out.println(check);
		
		return ""; // check
	}
}
