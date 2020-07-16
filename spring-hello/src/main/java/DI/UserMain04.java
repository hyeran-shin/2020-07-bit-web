package DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain04 {
	public static void main(String[] args) {
		// 스프링 생성자 DI, 필드(값)까지 설정
		@SuppressWarnings("resource")
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:diAppCtx02.xml");
		
		//BeanDefinitionStoreException
		//	: Bean 설정 파일에 대한 예외
		//	: Bean을 정의한 요소를 가진 XML 파일
		
		MyCalculator my = (MyCalculator) ctx.getBean("myCalculator", MyCalculator.class);
		
		my.add();
		my.sub();
		my.mul();
		my.div();
	}
}
