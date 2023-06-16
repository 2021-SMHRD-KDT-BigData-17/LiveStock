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
	
	@Override
	public String toString() {
		return "board_info [board_id=" + board_id + ", board_category=" + board_category + ", board_title="
				+ board_title + ", board_content=" + board_content + ", board_file=" + board_file + ", board_dt="
				+ board_dt + ", user_id=" + user_id + ", board_views=" + board_views + "]";
	}
	
	
}
