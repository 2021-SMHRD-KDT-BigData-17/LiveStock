package kr.or.livestock.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class page {
	private int total;
	private int start;
	private int end;
	private int page;
	private int cPage;
	
	public page(int cnt, int page) {
		 
		this.total = cnt%10 == 0 ? cnt/10 : cnt/10 + 1;
		this.start = (page-1)/10 + 1;
		this.end = total < 10 ? total : ((page-1)/10 + 1)*10;
		
		this.page = page;
		this.cPage = ((page - 1)/10) * 10;
		
	}
}
