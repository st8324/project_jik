package day4;

public class For13 {

	public static void main(String[] args) {
		/* 구구단 전체를 출력하는 코드를 작성하세요.
		 * */
		int num = 4, i;
		
		for( num = 2 ; num <= 9 ; num += 1 ) {
			//num단 출력
			for( i = 1 ; i <= 9 ; i += 1 ) {
				System.out.println(num + " x " + i + " = " + num * i);
			}
		}
	}
}
