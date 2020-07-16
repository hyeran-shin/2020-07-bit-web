package DI;

public class UserMain02 {
	public static void main(String[] args) {
		// 외부
//		Calculator calculator = new CalculatorEN();
		Calculator calculator = new CalculatorKO();

		// Dependency Injection(의존성 주입)
		// : 외부에서 생성된 객체를 Constructor, Setter를 통해 설정
		// spring에서는 컨테이너에서 설정파일로 넣어준다. 여기서 calculator 넣는건 외부는 아니지만 나중에 spring에서 이렇게 해줌.
		// 의존성 주입

		// Strategy Pattern (전략 패턴)
		//	: 프로그램 수행 중 원하는 로직(알고리즘)을 선택하여, 해당 객체를 활용 (수행 흐름을 컨트롤 하게끔)
		//		-> 두 버전의 계산기(EN, KO)는 Calculator 인퍼테이스의 구현체
		//		-> *SOLID 중 5대 원칙 중 OCP, DIP 원칙을 지키는 형태
		//		ocp : 공통적인 부분을 추상화해라, dip : 의존관계 역전의 원칙, 해당클래스를 사용해서 끈근한 관계를 유지하지말고 인터페이스를 생성해서 인퍼테이스에 의존하도록
		// 								KO, EN 클래스를 사용하지 말고 interface를 사용해라 
		//		-> *의존 관계를 통해 상속 관계보다 느슨한 관계를 유지할 수 있다. 
		// 전략패턴으로 외부파일을 넣는것을 DI 라고 함?
		
		// 자바 생성자 DI
		MyCalculator my = new MyCalculator(calculator);
		my.setN1(7);
		my.setN2(3);
		my.add();
		my.sub();
		my.mul();
		my.div();
		
		// 자바 생성자 DI, 구현체 필드까지 전달
		MyCalculator my2 = new MyCalculator(7,3, calculator);
		my2.add();
		my2.sub();
		my2.mul();
		my2.div();

		
		// 자바 Setter DI -> Setter의 역할, Spring의 <property>활용
		MyCalculator my3 = new MyCalculator();
		my3.setCalculator(calculator);
		my3.setN1(7);
		my3.setN2(3);
		my3.add();
		my3.sub();
		my3.mul();
		my3.div();
		
	}
}
