package kr.or.livestock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.livestock.entity.entrance_info;

@Mapper
public interface entrance_info_mapper {

	public List<entrance_info> load(String user_id);

	public int path(String plate_photo, int entrance_id);
	
	public int in(entrance_info entrance);
	
	public int out();

}
