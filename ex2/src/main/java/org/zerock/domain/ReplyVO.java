package org.zerock.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private Long rno;
	private Long bno;
	
	private String reply;
	private String replyer;
	private Date regDate;
	private Date modDate;
	
	
	
	

}
