package day2;

import java.util.Scanner;

public class Test2_2 {

	public static void main(String[] args) {
		/* 두 정수를 입력받아 입력받은 두 정수의 산술 연산 결과를 출력하는 예제
		 * 예시
		 * 두 정수를 입력하세요 : 1 2
		 * 1 + 2 = 3
		 * 1 - 2 = -1
		 * 1 * 2 = 2
		 * 1 / 2 = 0.5
		 * 1 % 2 = 1
		 *  */
		int num1, num2;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수를 입력하세요 : ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		System.out.println(num1 + " / " + num2 + " = " + ((double)num1 / num2));
		System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
		
		scan.close();
	}

}
