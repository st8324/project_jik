package day6;

public class MethodEx1 {

	public static void main(String[] args) {
		//메소드 예제
		//메소드명(값);
		System.out.println(add(1,2));
		add2(1,2);
		printMultiTable(8);
		printMultiTable(5);
		int num1 = 8, num2 = 12;
		int res = gcd(num1, num2);
		System.out.println(num1 + "와 " +num2+"의 최대 공약수 : " + res);
		System.out.println(calculate(1, '/', 2));
	}
	/* 기능    : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드 
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 정수의 합 => 정수 => int
	 * 메소드명 : add
	 * */
	public static int add(int num1, int num2) {
		int res = num1 + num2;
		return res;
	}
	/* 기능    : 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드 
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 없음 => void
	 * 메소드명 : add2
	 * */
	public static void add2(int num1, int num2) {
		int res = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + res);
	}
	/* 기능	  : 두 정수와 산술 연산자가 주어지면 두 정수의 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수와 산술 연산자=> int num1, char op, int num2
	 * 리턴타입 : 산술 연산 결과 => 실수 => double
	 * 메소드명 : calculate 
	 * */
	public static double calculate(int num1, char op, int num2) {
		double res = 0.0;
		switch(op) {
		case '+':	res = num1 + num2;	break;
		case '-':	res = num1 - num2;	break;
		case '*':	res = num1 * num2;	break;
		case '%':	res = num1 % num2;	break;
		case '/':	res = (double)num1 / num2;	break;
		}
		return res;
	}
	/* 기능 	  : 두 정수의 최대 공약수를 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 최대 공약수 => 정수 => int
	 * 메소드명 : gcd
	 * */
	public static int gcd(int num1, int num2) {
		int i, gcd = 1;
		for(i = 1 ; i <= num1 ; i += 1) {
			if(num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}
	/* 기능 	  : num단을 출력하는 메소드
	 * 매개변수 : 정수 num => int num
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printMultiTable
	 * */
	public static void printMultiTable(int num) {
		int i;
		System.out.println(num + "단");
		for(i=1 ; i<=9 ; i+=1 ) {
			System.out.println(num + " x " + i + " = " + num * i);
		}
	}
	
}
