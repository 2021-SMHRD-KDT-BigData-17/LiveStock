package kr.or.livestock.controller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/boardedit/{board_id}")
	public void boardedit(@PathVariable int board_id, Model model) {
		board_info board = mapper.view(board_id);
		
		model.addAttribute("board", board);
	}
	
	@RequestMapping("/boardedit.do/{board_id}")
	public String boardedit(@PathVariable int board_id, board_info board) {
		
		mapper.edit(board);
		
		return String.format("redirect:/boardview/%d", board_id);
	}
	
	@RequestMapping("/boardnotice")
	public void boardnotice() {}
	
	@RequestMapping("/boardview.do/{board_id}")
	public void boardview(@PathVariable int board_id, Model model) {
		board_info board = mapper.view(board_id);
		
		model.addAttribute("board", board);
	}
	
	@RequestMapping("/boardwrite")
	public void boardwrite() {}
	
	@RequestMapping("/boardwrite.do")
	public String boardwriteDo(board_info board) {
		
		mapper.write(board);
		
		// board_id
		
		return String.format("redirect:/boardview.do/%d", board.getBoard_id());
	}
	

	
	
}
