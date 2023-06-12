package kr.or.livestock.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.livestock.entity.user_info;

@Mapper
public interface user_info_mapper {

	public user_info sign_in(String user_id);
	
	public int sign_up(user_info user);
	
}
