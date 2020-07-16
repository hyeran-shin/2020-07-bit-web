package com.bit.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.vo.OrderVo;

@Repository
public class OrderDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertOrder(String pNo, String pName, String pCount, String price, int usersNo) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("pNo",Integer.parseInt(pNo));
		map.put("pName",pName);
		map.put("pCount",Integer.parseInt(pCount));
		map.put("usersNo",usersNo);
		map.put("price", price);
		
		sqlSession.insert("order.insertOrder", map);
	}
	
	public int selectOrderNo(String no) {
		return sqlSession.selectOne("order.selectCount" , no);
	}
	
	public List<OrderVo> allList(String no, int page, int size){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("no",no);
		map.put("page",page);
		map.put("size",size);
		
		return sqlSession.selectList("order.selectOrderList" , map );
	}
	
	public List<OrderVo> allList(int page, int size , String keyword){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("page",page);
		map.put("size",size);
		map.put("keyword",keyword);
		
		return sqlSession.selectList("order.selectOrderList" , map );
	}
	
	
	public void delete(String pNo, int no) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("pNo",pNo);
		map.put("no",no);
		sqlSession.delete("order.delete",map);
	}
	
	public List<Object>  seletTotal(int ono, int uno) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("ono",ono);
		map.put("uno",uno);
		return sqlSession.selectList("order.total", map);
	}
	
	
}













