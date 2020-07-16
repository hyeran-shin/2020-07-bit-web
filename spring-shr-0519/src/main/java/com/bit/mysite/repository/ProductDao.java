package com.bit.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.vo.GalleryVo;
import com.bit.mysite.vo.ProductVo;

@Repository
public class ProductDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 상품 등록
	public void insertProduct(ProductVo vo) {
		sqlSession.insert("product.uploadProduct" , vo );
	}
	
	//사진업로드
	public void insertGallery(GalleryVo vo) {
		sqlSession.insert("gallery.uploadGallery", vo);
	}
	
	// no, count
	public int selectProductNo() {
		return sqlSession.selectOne("product.selectNo");
	}
	
	public int selectMax() {
		return sqlSession.selectOne("product.selectMax");
		
	}
	public List<ProductVo> allList(int page, int size){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page",page);
		map.put("size",size);
		return sqlSession.selectList("product.selectAllList", map);
	}
	
	//no 
	public ProductVo selectOneNo(int pNo) {
		return sqlSession.selectOne("product.selectOneNo", pNo);
	}
	
	public void updateProduct(ProductVo vo) {
		sqlSession.update("product.update" , vo);
	}
}
