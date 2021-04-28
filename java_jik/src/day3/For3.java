package day3;

public class For3 {

	public static void main(String[] args) {
		/* 구구단 7단을 출력하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 9까지 1씩 증가
		 * 규칙성 : 7 x i = (7*i)를 출력
		 * 7 x 1 = 7
		 * 7 x 2 = 14
		 * ...
		 * 7 x 9 = 63
		 * */
		int i;
		for(i = 1; i<=9; i++) {
			System.out.println("7 x "+ i + " = " + 7 * i);
		}

	}

}
