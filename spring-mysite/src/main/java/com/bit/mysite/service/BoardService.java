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
		// 그룹이 지어져 잉ㅆ으면 안에 쓰고 , 그룹안지어져있으면 새로 그룹생성?
		
		if(groupNo != null) {
			Integer orderNo = boardVo.getOrderNo();
			Integer depth = boardVo.getDepth();
			
			boardDao.increaseGroupOrder(groupNo, orderNo);
			boardVo.setOrderNo(orderNo + 1);
			boardVo.setDepth(depth + 1);
		}
		
		return boardDao.insert(boardVo) == 1;
	}
	
	public Map<String,Object> getMessageList(int currentPage, String keyword){
		// 1. 페이징을 위한 기본 데이터 가공
		// keyword가 없으면 전체 개수, 있으면 검색키워드에 맞는 개수 나옴
		int totalCount = boardDao.getTotalCount(keyword); 
		int pageCount = (int) Math.ceil((double)totalCount/ LIST_SIZE); // 총 몇개까지 나올꺼냐
		int blockCount = (int) Math.ceil((double)pageCount / PAGE_SIZE); // 블록 5단위로 총 2개
		int currentBlock = (int) Math.ceil((double)currentPage / PAGE_SIZE); // 블록 5단위로 현재의 첫번째5, 두번째 5 ,...
		
		// 게시물 조회 수가 12개 라면,
		// 페이지 번호 1번 -> 5개
		// 페이지 번호 2번 -> 5개
		// 페이지 번호 3번 -> 2개
		
		// 2. 파라미터 page 값 검증
		if(currentPage < 1) {
			currentPage = 1;
			currentBlock = 1;
		} else if (currentPage > pageCount) {
			currentPage = pageCount;
			currentBlock = (int) Math.ceil((double)currentPage / PAGE_SIZE);
		}
		
		// 3. 뷰에서 페이지 리스트를 렌더링 하기 위한 데이터 가공
		// 시작 페이지
		int beginPage = (currentBlock == 0) ? 1 : (currentBlock - 1) * PAGE_SIZE + 1;
		// 이전페이지
		int prevPage = (currentBlock > 1) ? (currentBlock -1 ) * PAGE_SIZE : 0;
		// 다음 페이지
		int nextPage = (currentBlock < blockCount) ? currentBlock * PAGE_SIZE + 1 : 0;
		// 마지막 페이지
		int endPage = (nextPage > 0 ) ? (beginPage -1) + LIST_SIZE : pageCount;
		
		// 4. 리스트 가져오기
		List<BoardVo> list = boardDao.getList(keyword, currentPage, LIST_SIZE);
		
		// 5. 맵에 리스트 정보 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", totalCount);
		map.put("listSize", LIST_SIZE);
		map.put("currentPage", currentPage);
		map.put("keyword", keyword);
		map.put("beginPage", beginPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("endPage", endPage);
		
		// 6. 맵 정보 반환
		return map;
	}
	
	public BoardVo getMessage(Long no) {
		BoardVo boardVo = boardDao.get(no);
		if(boardVo != null) {
			// 조회수 올리는 것 따로
			boardDao.updateHit(no);
		}
		return boardVo;
	}
	
	
	public boolean updateMessage(BoardVo vo) {
		return boardDao.update(vo) == 1 ; //성공여부 반환
	}
}











