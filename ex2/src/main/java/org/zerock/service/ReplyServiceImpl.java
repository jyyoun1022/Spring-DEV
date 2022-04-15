package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

	
	private final ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("register : "+vo);
		int count = mapper.insert(vo);
		return count;
	}

	@Override
	public ReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		log.info("get-RNO : "+rno);
		ReplyVO result = mapper.read(rno);
		return result;
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("modify : "+vo);
		int result = mapper.update(vo);
		return result;
	}

	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		log.info("Remove : "+rno);
		int result = mapper.delete(rno);
		return result;
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		log.info("Get List Of a Board : "+bno);
		List<ReplyVO> resultList = mapper.getListWithPaging(cri, bno);
		
		return resultList;
	}
	

	
}
