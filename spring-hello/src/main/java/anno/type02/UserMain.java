package anno.type02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new GenericXmlApplicationContext("empAppCtx.xml");
		
		// @Component로 등록한 클래스 Development의 아이디는 development로 설정
		Development dev = (Development)ctx.getBean("development");
		dev.work();
	}
}
