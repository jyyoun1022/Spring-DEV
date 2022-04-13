package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum;
	
	private int size;
	
	private String type;
	private String keyword;
	
	
	public Criteria(){
		this(1,10);
	}
	
	public Criteria(int pageNum,int size) {
		this.pageNum=pageNum;
		this.size=size;
	}
	
	public int getSkip() {
		return (pageNum-1) * size;
	}
	
	public String[] getTypeArr() {
		
		return type == null? new String[] {} : type.split("");
	}
}
