package kr.or.livestock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.livestock.entity.board_info;

@Mapper
public interface board_info_mapper {

	public List<board_info> load();
	
	public int write(board_info board);
}