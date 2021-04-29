package day4;

public class For11 {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 코드를 작성하세요. 
		 * 8의 배수 : 8, 16, 24, 32, ...
		 * 12의 배수 : 12, 24, 36, 48, ...
		 * 8과 12의 공배수 : 24, 48, 72, ...
		 * 8과 12의 최소 공배수 : 24
		 * 반복횟수 	: i는 1부터 두 수의 곱까지 1씩 증가
		 * 규칙성		: i가 num1의 배수이고 i가 num2의 배수이면 i를 출력 후 
		 *   		  반복문 종료
		 *   		  => i를 num1으로 나누었을 때 나머지가 0과 같고
		 *   			 i를 num2로 나누었을 때 나머지가 0과 같다면
		 *   			 i를 출력 후 반복문 종료 
		 * 반복문 종료 후 : 없음 
		 * */
		int i, num1 = 10000, num2 = 20000;
		for( i=1 ; i <= num1 * num2 ; i += 1 ) {
			if(i % num1 == 0 &&	i % num2 == 0) {
				System.out.println(i);
				break;
			}
		}
		/* 반복횟수 	: i는 num1부터 무한대로 i는 num1씩 증가
		 * 규칙성		: i가 num2의 배수이면 i를 출력후 반복문 종료 
		 * */
		for( i=num1 ;  ; i += num1 ) {
			if(i % num2 == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}
