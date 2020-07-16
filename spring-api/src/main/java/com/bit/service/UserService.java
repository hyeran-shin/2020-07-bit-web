package com.bit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bit.domain.User;

@Service
public class UserService {

	/**
	 * @Service 역할 :비즈니스 역할 분리하기 위한 것
	 * @Service
	 * 		- 기존 Controller에서 작성했던 비즈니스 로직 분리
	 * 		- Controller로 들어온 요청에 따른 로직 수행
	 * 		- 실제 DAO같은 로직을 수행하는 클래스
	 * 			-> 재사용 및 유지보수를 위한 분리(설계)
	 */
	public List<User> getAllUsers(){
		List<User> list = new ArrayList<>();
		User user = new User();
		user.setId(1L);
		user.setName("monster");
		user.setPhone("010-1234-5678");
		user.setEmail("real1@naver.com");
		user.setStatus(1);
		user.setProfilePic("...");
		list.add(user);

		user = new User();
		user.setId(2L);
		user.setName("Ultra");
		user.setPhone("010-4545-5678");
		user.setEmail("real2@naver.com");
		user.setStatus(1);
		user.setProfilePic("...");
		list.add(user);

		user = new User();
		user.setId(1L);
		user.setName("samsung");
		user.setPhone("010-7879-5678");
		user.setEmail("real3@naver.com");
		user.setStatus(1);
		user.setProfilePic("...");
		list.add(user);

		user = new User();
		user.setId(5L);
		user.setName("kakao");
		user.setPhone("010-0202-5678");
		user.setEmail("real4@naver.com");
		user.setStatus(1);
		user.setProfilePic("...");
		list.add(user);

		user = new User();
		user.setId(3L);
		user.setName("Citra");
		user.setPhone("010-0202-5678");
		user.setEmail("real4@naver.com");
		user.setStatus(1);
		user.setProfilePic("...");
		list.add(user);
		
		return list;
		
	}
	
}


