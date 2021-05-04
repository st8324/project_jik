package day7;

import java.util.Scanner;

public class BaseballGame2 {

	public static void main(String[] args) {
		/* 숫자 야구 게임을 메소드를 이용하여 구현하세요. 
		 * 앞에서 사용한 contains와 initRandomArray를 이용하고
		 * 필요하면 새로운 메소드를 만들어서 작성해보세요. */
		
		//컴퓨터가 랜덤으로 중복되지 않은 세수를 생성
		int []com = new int[3];
		int min = 1, max = 9;
		//메소드를 이용하여 배열에 랜덤으로 세 수를 저장(중복 x)
		init(com, min, max);
		//랜덤으로 생성된 컴퓨터 숫자 확인
		for(int tmp : com) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		//3S(맞출때)일 때까지 반복
		int strike = 0, ball = 0;
		int []user = new int[3];
		Scanner scan = new Scanner(System.in);
		do {
			//숫자 입력 : 반복문과 Scanner 이용하여 정수 3개 입력
			System.out.print("입력 : ");
			for(int i = 0; i<user.length; i+=1) {
				user[i] = scan.nextInt();
			}
			//스트라이크와 볼의 갯수를 셈
			//메소드를 이용하여 스트라이크 갯수를 셈
			//메소드를 이용하여 볼의 갯수를 셈
			strike = getStrike(com, user);
			ball = getBall(com,user);
			
			//스트라이크, 볼, 아웃을 판정
			//메소드를 이용하여 판정
			printResult(ball, strike);
		}while(strike < 3);
		scan.close();
	}
	/* 기능	  : 배열 arr에 0번지부터 count개까지 확인하여 정수 num가 있는지 없는지 
	 * 			알려주는 메소드 
	 * 매개변수 : 배열 arr, 갯수 count, 정수 num => int[]arr, int count, int num
	 * 리턴타입 : 있는지 없는지=>boolean
	 * 메소드명 : contains
	 * 설명	  : [1,2,3,4,5] 배열에서 처음부터 3개중에서 5이 있는지 없는지 확인 => X
	 * 			[1,2,3,4,5] 배열에서 처음부터 5개중에서 5이 있는지 없는지 확인 => O
	 * */
	public static boolean contains(int[]arr, int count, int num) {
		for(int i = 0; i < count ; i += 1 ) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	/* 기능	  : 배열 arr가 주어지면 주어진 배열에 min~max사이의 랜덤한 수를 생성하여
	 * 			중복되지 않게 저장하는 메소드
	 * 매개변수 : 배열 arr, 랜덤 범위(min~max)=> int[]arr, int min, int max
	 * 리턴타입 : 없음 => void
	 * 메소드명 : init
	 * */
	public static void init(int []arr, int min, int max) {
		int cnt = 0;//저장된 숫자의 개수
		while(cnt < arr.length) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			//배열 arr에 있는 값들을 cnt개를 r과 비교
			if(!contains(arr, cnt, r)) {
				arr[cnt] = r;
				cnt += 1;
			}
		}
	}
	/* 기능	  : 배열 arr1과 배열 arr2에서 같은 위치의 숫자를 비교하여 같은 숫자의
	 * 			갯수를 알려주는 메소드
	 * 매개변수 : 배열 arr1, 배열 arr2 => int []arr1, int []arr2
	 * 리턴타입 : 같은 숫자의 개수 => 정수 => int
	 * 메소드명 : getStrike
	 * 설명	  : [1 2 3] [3 4 5] => 0
	 * 			[1 2 3] [1 9 4] => 1
	 * */
	public static int getStrike(int []arr1, int []arr2) {
		int cnt = 0;
		for(int i=0; i<arr1.length; i +=1) {
			if(arr1[i] == arr2[i]) {
				cnt += 1;
			}
		}
		return cnt;
	}
	/* 기능	  : 배열 arr1과 배열 arr2에서 같은 자리가 아닌 수들 중에서 같은 숫자의
	 * 			개수를 알려주는 메소드
	 * 매개변수 : 배열 arr1, 배열 arr2=>int []arr1, int [] arr2
	 * 리턴타입 : 같은자리가 아닌 수들 중에서 같은 숫자의 개수 => 정수 =>int
	 * 메소드명 : getBall
	 * 설명	  : [1 2 3] [3 2 4] => 1 => 같은 숫자의 개수 - 스트라이크의수
	 * 									2 - 1 = 1
	 * */
	public static int getBall(int []arr1, int[]arr2) {
		int cnt = 0;//같은 숫자의 개수
		for(int i= 0; i<arr1.length; i+=1) {
			if(contains(arr2, arr2.length, arr1[i])) {
				cnt += 1;
			}
		}
		return cnt - getStrike(arr1, arr2);
	}
	/* 기능	  : ball과 strike의 수에 따라 결과를 출력하는 메소드 
	 * 매개변수 : ball, strike => int ball, int strike
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printResult
	 * */
	public static void printResult(int ball, int strike) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("O");
		}
		System.out.println();
	}
}


