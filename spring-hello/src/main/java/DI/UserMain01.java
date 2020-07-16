package DI;

public class UserMain01 {
	public static void main(String[] args) {
		// 기존 계산기를 만들었던 방법 (자바의 캡슐화)
		MyCalculator my = new MyCalculator(7,3);
		my.add();
		my.sub();
		my.mul();
		my.div();
		
		
	}
}
