package day2;

public class ArithmeticOperator {

	public static void main(String[] args) {
		// 산술연산자 / 예제
		System.out.println(" 1  / 2   = " + 1  / 2);
		System.out.println(" 1.0/ 2   = " + 1.0/ 2);
		System.out.println(" 1  / 2.0 = " + 1  / 2.0);
		System.out.println(" 1.0/ 2.0 = " + 1.0/ 2.0);
		int num1 = 1, num2 = 2;
		//num1을 일시적으로 실수로 변환하여 계산함
		System.out.println((double)num1 / num2);
		System.out.println("7 % 4 = " + 7 % 4);
		char ch = 65;
		// char + int =>int가 되어서 char에 그냥 저장할 수 없음
		// 강제 타입 변환을 해줘야 한다.
		ch = (char)(ch + 1);
		System.out.println(ch);
	}

}
