package kr.or.livestock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class comment_info {

	int cmt_id;
	int board_id;
	int cmt_content;
	String cmt_dt;
	String user_id;
	
}
