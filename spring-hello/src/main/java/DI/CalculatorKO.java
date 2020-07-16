package DI;

public class CalculatorKO implements Calculator {

	public CalculatorKO() {
		System.out.println("CalculatorKO : " + this);
	}
	
	@Override
	public void addition(int n1, int n2) {
		System.out.println("덧셈 : " + (n1 + n2));
	}

	@Override
	public void subtraction(int n1, int n2) {
		System.out.println("뺄셈 : " + (n1 - n2));
		
	}

	@Override
	public void multiplication(int n1, int n2) {
		System.out.println("곱셈 : " + (n1 * n2));
	}

	@Override
	public void division(int n1, int n2) {
		System.out.println("나눗셈 : " + (n1 / n2));
	}

}
