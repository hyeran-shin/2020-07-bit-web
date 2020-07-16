package com.bit.mysite.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.exception.UserDaoException;
import com.bit.mysite.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public void insert(UserVo vo) {
		sqlSession.insert("user.insert", vo);
	}

	// 중복 이메일 체크
	public UserVo get(String email) {
		return sqlSession.selectOne("user.getByEmail", email);
	}

	public UserVo get(String email, String password) throws UserDaoException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("password", password);
		UserVo vo = sqlSession.selectOne("user.getByEmailAndPw", map);
		return vo;
	}

	// 사용자 정보 가져오기
	public UserVo getUser(int no) {
		return sqlSession.selectOne("user.getByNo", no);
	}

	// 정보수정
	public int update(UserVo vo) {
		return sqlSession.update("user.update", vo);
	}

	// 회원 탈퇴
	public int delete(UserVo vo) {
		return sqlSession.delete("user.delete", vo);
	}

}
