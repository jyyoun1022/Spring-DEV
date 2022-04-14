package org.zerock.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value = "/getText" ,produces = "text/plain; charset=UTF-8")
	public String getText() {
		
		log.info("MIME TYPE : " +MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	@GetMapping(value ="/getSample" , produces = {MediaType.APPLICATION_JSON_VALUE,
													MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
			
		
		log.info("getSample....");
		return new SampleVO(123,"윤","재열");
	}
	
	@GetMapping("/getSample2")
	public SampleVO getSameple2(	) {
		return new SampleVO(125,"스타","로드");
	}
	
	@GetMapping("/getList")
	public List<SampleVO> getList()	{
		
		log.info("GetList");
		
		return IntStream.rangeClosed(1, 10).mapToObj(i->new SampleVO(i,i+"First",i+" Last")).collect(Collectors.toList());
	}
	
	
	

}
