package com.bit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	/**
	 *  PointCut 기술 방법
	 *  execution ( 접근자 반환타입 패키지.클래스명(인터페이스).메소드명(인수) )
	 *  
	 *  @Before("execution( * *..*.ProductService.*(..) )")
	 *  	* 	: 와일드 카드
	 *  	..	: 패키지 와일드 카드
	 *  	(..): 인수 와일드 카드 -> 파라미터 개수, 형식, 순서 상관 없이 
	 *  
	 *  접근자, 예외 생략 가능
	 *  패키지명.클래스명 생략 가능
	 *  
	 */
	

	// @Before : 타켓 메소드가 호출되기 전에 수행
	// 반환타입이 ProductVO인 com.bit.aop.ProductService.find의 인자 수 상관없이 타겟메소드로 잡아라
//	@Before("execution( ProductVO com.bit.aop.ProductService.find(..) )")
//	@Before("execution( * com.bit.aop.ProductService.find(..) )") // 반환 타입이 여러개인 놈?
	@Before("execution( * *..*.ProductService.*(..) )") // 모든 메소드
	public void beforeAdvice() {
		System.out.println("[@Before Advice] Called...");
	}
	
	/**
	 * @Before				-> JoinPoint 언제
	 * "execution(...)"		-> PointCut  어디에
	 * beforeAdvide()		-> Advice	  무엇을, 이름 지어준 것임
	 * 
	 */
	
	
	/**
	 *  @After
	 *  	- 타켓 메소드가 호출된 후 수행
	 *  	- 수행 성공 여부와 관계없이 완료되면 수행
	 *  
	 */
	@After("execution( * *..*.ProductService.*(..) )")
	public void afterAdvice() {
		System.out.println("[@After Advice] Called...");
	}
	

	// @AfterReturning : 타겟 메소드가 정상적으로 반환됐을 경우 수행
	@AfterReturning("execution( * *..*.ProductService.*(..) )")
	public void afterReturningAdvice() {
		System.out.println("[@AfterReturning Advice] Called...");
	}
	
	// @AfterThrowing : 타켓 메소드가 수행 중 예외를 던지게 되면 수행
	@AfterThrowing("execution( * *..*.ProductService.*(..) )")
	public void afterThrowingAdvice() {
		System.out.println("[@AfterThrowing Advice] Called...");
	}

	
	/**
	 *  @Around
	 * 		- Advice가 타겟 메소드를 앞 뒤로 감싸서 호출 전과 호출 후를 구분
	 * 		- proceed() 메소드를 활용하여, 타겟 메소드를 수행	
	 */
	
	@Around("execution( * *..*.ProductService.*(..) )")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// @Before Advice
		System.out.println("[@Around Before Advice] Called...");
		
		// 1. PointCut이 되는  메소드 호출(파라미터 변경)
//		Object[] paramters = { "Phone" };
//		Object result = pjp.proceed(paramters);
		
		// 2. PointCut이 되는 메소드 호출(파라미터 그대로 전달)
		Object result = pjp.proceed();
		
		// @After Advice
		System.out.println("[@Around After Advice] Called...");
		
		
		return result;
	}
}



























