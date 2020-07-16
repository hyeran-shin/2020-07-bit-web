package com.bit.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int increaseGroupOrder(Integer groupNo, Integer orderNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupNo", groupNo);
		map.put("orderNo", orderNo);
		
		return sqlSession.update("board.increaseOrderNo", map);
	}
	
	public int insert(BoardVo boardVo) {
		return sqlSession.insert("board.insert", boardVo);
	}
	
	public int getTotalCount(String keyword) {
		return sqlSession.selectOne("board.getTotalCount", keyword);
	}
	
	public List<BoardVo> getList(String keyword, Integer page, Integer size){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword",keyword);
		map.put("page",page);
		map.put("size",size);
		
		return sqlSession.selectList("board.getList",map);
	}
	
	public BoardVo get(int no) {
		return sqlSession.selectOne("board.getByNo", no);
	}
	
	public int updateHit(int no) {
		return sqlSession.update("board.updateHit", no);
	}
	
	public int update(BoardVo vo) {
		return sqlSession.update("board.update" , vo);
	}
	
	
}
