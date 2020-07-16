package DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain03 {
	public static void main(String[] args) {
		// 스프링 생성자 DI
		@SuppressWarnings("resource")
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:diAppCtx01.xml");
		
		// 의존성 주입된 MYCalculator Bean 객체 가져오기
		MyCalculator my = (MyCalculator) ctx.getBean("myCalculator", MyCalculator.class);
		// "myCalculator" 	: Container(Context)에 등록한 Bean의 식별자(id)
		// getBean() 		: Container(Context)에 의해 생성되고 관리되는 자바 객체(bean)을 가져오겠다.
		
		my.setN1(7);
		my.setN2(3);
		my.add();
		my.sub();
		my.mul();
		my.div();
		
		
	}
}
