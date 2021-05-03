package day6;

import java.util.Scanner;

public class Enum2 {

	public static void main(String[] args) {
		//열거형을 사용하고 요일을 입력하고 출력하는 예제
		Week1 today = Week1.MONDAY;
		System.out.print("요일을 입력하세요(1:월, 2:화, 3:수, 4:목, 5:금, 6:토, 7:일) : ");
		Scanner scan = new Scanner(System.in);
		int itoday = scan.nextInt();
		today.setWeek(itoday);
		switch(today) {
		case MONDAY:	System.out.println("월요일입니다.");	break;
		case TUESDAY:	System.out.println("화요일입니다.");	break;
		case WEDNSEDAY:	System.out.println("수요일입니다.");	break;
		case THURSDAY:	System.out.println("목요일입니다.");	break;
		case FRIDAY:	System.out.println("금요일입니다.");	break;
		case SATURDAY:	System.out.println("토요일입니다.");	break;
		case SUNDAY:	System.out.println("일요일입니다.");	break;
		}
		scan.close();
	}
}
enum Week1{ 
	MONDAY(1), 
	TUESDAY(2), 
	WEDNSEDAY(3), 
	THURSDAY(4), 
	FRIDAY(5), 
	SATURDAY(6), 
	SUNDAY(7);
	private int week;
	
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	Week1(int week){
		this.week = week;
	}
}