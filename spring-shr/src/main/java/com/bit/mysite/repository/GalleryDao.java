package com.bit.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.vo.GalleryVo;

@Repository
public class GalleryDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<GalleryVo> getImageList() {
		return sqlSession.selectList("gallery.getList");
	}
	
	public List<GalleryVo> getImageList(int number){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("number", number);
		return sqlSession.selectList("gallery.getList" , map);
	}
	
	public GalleryVo getImageOneList(int number){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("number", number);
		return 	sqlSession.selectOne("gallery.getOne" ,map);
	}
	
	public void deleteFile(int pNo, List<String> dFileName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pNo", pNo);
		map.put("dFileName", dFileName);
		sqlSession.selectOne("gallery.deleteFile" ,map);
	}
	
}
