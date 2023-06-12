package kr.or.livestock.controller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.livestock.entity.board_info;
import kr.or.livestock.mapper.board_info_mapper;

@Controller
public class boardController {

	@Autowired
	board_info_mapper mapper;
	
	@RequestMapping("/board")
	public void board(Model model) {
		
		List<board_info> list = mapper.load();
		
		model.addAttribute("board", list);
		
//		return "board";
	}
	
	@RequestMapping("/boardedit")
	public void boardedit() {}
	@RequestMapping("/boardnotice")
	public void boardnotice() {}
	@RequestMapping("/boardview")
	public void boardview() {}
	@RequestMapping("/boardwrite")
	public void boardwrite() {}
	
	@RequestMapping("/boardwrite.do")
	public String boardwriteDo(board_info board) {
		
		mapper.write(board);
		
		return "redirect:/boardview";
	}
	

	
	
}
