package kr.or.livestock.mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import kr.or.livestock.entity.infection_info;
import kr.or.livestock.entity.livestock_info;
import kr.or.livestock.entity.vaccine_info;

@Mapper
public interface calandar_mapper {

	public List<livestock_info> load(Map<String, String> map);

	public List<livestock_info> vaccine_info(Map<String, String> map);
	
	public List<livestock_info> infection_info(Map<String, String> map);

	public int vaccine(vaccine_info vaccine);

	public int infection(infection_info infection);

	public List<livestock_info> find(String user_id);

}
