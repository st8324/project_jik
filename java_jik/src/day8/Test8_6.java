package day8;

public class Test8_6 {

	public static void main(String[] args) {
		/* 5개짜리 배열에 같은 숫자가 2개가 있는지 없는지를 판별하는 코드를 작성하세요.
		 * 단, 숫자는 정렬되어 있다고 가정
		 * 예시 : 1 1 2 3 4
		 * 있음
		 * 예시 : 1 2 3 4 5
		 * 없음
		 * 예시 : 1 1 2 2 4
		 * 있음
		 * 예시 : 1 1 1 2 3
		 * 없음
		 * 예시 : 1 1 1 2 2
		 * 없음
		 * i번지의 값과 i+1번지의 값이 같으면 count를 1 증가
		 * 다르면
		 * 		count의 값이 2와 같으면 res를 true로 수정
		 * 		count를 1로 초기화
		 * 반복문 종료 후 
		 * 	count가 2와 같으면 res를 true로 수정
		 * 	res가 true이면 있음이라고 출력
		 * 	false이면 없음이라고 출력
		 * */
		int []arr = new int[] {1,1,1,2,2};
		int count = 1;
		//숫자가 2개 일치하는 경우가 있는지 없는지 알려주는 변수
		boolean res = false; 
		for(int i = 0; i < arr.length - 1 ; i+=1) {
			if(arr[i] == arr[i+1]) {
				count += 1;
			}else {
				if(count == 2) {
					res = true;
				}
				count = 1;
			}
		}
		if(count == 2) {
			res = true;
		}
		if(res) {
			System.out.println("있음");
		}else {
			System.out.println("없음");
		}
	}

}
