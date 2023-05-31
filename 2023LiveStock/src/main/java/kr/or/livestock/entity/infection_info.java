package kr.or.livestock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class infection_info {

	int infection_id;
	int livestock_id;
	String disease_name;
	int infected_cnt;
	String infected_dt;
	
}
