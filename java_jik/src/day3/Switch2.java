package day3;

import java.util.Scanner;

public class Switch2 {

	public static void main(String[] args) {
		/* 계절을 영어로 입력받아 입력받은 계절을 한글로 출력하는 예제
		 * 예시
		 * 계절을 영어로 입력하세요 : spring
		 * 봄입니다.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("계절을 영어로 입력하세요 : ");
		String season = scan.next();
		
		switch(season) {
		case "spring":
			System.out.println("봄입니다.");
			break;
		case "summer":
			System.out.println("여름입니다.");
			break;
		case "fall":
			System.out.println("가을입니다.");
			break;
		case "winter":
			System.out.println("겨울입니다.");
			break;
		default:
			System.out.println("잘못된 계절입니다.");
		}
		
		scan.close();
	}

}
