package anno.type01;

import org.springframework.beans.factory.annotation.Autowired;

public class MyCalculator01 {
	private int n1;
	private int n2;

	private Calculator calculator;

	public MyCalculator01() {}
	
// @Autowired Constructor DI
	// 둘다 Autowired 붙였을 때 먼저 나온 것을 가져온다.?
//	@Autowired
	public MyCalculator01(Calculator calculator) {
		this.calculator = calculator;
		System.out.println("Constructor DI ...");
	}
	
	@Autowired
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
		System.out.println("Setter DI ...");
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
