package anno.type01;

public class Calculator {

	public Calculator() {
		System.out.println("Calculator : " + this);
	}

	public void addition(int n1, int n2) {
		System.out.println("Addition : " + (n1 + n2));
	}

	public void subtraction(int n1, int n2) {
		System.out.println("Subtraction : " + (n1 - n2));
	}

	public void multiplication(int n1, int n2) {
		System.out.println("Multiplication : " + (n1 * n2));
	}

	public void division(int n1, int n2) {
		System.out.println("Division : " + (n1 / n2));
	}

}
