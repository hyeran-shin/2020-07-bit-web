package basic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class UserMain02 {
	public static void main(String[] args) {
		Resource resource  = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		// getbean을 했을때 생성해서 가져온다.
		
		// BeanFactory는 getBean() 호출 시 생성되어 가져온다.
		// -> 처음 참조 시 생성하여 반환
		Unit obj = (Unit)factory.getBean("unit01");
		System.out.println(obj);
		obj.prnMsg();
		
		Unit obj2 = (Unit)factory.getBean("unit02");
		System.out.println(obj2);
		obj2.prnMsg();
		
		// 이전에 생성된 객체를 가져온다. -> 단일체 패턴
		Unit obj3 = (Unit)factory.getBean("unit01");
		System.out.println(obj3);
		obj3.prnMsg();
		
	}
}
