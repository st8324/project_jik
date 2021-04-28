package day3;

public class For6 {

	public static void main(String[] args) {
		/* 정수의 약수를 출력하는 코드를 작성하세요.
		 * 예시
		 * 정수를 입력하세요 : 6
		 * 1 2 3 6
		 * 정수 : num
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 		초기화 : i는 1부터
		 * 		조건식 : i는 num까지, i는 num보다 작거나 같다
		 * 		증감식 : i를 1씩 증가 
		 * 규칙성 : i가 num의 약수이면 i를 출력
		 *        => num를 i로 나누었을 때 나머지가 0과 같다면 i를 출력
		 * 반복문 종료 후 : 없음
		 * */
		int num = 12;
		int i;
		for(i = 1 ; i <= num ; i += 1 ) {
			if(num % i == 0 ) {
				System.out.print(i + " ");
			}
		}
	}
}
