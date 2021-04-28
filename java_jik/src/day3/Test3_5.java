package day3;

public class Test3_5 {

	public static void main(String[] args) {
		/* 월의 마지막일수를 출력하는 예제를 switch문으로 작성하세요.
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * */
		int month = 13;
		switch(month) {
		//month가 1,3,5,7,8,10,12일 때 같은 실행문을 실행
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.println(month + "월은 31일까지 있습니다.");
			break;
		case 2:
			System.out.println(month + "월은 28일까지 있습니다.");
			break;
		//month가 4,6,9,11일 때 11에 해당하는 실행문을 실행문을 실행
		//4,6,9일때는 실행문이 없음
		case 4: case 6: case 9: case 11:
			System.out.println(month + "월은 30일까지 있습니다.");
			break;
		default:
			System.out.println(month + "월은 올바른 달이 아닙니다.");
		}
	}

}
