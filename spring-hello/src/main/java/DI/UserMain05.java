package DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain05 {
	public static void main(String[] args) {
		// 스프링 Setter DI
		ApplicationContext ctx = new GenericXmlApplicationContext("diAppCtx03.xml");
		
	
		MyCalculator my = (MyCalculator) ctx.getBean("myCalculator", MyCalculator.class);
		
		my.add();
		my.sub();
		my.mul();
		my.div();
	}
}
