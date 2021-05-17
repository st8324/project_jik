package day15;

import java.util.Scanner;

public class ExceptionTest1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		//조건문을 이용하여 예외가 발생하지 않도록 처리
		if(num2 != 0) {
			int res = num1 % num2;
			//num2에 0을 입력하면 예외가 발생
			System.out.println(num1 + "을 " + num2 + "로 나눈 나머지 : " + res);
		}else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		int res = num1 % num2;
		//num2에 0을 입력하면 예외가 발생
		System.out.println(num1 + "을 " + num2 + "로 나눈 나머지 : " + res);
		scan.close();
	}

}
