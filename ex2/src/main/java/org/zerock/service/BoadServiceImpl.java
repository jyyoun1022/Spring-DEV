package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@RequiredArgsConstructor
public class BoadServiceImpl implements BoardService{
	
	private final BoardMapper mapper;
	

	@Override
	public void register(BoardVO board) {
		
		log.info("register....."+board);
		
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("Read .........."+bno);
		 return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify........"+board );
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("getList........"+criteria);
		
		return mapper.getListWithPaging(criteria);
	}
	@Override
	public int getTotal(Criteria cri) {
		
		log.info("get Total count");
		
		return mapper.getTotalCount(cri);
	}
	
	
}
