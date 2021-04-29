package day4;

public class For15 {

	public static void main(String[] args) {
		/* 100이하의 모든 소수를 출력하는 코드를 작성하세요. 
		 * 2 3 5 7 11 13 17 19 ...
		 * 기존 소수 판별 예제에서 출력 부분을 수정
		 *  => 소수이면 num를 출력하고 아니면 아무것도 안함
		 * */
		int num = 5, i, cnt = 0;
		/* num가 1일 때 약수의 갯수 cnt는 1이 계산
		 * 그리고 num가 2일 때 약수의 갯수를 구할 때 앞에서 구한 1의 약수의 갯수에다가
		 * 누적
		 * */
		for( num = 1 ; num <= 100 ; num += 1 ) {
			for( i = 1, cnt = 0 ; i <= num ; i += 1 ) {
				if(num % i == 0) {
					cnt += 1;
				}
			}
			if(cnt == 2) {
				System.out.print(num + " ");
			}
		}
	}
}
