package kr.or.livestock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.or.livestock.mapper.user_info_mapper;

@Controller
public class m_controller {

	@Autowired
	user_info_mapper mapper;
	
	
}
