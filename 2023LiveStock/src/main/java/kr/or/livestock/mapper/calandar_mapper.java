package kr.or.livestock.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import kr.or.livestock.entity.infection_info;
import kr.or.livestock.entity.livestock_info;
import kr.or.livestock.entity.vaccine_info;

@Mapper
public interface calandar_mapper {

	public List<livestock_info> load(String user_id);

	public int vaccine(Optional<vaccine_info> vaccine);

	public int infection(Optional<infection_info> infection);
}
