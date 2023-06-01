package kr.or.livestock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class user_info {

	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_gender;
	private String user_phone;
	private String user_farm_addr;
	private String user_joindate;
	private String admin_yn;
	
}
