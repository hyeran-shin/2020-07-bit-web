package com.bit.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 *  OOP (Object Oriented Programming) - 객체 지향 프로그래밍
 * 		- 목적 : 실제 프로그램 수행에 영향을 갖는 비즈니스 로직의 분리 (설계)
 *  AOP (Aspect Oriented Programming) - 관점 지향 프로그래밍
 *  	-	 실제 코딩과 관련이 없는 것들, 로거, 유저인증에 대한 보안측면?(세션을 통한 핸들링)
 *  	- 실제 실행과는 관련이 없는 부가적인 기능 등으 ㅣ분리 (로깅, 보안, 트랜잭션)을 어떻게 묶을것인지? 분리?, 트랜잭션이 얼마나 시간이 걸렸는지?를 분리시켜주겠다.
 *  	- 매번 기록했던 로그 소스들을 따로 분리하여 필요한 부분에 적용
 *  	- 제 3자의 관점에서 바라보는 시점, 비즈니스 로직에 영향이 없도록!
 *  	- 목적 : 관심의 분리, 
 *  	- 외부에서 특정 타겟에 관심을 부여하여 판별 (관심의 분리)
 * 	 	- 실제 서비스로직에서는 비즈니스 로직만 담게 된다.
 * 		- 횡단관심 코드 : 로그남겨주는 코드라고 생각
 * 		- 로그남기는 코드를 직접 남기지 않고 선언적으로 처리
 * 			-> 외부로 만들어 놓고 나서 외부의 관심을 어떤걸 할건지만 정해놓으면 수행된다.
 * 		
 * 
 * 		AOP 주요 개념
 * 			Target
 * 				- 부가기능(현재는 로그라고 생각)을 부여할 대상
 * 
 * 			JoinPoint
 * 				- 어드바이스가 적용될 포인트(위치, 시점)
 *				- 메소드 호출 전/후, 메소드 실행 중, 클래스 초기화 및 객체 생성 시점
 *
 *			PointCut
 *				- 어느 클래스의 어느 Join Point를 사용할 것인지 판별
 *				- Advice를 적용할 타겟을 선정
 *				- 원하는 패키지 이름 -> 클래스 이름 -> 메소드 이름 과 같이 식별을 시켜주겠다.
 *
 *			Advice
 *				- 실제 부가기능에 대한 구현체
 *				- 적용될 타겟에 영향을 미치지 않고, 부가 기능만 수행
 *				- 특정 Join Point에 실행되는 코드
 *				- before, after, around 로 지정해줄 수 있다.
 *
 *			Aspect
 *				- 핵심 기능에 독립된 부가기능을 적용하는 모듈
 *				- 부가될 구현체인 Advice와 적용할 타겟인 Point Cut의 조합
 *
 *			Proxy
 *				- 타겟을 감싸는 형태
 *				- 호출자가 타겟을 호출하면 프록시가 호출되는 형태
 *				- 타겟보다 먼저 호출되어 선후 처리 작업 수행
 *				
 *			Weaving
 *				- 타겟에 Aspect(PointCut, Advice)를 적용하여 감싸는 과정
 *				- PointCut에 의해 결정된 JoinPoint에 실제 구현체인 Advice를 적용
 *
 */

// Program
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ProductService service = ctx.getBean(ProductService.class); //bean 가져오기
		ProductVO vo = service.find("Computer");
		System.out.println(vo);
		
		((ConfigurableApplicationContext)ctx).close();
	}
}







