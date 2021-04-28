package day3;

import java.util.Scanner;

public class Test3_2 {

	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수가 0, 양수, 음수인지 판별하는
		 * 코드를 작성하세요.
		 * => 입력받은 정수가 0과 같다면 0이라고 출력하고,
		 *    (정수가 0과 같지 않고)입력받은 정수가 0보다 크다면 양수라고 출력하고,
		 *    입력받은 정수가 0보다 작다면 음수라고 출력하세요. 
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		if(num == 0) {
			System.out.println("0");
		} 
		else if(num > 0) {
			System.out.println("양수");
		} 
		else { //else if(num < 0) {
			System.out.println("음수");
		}
		
		scan.close();
	}

}
