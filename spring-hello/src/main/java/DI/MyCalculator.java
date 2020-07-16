package DI;

public class MyCalculator {
	private int n1;
	private int n2;
	
	private Calculator calculator;
	
	public MyCalculator() {
		// 자바의 캡슐화 예시, 의존 주입과 상관이 없다.
		// 다른 객체를 감싸는 캡슐화
//		calculator = new CalculatorEN();
		
	}
	// 캡슐화 코드 예시
	public MyCalculator(int n1, int n2) {
		this();
		this.n1=n1;
		this.n2=n2;
	}
	
	// MyCalculator는 전달된 Calculator 객체에 의존하도록 만들겠다.
	// 	->* 즉, Calculator라는 인터페이스에 의존한다.
	public MyCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	// 의존 주입과 동시에 구현체 필드 값까지 전달
	public MyCalculator(int n1, int n2, Calculator calculator) {
		this.n1 = n1;
		this.n2 = n2;
		this.calculator = calculator;
	}
	
	// Setter를 활용한 의존성주입
	// UserMain02.java에서 my3에 사용
	public void setCalculator(Calculator calculator) {
		this.calculator=calculator;
	}
	
	
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}
	
	public void add() {
		calculator.addition(n1, n2);
	}
	public void sub() {
		calculator.subtraction(n1, n2);
	}
	public void mul() {
		calculator.multiplication(n1, n2);
	}
	public void div() {
		calculator.division(n1, n2);
	}
	
}
