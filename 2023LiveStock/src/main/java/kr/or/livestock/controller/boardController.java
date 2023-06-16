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
import kr.or.livestock.service.page;

@Controller
public class boardController {

	@Autowired
	board_info_mapper mapper;
	
	@RequestMapping({"/board", "/board/{page}"})
	public String board(@PathVariable(required=false) Integer page, Model model) {
//		String category = "general";
		
		int cPage = (page == null) ? 1 : page;
		
		int cnt = (mapper.count() == null) ? 0 : mapper.count();

		page pageInfo = new page(cnt, cPage);
		
//		List<board_info> list = mapper.load(category);
		List<board_info> list = mapper.load(pageInfo.getCPage());
		
		model.addAttribute("board", list);
		
		model.addAttribute("page", pageInfo);
		
//		return "board";
		
		return "board";
	}
	
//	@RequestMapping("/board/{page}")
//	public void board(@PathVariable int page, Model model) {
//		List<board_info> list = mapper.load(page);
//		
//		model.addAttribute("board", list);
//	}
	
	@RequestMapping("/boardedit/{board_id}")
	public String boardedit(@PathVariable int board_id, Model model) {
		board_info board = mapper.view(board_id);
		
		model.addAttribute("board", board);
		
		return "boardedit";
	}
	
	@RequestMapping("/boardedit.do/{board_id}")
	public String boardedit(@PathVariable int board_id, board_info board) {
		
		mapper.edit(board);
		
		return String.format("redirect:/boardview/%d", board_id);
	}
	
	@RequestMapping("/boardnotice")
	public void boardnotice(Model model) {
		String category = "notice";
		
		List<board_info> list = mapper.notice(category);
		
		model.addAttribute("list", list);
	}
	
	@RequestMapping("/boardview.do/{board_id}")
	public String boardview(@PathVariable int board_id, Model model) {
		
		board_info board = mapper.view(board_id);
		
		model.addAttribute("board", board);
		
		return "boardview";
	}
	
	@RequestMapping("/boardwrite")
	public void boardwrite() {}
	
	@RequestMapping("/boardwrite.do")
	public String boardwriteDo(board_info board) {
		
		board.toString();
		
		int board_id = mapper.write(board);
		
		System.out.println(board_id);
		
		// board_id
		
		return String.format("redirect:/boardview.do/%d", board_id);
	}
	
	@RequestMapping("/boarddelete")
	public String boarddelete() {
		
		return "redirect:/board";
	}
}
