package kr.or.livestock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class comment_info {

	private int cmt_id;
	private int board_id;
	private int cmt_content;
	private String cmt_dt;
	private String user_id;
	
}
