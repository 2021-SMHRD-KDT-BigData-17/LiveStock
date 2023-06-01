package kr.or.livestock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class infection_info {

	private int infection_id;
	private int livestock_id;
	private String disease_name;
	private int infected_cnt;
	private String infected_dt;
	
}
