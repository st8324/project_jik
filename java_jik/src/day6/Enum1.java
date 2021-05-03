package day6;

import java.util.Scanner;

public class Enum1 {

	public static void main(String[] args) {
		//열거형을 사용하지 않고 요일을 입력하고 출력하는 예제
		int today;
		System.out.print("요일을 입력하세요(1:월, 2:화, 3:수, 4:목, 5:금, 6:토, 7:일) : ");
		Scanner scan = new Scanner(System.in);
		today = scan.nextInt();
		switch(today) {
		case 1:	System.out.println("월요일입니다.");	break;
		case 2:	System.out.println("화요일입니다.");	break;
		case 3:	System.out.println("수요일입니다.");	break;
		case 4:	System.out.println("목요일입니다.");	break;
		case 5:	System.out.println("금요일입니다.");	break;
		case 6:	System.out.println("토요일입니다.");	break;
		case 7:	System.out.println("일요일입니다.");	break;
		}
		
		scan.close();
	}

}
