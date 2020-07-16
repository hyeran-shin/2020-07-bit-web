package basic;

public class Unit {
	private String msg;
	
	public Unit() {
		System.out.println("Unit loading...");
		msg = "Hello Unit Object";
	}
	
	public void prnMsg() {
		System.out.println("Unit msg : " + msg);
	}
}
