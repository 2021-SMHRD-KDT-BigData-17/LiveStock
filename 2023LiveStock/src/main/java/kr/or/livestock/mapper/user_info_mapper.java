package kr.or.livestock.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.livestock.entity.user_info;

@Mapper
public interface user_info_mapper {

	public user_info sign_in();
	
	public int sign_up();
	
}
