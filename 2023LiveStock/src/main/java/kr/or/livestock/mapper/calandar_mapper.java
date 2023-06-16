package kr.or.livestock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.livestock.entity.livestock_info;

@Mapper
public interface calandar_mapper {

	public List<livestock_info> load(String user_id);
}
