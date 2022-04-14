package org.zerock.domain;

import lombok.Data;

@Data
public class Ticket {

	private int tno;	//번
	
	private String owner;	//소유
	
	private String grade;	//등급
}
