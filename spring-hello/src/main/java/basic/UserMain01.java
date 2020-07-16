package basic;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain01 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
						"classpath:applicationContext.xml"
						);

		// 자바 application으로 실행
		
		// 식별자로 객체를 가져와 형 변환시켜준 것
		Unit obj = (Unit)ctx.getBean("unit01"); //Object 이기에 다운캐스팅
		System.out.println("Unit obj new : " + obj);
		obj.prnMsg();
		
		
		// 식별자와 어느 클래스인지 전달하여 객체 가져오기
		Unit obj2 = ctx.getBean("unit02",Unit.class);
		System.out.println("Unit obj2 new :" + obj2);
		obj2.prnMsg();
		
		// getBean() 호출 시 객체가 생성되는 것이 아니라,
		// 이미 생성된 객체를 가져올 뿐 -> 단일체 패던(단일 객체 참조, 싱글톤)
		Unit obj3 = ctx.getBean("unit01", Unit.class);
		System.out.println("Unit obj new : " + obj3); // 위에 obj = obj3 같다. 이미 생성된 객체 가져옴
		obj3.prnMsg();
				
		ctx.close();
		
	}
}
