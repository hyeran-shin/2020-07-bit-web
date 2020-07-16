package anno.type01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain01 {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:annoAppCtx01.xml");
		MyCalculator01 my = ctx.getBean("myCalculator", MyCalculator01.class);
		my.setN1(7);
		my.setN2(3);
		my.add();
		my.sub();
		my.mul();
		my.div();
	}
}
