package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMain03 {
	public static void main(String[] args) {
		String xmlLocation = "classpath:applicationContext.xml";
		//classpath : JVM이 프로그램을 실행할 때, 클래스파일을 찾는 데 기준이 되는 파일 경로를 말하는 것
		
		// applicationContext 영역을 생각
		// 처음에 실행될 떄? 가지고 있어라 
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlLocation);

		//UnitMain01과 마찬가지로 생성된 Bean을 가져온다.
		Unit obj = (Unit) ctx.getBean("unit01");
		System.out.println("Unit obj new : " + obj);
		obj.prnMsg();

		
		Unit obj2 = ctx.getBean("unit02", Unit.class);
		System.out.println("Unit obj2 new :" + obj2);
		obj2.prnMsg();

		
		Unit obj3 = ctx.getBean("unit01", Unit.class);
		System.out.println("Unit obj new : " + obj3);
		obj3.prnMsg();
		
		// 응용프로그램 영역
//		ctx.close(); 제공되지 않음
		
	}
}
