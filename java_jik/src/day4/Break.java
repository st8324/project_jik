package day4;

import java.util.Scanner;

public class Break {

	public static void main(String[] args) {
		int i;
		for(i=1; i<=5; i+=1) {
			System.out.println("Hello");
			//if문 없이 break가 나오면 반복문을 쓴 의미가 없어진다.
			break;
		}
		for(i=1 ;  ; i+=1 ) {
			System.out.println(i);
			if(i==5) {
				break;
			}
		}
		char ch;
		Scanner scan = new Scanner(System.in);
		for( ; ; ) {
			System.out.print("문자를 입력하세요(종료하려면 q/Q 입력) : ");
			ch = scan.next().charAt(0);
			if(ch == 'q' || ch == 'Q') {
				break;
			}
		}
		scan.close();
	}

}
