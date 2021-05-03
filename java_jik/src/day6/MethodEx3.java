package day6;

public class MethodEx3 {

	public static void main(String[] args) {
		int num1 = 10, num2 = 20;
		System.out.println(num1 + ", " + num2);
		swap(num1, num2);
		System.out.println(num1 + ", " + num2);
	}
	/* 기능 : 두 정수의 값을 바꾸는 메소드
	 * 매개변수 : 두 정수 =>int num1, int num2
	 * 리턴타입 : 없음=>void
	 * 메소드명 : swap
	 * */
	public static void swap(int num1, int num2) {
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
	}
}
