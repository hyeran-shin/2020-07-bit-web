package com.bit.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MeasureExceptionTimeAspect {
	
	/**
	 * 
	 *  [소프트웨어가 느린 대표적인 원인]
	 *  1. Front		: 화면 렌더링 및 복잡한 클라이언트단 로직 (비동기)
	 *  2. Back			: 복잡한 비즈니스 로직(메모리가 쌓이는 경우?) 및  데이터베이스 엑세스
	 *  3. Database		: 데이터베이스단 연산 및 네트워크
	 */
	/**
	 * AOP Proxy 관리 컨테이너 (Container, Context) 
	 * 컨테이너 : 스프링에 있는 것, 컨텍스트 : 우리가 설정하는 것
	 * 
	 * Controller (DispatcherSerlvet)	-> spring-servlet.xml
	 * Service, Repository 				-> applicationContext.xml
	 */
	// || : PointCut을 2개 이상 적용
	@Around("execution(  * *..controller.*.*(..)  ) || execution( * *..service.*.*(..) ) || execution( * *..repository.*.*(..) )" )
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		// 1. 메소드 수행 전(@Before)
		//	-> 기록 측정 시작
		StopWatch stopWatch = new StopWatch(); //springframework에서 제공해 주는 util
		stopWatch.start();
		
		// 2. 메소드 수행
		Object result = pjp.proceed();
		
		// 3. 메소드 수행 수
		//	-> 기록 측정 종료
		stopWatch.stop();
		
		// 클래스 이름 가져오기
		String className = pjp.getTarget().getClass().getName();
		// 메소드 이름 가져오기
		String methodName = pjp.getSignature().getName();
		
		// 출력할 내용 가공
		// -> 수행할 클래스와 메소드 이름을 멤버(접근 연산자) 표시처럼 붙이겠다.
		String taskName = className + "." + methodName;
		
		// Performance Time, 콘솔에 직접 출력
		System.out.println("[ExecutionTime][" + taskName +"] TaskTime : " + stopWatch.getTotalTimeMillis() +"ms");
		
		return result;
	}
}








