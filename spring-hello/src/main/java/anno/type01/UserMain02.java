package anno.type01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain02 {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:annoAppCtx02.xml");
		
		/**
		 * annoAppCtx02.xml
		 * <bean id="myCalculator" class="anno.type01.MyCalculator02">
		 * 등록 후,
		 * getBean("myCalculator", MyCalculator.class)
		 * 다른 클래스를 가져오려 한다면,
		 * 요구되는 빈 정보(MyCalculator01)와 실제 빈의 정보(MyCalculator02)가 다르다
		 * 	-> BeanNotOfRequiredTypeException 
		 */
		
//		MyCalculator02 my = ctx.getBean("myCalculator", MyCalculator02.class);
		MyCalculator02 my = (MyCalculator02) ctx.getBean("myCalculator");
		my.setN1(7);
		my.setN2(3);
		my.add();
		my.sub(); 
		my.mul();
		my.div();
	}
}
