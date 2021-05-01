package etc;

import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		/* 숫자 야구 게임 
		 *  - 1 ~ 9 사이의 중복되지 않은 3개의 정수를 랜덤으로 생성
		 *  - B : 숫자는 있지만 위치는 다른 경우
		 *  - S : 숫자도 있고, 위치가 같은 경우
		 *  - O : 일치하는 숫자가 하나도 없는 경우
		 *  예시 : 3 9 5
		 *  입력 하세요 : 1 2 3
		 *  1B
		 *  입력 하세요 : 4 5 6
		 *  1B
		 *  입력하세요 : 3 4 5
		 *  2S
		 *  입력하세요 : 3 5 9
		 *  1S2B
		 *  입력하세요 : 6 7 8
		 *  O
		 *  입력하세요 : 3 9 5
		 *  3S
		 *  정답입니다.
		 */
		int []com = new int[3];//컴퓨터가 랜덤으로 생성한 숫자를 저장하는 배열
		int []user = new int[3];//사용자가 입력한 숫자를 저장하는 배열
		int strike;//스트라이크 갯수
		int ball;//볼의 갯수
		int cnt = 0;//컴퓨터가 랜덤으로 생성한(중복되지 않은) 숫자를 배열에 저장한 갯수
		int min = 1, max = 9;//랜덤 숫자 범위
		int r;//랜덤으로 생성한 숫자를 저장할 변수
		int i, k;
		boolean isDuplicated; //배열에 중복된 값 있는지 확인
		//컴퓨터가 랜덤으로 중복되지 않게 숫자를 생성하여 배열에 저장하는 단계
		//배열에 저장된 숫자가 3개가 되면 반복문 종료하도록 조건식 설정
		while(cnt < 3) {
			r = (int)(Math.random()*(max-min+1) + min);//랜덤으로 숫자 생성
			//배열 com에 저장된 cnt개의 숫자들 중에서 r과 중복된 숫자가 있는지 체크
			isDuplicated = false;
			for(i = 0; i<cnt; i+=1) {
				if(com[i] == r) {
					isDuplicated = true;
				}
			}
			//중복된 숫자가 없으면 배열에 r을 추가 후 cnt를 1개 증가
			if(!isDuplicated) {
				com[cnt] = r;
				cnt += 1;
			}
		}
		
		//테스트용 : 컴퓨터가 생성한 숫자를 확인하는 용도로 게임 플레이시 해당 코드 주석처리
		for(i = 0; i<com.length; i+=1) {
			System.out.print(com[i] + " ");
		}
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		//3S일때까지 반복
		do {
			//사용자 숫자 입력 : 입력 시 중복된 숫자 입력하지 않을 거라고 가정
			System.out.print("입력하세요 : ");
			for(i = 0; i<3; i+=1) {
				user[i] = scan.nextInt();
			}
			
			//두 배열에서 같은 숫자가 있는지 확인하는데 같은 숫자의 갯수를 ball에 저장
			//이 때 찾은 같은 숫자의 갯수는 실제 ball의 갯수가 아니라 ball과 strike 갯수의 합
			ball = 0;
			for(i = 0; i<com.length; i+=1) {
				for(k=0; k<user.length; k+=1 ) {
					if(com[i] == user[k]) {
						ball++;
					}
				}
			}
			//strike 갯수 확인
			strike = 0;
			for(i = 0; i<com.length; i+=1) {
				if(com[i] == user[i]) {
					strike++;
				}
			}
			//ball 갯수 확인 : 같은 수의 갯수 - strike의 갯수
			ball = ball - strike;
			
			//결과 출력
			if(strike != 0) {
				System.out.print(strike+"S");
			}
			if(ball != 0) {
				System.out.print(ball+"B");
			}
			if(strike == 0 && ball == 0) {
				System.out.print("O");
			}
			System.out.println();
		}while(strike != 3);
		System.out.println("정답입니다.");
		scan.close();
	}

}
