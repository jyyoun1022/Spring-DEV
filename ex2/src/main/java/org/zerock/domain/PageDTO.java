package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage,endPage;
	private boolean prev,next;
	private int totalPage;
	private Criteria criteria;
	
	public PageDTO(Criteria criteria,int totalPage) {
		this.criteria =criteria;
		this.totalPage=totalPage;
		
		this.endPage=(int)(Math.ceil(criteria.getPageNum()/10.0))*10;
		
		// pageNum = 1 -> normal endpage = 10
		// Math.ceil(cr... / 10.0) = 1
		// cr,. = 1~10
		
		// pagenum = 13 -> normal endpage = 20
		// Math.ceil(cr .. / 10.0) = 2
		// cr .. = 11~20
		this.startPage=this.endPage-9;
		
		
		int realEnd =(int)(Math.ceil( (totalPage*1.0)/criteria.getSize()));
		
		if(realEnd<this.endPage) {
			this.endPage=realEnd;
		}
		this.prev = startPage>1;
		
		this.next = this.endPage < realEnd; 
	}
}
