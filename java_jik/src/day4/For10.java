package day4;

import java.util.Scanner;

public class For10 {

	public static void main(String[] args) {
		/* 반복횟수가 정해져 있지 않은 예제
		 * 콘솔에서 q나 Q를 입력받을 때까지 반복하는 예제 
		 * */
		Scanner scan = new Scanner(System.in);
		
		char ch = 'a';
		for( ; ch != 'q' && ch != 'Q' ; ) {
			System.out.print("알파벳을 입력하세요(종료하려면 q/Q를 입력) : ");
			ch = scan.next().charAt(0);
		}
		scan.close();
	}

}
