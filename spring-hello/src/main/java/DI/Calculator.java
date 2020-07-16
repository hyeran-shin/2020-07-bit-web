package DI;

// 추상화 - 하위 클래스의 공통 부분을 정의하고 분리
public interface Calculator {
	void addition(int n1, int n2);
	void subtraction(int n1, int n2);
	void multiplication(int n1, int n2);
	void division(int n1, int n2);
}
