package com.bit.mysite.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mysite.repository.OrderDao;
import com.bit.mysite.vo.OrderVo;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	private static final int LIST_SIZE = 5; // 게시물 개수
	private static final int PAGE_SIZE = 5; // 페이지 개수
	
	public void insertOrder(String pNo, String pName, String pCount, String price, int usersNo) {
		orderDao.insertOrder(pNo, pName, pCount, price, usersNo);
	}
	
	public void delete(String pNo, int no) {
		orderDao.delete(pNo, no);
	}
	
	public  List<Object>  totalList(int ono, int uno) {
		return orderDao.seletTotal(ono, uno);
	}
	
	
	public Map<String, Object> OrderUserList(String usersNo , int cPage, String keyword){
		
		int totalCount = orderDao.selectOrderNo(usersNo);
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
		
		List<OrderVo> list = new ArrayList<OrderVo>();
		if(keyword == null) {
			list = orderDao.allList(usersNo, cPage, LIST_SIZE);
		}else {
			list = orderDao.allList(cPage, LIST_SIZE, keyword);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("totalCount", totalCount);
		map.put("listSize", LIST_SIZE);
		map.put("currentPage", cPage);
		map.put("beginPage", beginPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("endPage", endPage);
		return map;
	}

}
