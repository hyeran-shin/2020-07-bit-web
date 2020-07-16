package com.bit.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mysite.repository.BoardDao;
import com.bit.mysite.vo.BoardVo;

@Service
public class BoardService {
	private static final int LIST_SIZE = 5; // 게시물 개수
	private static final int PAGE_SIZE = 5; // 페이지 개수
	
	@Autowired
	private BoardDao boardDao;
	
	public boolean writeMessage(BoardVo boardVo) {
		Integer groupNo = boardVo.getGroupNo();
		
		if(groupNo != null) {
			Integer orderNo = boardVo.getOrderNo();
			Integer depth = boardVo.getDepth();
			
			boardDao.increaseGroupOrder(groupNo, orderNo);
			boardVo.setOrderNo(orderNo + 1);
			boardVo.setDepth(depth + 1);
		}
		
		return boardDao.insert(boardVo) == 1;
	}
	
	public Map<String,Object> getMessageList(int cPage, String keyword){
		
		int totalCount = boardDao.getTotalCount(keyword);
		int pageCount = (int) Math.ceil((double)totalCount / LIST_SIZE);
		int blockCount = (int) Math.ceil((double)pageCount / PAGE_SIZE);
		int currentBlock = (int) Math.ceil((double)cPage / PAGE_SIZE);
		
		if(cPage < 1) {
			cPage = 1;
			currentBlock = 1;
		}else if(cPage > pageCount ) {
			cPage = pageCount;
			currentBlock = (int) Math.ceil((double)cPage / PAGE_SIZE);
		}
		
		int beginPage = (currentBlock == 0) ? 1 : (currentBlock -1) * PAGE_SIZE + 1;
		int prevPage = (currentBlock > 1) ? (currentBlock-1) * PAGE_SIZE : 0;
		int nextPage = (currentBlock < blockCount) ? currentBlock * PAGE_SIZE + 1 : 0;
		int endPage = (nextPage > 0 ) ? (beginPage-1) + LIST_SIZE : pageCount;
		
		List<BoardVo> list = boardDao.getList(keyword, cPage, LIST_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", totalCount);
		map.put("listSize", LIST_SIZE);
		map.put("pageSize", PAGE_SIZE);
		map.put("currentPage", cPage);
		map.put("keyword", keyword);
		map.put("beginPage", beginPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("endPage", endPage);
		
		return map;
	}
	
	public BoardVo getMessage(int no) {
		BoardVo boardVo = boardDao.get(no);
		if(boardVo != null) {
			boardDao.updateHit(no);
		}
		return boardVo;
	}
	
	
	public boolean updateMessage(BoardVo vo) {
		return boardDao.update(vo) == 1 ; //성공여부 반환
	}
}











