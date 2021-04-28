package day3;

public class For4 {

	public static void main(String[] args) {
		/* 1부터 10까지의 짝수들만 출력하는 코드를 작성하세요. */
		int i;
		//방법1 : 1부터 10까지 다 확인 한 후 짝수들만 출력
		for(i=1; i<=10; i++) {
			//i가 짝수이면 i를 출력
			if(i % 2 == 0 ) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		//방법2 : 2부터 10까지 짝수들만 확인하고 출력
		for(i=2; i<=10; i=i+2) {
			System.out.print(i + " ");
		}
		System.out.println();
		//방법3 : 1부터 5에다가 곱하기 2를 출력
		for(i=1; i<=5; i++) {
			System.out.print(2*i + " ");
		}
	}

}
