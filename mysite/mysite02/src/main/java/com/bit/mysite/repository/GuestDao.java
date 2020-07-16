package com.bit.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.vo.GuestVo;


@Repository
public class GuestDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(GuestVo guestVo) {
		sqlSession.insert("guest.insert", guestVo);
	}
	
	public List<GuestVo> selectAllList(int page, int size){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page",page);
		map.put("size",size);
		
		return sqlSession.selectList("guest.selectAllList" , map);
	}
	
	public int getTotalCount() {
		return sqlSession.selectOne("guest.getTotalCount");
	}
}
