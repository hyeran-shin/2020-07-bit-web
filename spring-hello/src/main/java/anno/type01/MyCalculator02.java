package anno.type01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyCalculator02 {
	private int n1;
	private int n2;

	private Calculator calculator;

	public MyCalculator02() {}

	//@Autowired Constructor DI
//	@Autowired
//	@Qualifier("type02")	-> error
	// 생성자의 한정자 사용
	// setter와 같이 그 형태가 정해져 있지 않다.
	//	-> 이름이 모두 동일한 생성자의 특징 때문에, 매개변수의 차이만 존재!
	// *생성자에 한정자 사용 시 매개변수(인자)에 활용을 해야한다.
	@Autowired
	public MyCalculator02(@Qualifier("type02") Calculator calculator) {
		this.calculator = calculator;
		System.out.println("Constructor DI ...");
	}
	
	// @Autowired Setter DI
	// @Autowired를 활용해 자동 연결을 하지만,
	// @Qualifier("...")를 추가해 대상을 식별할 수 있도록
	@Autowired
//	@Qualifier("type01") 
	// Qualifier 위에, 매개변수 둘다 가능
	public void setCalculator(@Qualifier("type01")Calculator calculator) {
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
