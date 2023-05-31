package kr.or.livestock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class board_info {

	int board_id;
	String board_category;
	String board_title;
	String board_content;
	String board_file;
	String board_dt;
	String user_id;
	int board_views;
	
}
