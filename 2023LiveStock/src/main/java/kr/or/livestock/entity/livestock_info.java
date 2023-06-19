package kr.or.livestock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class livestock_info {

	private int livestock_id;
	private String livestock_name;
	private int livestock_cnt;
	private String livestock_etc;
	private String user_id;
	
	private vaccine_info vaccine;
	private infection_info infection;
	
	private String calander;
	
}
