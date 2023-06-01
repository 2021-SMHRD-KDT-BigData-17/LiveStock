package kr.or.livestock.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class board_info {

	private int board_id;
	private String board_category;
	private String board_title;
	private String board_content;
	private String board_file;
	private String board_dt;
	private String user_id;
	private int board_views;
	
}
