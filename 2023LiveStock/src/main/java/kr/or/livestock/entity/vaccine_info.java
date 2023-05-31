package kr.or.livestock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class vaccine_info {

	int vaccine_id;
	int livestock_id;
	String vaccine_name;
	int vaccine_cnt;
	String vaccine_dt;
	String vaccine_yn;
	String reg_dt;
}
