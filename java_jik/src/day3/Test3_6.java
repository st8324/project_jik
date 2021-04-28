package day3;

public class Test3_6 {

	public static void main(String[] args) {
		/* 1부터 10까지의 짝수들의 합을 구하는 예제
		 * */
		int i, sum = 0;
		for(i=2; i<=10; i+=2) {
			//sum += i;
			sum = sum + i;
		}
		System.out.println("1부터 10까지 짝수의 합 : " + sum);
	}
}
