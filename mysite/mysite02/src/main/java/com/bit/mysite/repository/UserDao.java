package com.bit.mysite.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.exception.UserDaoException;
import com.bit.mysite.vo.UserVo;

/*
 * 빈으로 생성되는 것은 똑같은데
 * 예외 생성이나 등이 차이가 있음
 * 
 * 	@Repository
 * 		DAO(Data Access Object)에서 발생하는 예외를,
 * 		스프링의 DataAccessException으로 처리하겠다.
 * 안해도 동작은 상관 없음.
 * 클래스가 생성되고 멤버를 사용하는 것이기 때문에
 * 차이점은 스프링에서 인식하는 것의 차이이다.
 * 
 * */


@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	// 사용자 등록
	public void insert(UserVo vo) {
		sqlSession.insert("user.insert",vo);
	}
	
	// 중복 이메일 체크
	public UserVo get(String email) {
		return sqlSession.selectOne("user.getByEmail",email);
	}
	
	// 인증(로그인), 사용자 정의 예외 발생시킬 것임
	public UserVo get(String email, String password) throws UserDaoException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("password",password);
		return sqlSession.selectOne("user.getByEmailAndPw",map);
	}
	
	// 사용자 정보 가져오기
	public UserVo get(Long no) {
		return sqlSession.selectOne("user.getByNo",no);
	}
	
	// 정보수정
	public int update(UserVo vo) {
		return sqlSession.update("user.update",vo);
	}
	
	// 회원 탈퇴
	public int delete(UserVo vo) {
		return sqlSession.delete("user.delete", vo);
	}
}









