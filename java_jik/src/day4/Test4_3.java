package day4;

import java.util.Scanner;

public class Test4_3 {

	public static void main(String[] args) {
		/* 정수를 거꾸로 출력하는 코드를 작성하세요.
		 * 예시
		 * 정수를 입력하세요 : 1234
		 * 결과 : 4321
		 * 예시
		 * 정수를 입력하세요 : 120
		 * 결과 : 021
		 * 반복횟수 	: x
		 * 규칙성		: num를 10으로 나눈 나머지를 출력 
		 * 			  num에 num를 10으로 나눈 몫을 저장
		 * 			  num가 0이면 반복문을 종료
		 * 반복문 종료후 : 없음
		 * 1234 => 4를 출력 num = 123
		 * 123 => 3을 출력 num = 12
		 * 12 => 2를 출력 num = 1
		 * 1 => 1을 출력 num = 0
		 * 반복문 종료
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		System.out.print("결과 : ");
		scan.close();
		
		for( ; ; ) {
			System.out.print(num % 10);//num를 10으로 나눈 나머지를 출력;
			num = num / 10; //num에 num를 10으로 나눈 몫을 저장;
			if(num == 0) {
				break;
			}
		}
	}

}
