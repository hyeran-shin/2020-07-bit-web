package anno.type02;

import org.springframework.stereotype.Component;

@Component
public class Programmer implements Employee{

	public Programmer() {
		System.out.println("Programmer...");
	}
	
	@Override
	public void gotoOffice() {
		System.out.println("프로그래머 출근...");
	}

	@Override
	public void gotoHome() {
		System.out.println("프로그래머 퇴근!!!");		
	}

}
