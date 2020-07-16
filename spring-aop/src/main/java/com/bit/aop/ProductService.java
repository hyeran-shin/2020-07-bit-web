package com.bit.aop;

import org.springframework.stereotype.Service;

// 빈등록, service의 역할을 하는 빈을 등록
@Service
public class ProductService {

	/**
	 *  AOP 예제의 비즈니스 로직
	 *  순수 비즈니스 로직만 존재하는 형태
	 *  제 3자가 바라보는 형태로 AOP의 적용 여부가,
	 *  본 입장에서는 판단이 어렵다.
	 *  즉, 관점(관심) 지향이랑 밖에서 바라보는 제 3자의 입장이다
	 */
	
	//Target Method(타켓 메소드)
	public ProductVO find(String name) {
		// 비즈니스 로직
		System.out.println("Target Method find(..) Called [name = " + name + "]");

		// 실행 시 강제 예외 발생!
		//Servoce 또는 DAO 관련 예외
//		if( 1 - 1 ==0 ) {
//			
//			throw new RuntimeException("find() Method Exception!!!");
//		}
		
		return new ProductVO(name);
	}
}
