package etc;

import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		/* 사용자 번호를 랜덤으로 생성하고, 당첨 번호를 입력 하면 당첨
		 * 등수를 출력하는 코드를 작성하세요. 
		 * - 사용자 번호 : 1~45사이의 수, 중복되지 않음, 6개
		 * - 당첨 번호 : 1~45사이의 수, 중복되지 않음, 6개 + 1개(보너스)
		 * - 1등 : 당첨번호 6개 일치
		 * - 2등 : 당첨번호 5개 + 보너스 번호 일치
		 * - 3등 : 당첨번호 5개 일치
		 * - 4등 : 당첨번호 4개 일치
		 * - 5등 : 당첨번호 3개 일치
		 * - 꽝  : 당첨번호 2개 이하
		 * */
		int []user = new int[6];
		int []lotto = new int[6];
		int bonus;
		int min = 1, max = 10;//등수 확인을 위해 범위를 1~10으로 좁혀서 테스트, 확인 완료되면 max를 45로 늘려야함
		//자동 생성 번호
		init(user, min, max);
		
		//당첨 번호 출력
		printArray(user);
		
		//당첨 번호 입력
		Scanner scan = new Scanner (System.in);
		System.out.print("당첨 번호를 입력하세요 : ");
		for(int i = 0;i<lotto.length; i+=1) {
			lotto[i] = scan.nextInt();
		}
		System.out.print("보너스 번호를 입력하세요 : ");
		bonus = scan.nextInt();
		
		//당첨 등수 확인
		printRank(user, lotto, bonus);
		scan.close();
	}
	public static boolean contains(int[]arr, int count, int num) {
		for(int i = 0; i < count ; i += 1 ) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	public static void init(int []arr, int min, int max) {
		int cnt = 0;
		while(cnt < arr.length) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			if(!contains(arr, cnt, r)) {
				arr[cnt] = r;
				cnt += 1;
			}
		}
	}
	/* 기능 	  : 배열의 값을 출력하는 메소드
	 * 매개변수 : 배열 => int []arr
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printArray
	 * */
	public static void printArray(int []arr) {
		for(int i = 0; i<arr.length; i+=1) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	/* 기능	  : 두 배열 중 같은 수가 몇개 있는지 알려주는 메소드
	 * 매개변수 : 두 배열 => int []arr1, int []arr2
	 * 리턴타입 : 같은 수의 갯수 => 정수 => int
	 * 메소드명 : getSameCount
	 * */
	public static int getSameCount(int []arr1, int []arr2) {
		int count = 0;
		for(int i = 0; i<arr1.length; i+=1) {
			if(contains(arr2, arr2.length, arr1[i])) {
				count+=1;
			}
		}
		return count;
	}
	/* 기능	  : 로또 당첨 등수를 알려주는 메소드
	 * 매개변수 : 생성번호, 당첨 번호, 보너스 => int []user, int []lotto, int bonus
	 * 리턴타입 : 등수 => 정수 => int (꽝은 0)
	 * 메소드명 : rank 
	 * */
	public static int rank(int []user, int []lotto, int bonus) {
		int count = getSameCount(user, lotto);
		int rank = 0;
		switch (count) {
		case 6:	rank = 1;	break;
		case 5: rank = contains(user, user.length, bonus)?2:3;	break;
		case 4:	rank = 4;	break;
		case 3:	rank = 5;	break;
		}
		return rank;
	}
	/* 기능 	  : 로또 당첨 등수를 출력하는 메소드
	 * 매개변수 : 생성번호, 당첨 번호, 보너스 => int []user, int []lotto, int bonus
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printRank
	 * */
	public static void printRank(int []user, int []lotto, int bonus) {
		int rank = rank(user,lotto,bonus);
		switch (rank) {
		case 1,2,3,4,5:
			System.out.println(rank + "등입니다. ");
			break;
		default:
			System.out.println("꽝입니다.");
		}
	}
}
