package anno.type02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Development {
	Employee employee;
	
	public Development() {
		System.out.println("Development...");
	}
	
	/**
	 * @Component를 활용해 등록한 Bean과 연결
	 * 	- Programmer Bean이 존재할 경우에만 본 생성자를 수행
	 * 	- @Autowired(required) 속성을 false로 두면 @Autowired(required=false)
	 * 	    필수 요구가 아니다.
	 * 	- 빈 생성 시 해당 생성자를 써야만 되는 것이 아니라, 기본 생성자 호출로 Bean 생성
	 * 		*빈 생성 시 의존 주입 여부에 대한 보장성
	 */
	
	@Autowired /*(required = false)*/
	public Development(@Qualifier(value="programmer") Employee employee) {
		this.employee = employee;
		System.out.println("Constructor DI...");
	}
	
	public void work() {
		employee.gotoOffice();
		System.out.println("작업을 시작합니다.");
		employee.gotoHome();
	}
}
