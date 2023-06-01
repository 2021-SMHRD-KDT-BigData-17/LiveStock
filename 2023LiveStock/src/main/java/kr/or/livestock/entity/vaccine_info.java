package kr.or.livestock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class vaccine_info {

	private int vaccine_id;
	private int livestock_id;
	private String vaccine_name;
	private int vaccine_cnt;
	private String vaccine_dt;
	private String vaccine_yn;
	private String reg_dt;
}
