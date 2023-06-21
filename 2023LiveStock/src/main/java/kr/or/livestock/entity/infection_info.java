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
	
	@Override
	public String toString() {
		return "infection_info [infection_id=" + infection_id + ", livestock_id=" + livestock_id + ", disease_name="
				+ disease_name + ", infected_cnt=" + infected_cnt + ", infected_dt=" + infected_dt + "]";
	}
	
}
