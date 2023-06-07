package kr.or.livestock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class boardController {

//	board_info_mapper mapper;
	
	@RequestMapping("/board")
	public void board() {}
	@RequestMapping("/boardedit")
	public void boardedit() {}
	@RequestMapping("/boardnotice")
	public void boardnotice() {}
	@RequestMapping("/boardview")
	public void boardview() {}
	@RequestMapping("/boardwrite")
	public void boardwrite() {}
	

	
	
}
