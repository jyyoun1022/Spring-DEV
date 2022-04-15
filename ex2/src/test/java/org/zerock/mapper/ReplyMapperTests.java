package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr = {376L,375L,374L,373L,372L};

	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		
		log.info(mapper);
	}
	
	@Test
	public void testInsert() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글테스트"+i);
			vo.setReplyer("replyer"+i);
			
			mapper.insert(vo);
		});
	}
	@Test
	public void testRead() {
		
		Long targerRno = 5L;
		
		ReplyVO read = mapper.read(targerRno);
		
		log.info(read);
	}
//	@Test
//	public void testDelete() {
//		
//		mapper.delete(11);
//		
//	}
	@Test
	public void testUpdate() {
		
		Long targetRno=10L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update Reply");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT : "+count);
		
	}
	
	@Test
	public void testList() {
		
		Criteria cri= new Criteria();
		
		List<ReplyVO> repliesList = mapper.getListWithPaging(cri, bnoArr[0]);
		
		repliesList.forEach(reply -> log.info(reply));
	}
}
