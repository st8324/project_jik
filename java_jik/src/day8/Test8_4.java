package day8;

public class Test8_4 {

	public static void main(String[] args) {
		/* - 1부터 10까지 한줄로 출력되는 코드를 작성하세요.
		 * 1 2 3 4 5 6 7 8 9 10 
		 * - 다음과 같이 되도록 코드를 작성하세요.
		 * 1 2 3 4
		 * 5 6 7 8
		 * 9 10
		 *   - 힌트 : 4의 배수일 때 엔터
		 * */
		for(int i = 1; i <= 10; i += 1) {
			System.out.print(i + " ");
			//i가 4의 배수이면 엔터를 출력
			//조건식 : i가 4의 배수이다 => i를 4로 나누었을 때 나머지가 0과 같다
			//실행문 : 엔터를 출력
			if(i % 4 == 0) {
				System.out.println();
			}
		}
		/* - 다음과 같이 되도록 코드를 작성하세요.
		 * 1,2,3,4
		 * 5,6,7,8
		 * 9,10,11,12
		 *   - 힌트 : 4의 배수이면 엔터를 출력, 4의 배수가 아니면 ,를 출력
		 * */
		System.out.println("\n------------");
		for(int i = 1; i <= 12; i += 1) {
			System.out.print(i);
			if(i % 4 == 0) {
				System.out.println();
			}else {
				System.out.print(",");
			}
			//String str = i%4 == 0 ? "\n" : ",";
			//System.out.print(str);
		}
		/* - 다음과 출력되도록 코드를 작성하세요.
		 * 2 1 4 3		1 2 3 4		+1 -1 +1 -1
		 * 6 5 8 7		5 6 7 8		+1 -1 +1 -1
		 * 10 9 12 11	9 10 11 12	+1 -1 +1 -1
		 * i가 홀수이면 i+1을 출력, i가 짝수이면 i-1를 출력
		 * */
		System.out.println("\n------------");
		for(int i = 1; i <= 12; i += 1) {
			//i가 홀수이면 i+1을 출력, i가 짝수이면 i-1를 출력
			if( i % 2 == 1) {
				System.out.print(i+1 +" ");
			}else {
				System.out.print(i-1 +" ");
			}
			
			if(i % 4 == 0) {
				System.out.println();
			}
		}
	}

}
