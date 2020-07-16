package com.bit.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mysite.repository.UserDao;
import com.bit.mysite.vo.UserVo;

//빈 등록을 위한 service
@Service
public class UserService {

	@Autowired
	private UserDao userDao;	
	
	public void join(UserVo vo) {
		userDao.insert(vo);
	}
	
	public boolean emailExists(String email) {
		return (userDao.get(email) != null );
		// 이메일이 존재한다면, true
		// 존재하지 않는다면, false
	}
	
	public UserVo login(String email, String password) {
		UserVo userVo = null;
		userVo = userDao.get(email, password);
		return  userVo;
	}
	
	public UserVo getUser(Long no) {
		return userDao.get(no);
	}
	
	public int updateUser(UserVo vo) {
		return userDao.update(vo);
	}
	
	public int deleteUser(UserVo vo) {
		return userDao.delete(vo);
	}
}











