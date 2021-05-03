package etc;

public class Divisor {

	public static void main(String[] args) {
		/* 이 예제는 5일차 수업에서 한 Array3예제를 업그레이드한 예제입니다. 
		 * 약수를 저장할 때 10개가 넘으면 배열을 새로 생성하여 크기를 넓히는 예제입니다.*/
		/* 정수 num의 약수를 배열에 저장한 후 출력하는 코드를 작성하세요.
		 * 반복횟수 	: i는 1부터 num보다 작거나 같을때까지 1씩 증가
		 * 규칙성		: num를 i로 나누었을 때 나머지가 0과 같으면
		 * 			  배열 cnt번지에 i를 저장 후
		 * 			  cnt를 1 증가 후
		 * 			  cnt가 10과 같으면 반복문 종료
		 * 반복문 종료 후 : 배열에 있는 값을 0번지부터 cnt개 출력  
		 * */
		int num = 144, i, k;
		int maxCnt = 2;//배열 최대 길이, 테스트를 위해 초기 배열 길이를 2로 함
		int []arr = new int [maxCnt];
		int cnt = 0;
		int []tmp;//새로 생성된 배열을 임시로 저장할 배열
		for( i = 1 ; i <= num ; i += 1 ) {
			if(num % i == 0) {
				arr[cnt] = i;
				cnt += 1;
				if(cnt == maxCnt) {
					//배열의 크기 증가
					maxCnt += 10;
					//새로운 배열 생성(기존 배열 크기에 10개 더 큰 배열)
					tmp = new int[maxCnt];
					//arr배열에 있는 내용을 tmp배열에 복사
					for(k=0; k<cnt; k+=1) {
						tmp[k] = arr[k];
					}
					//기존 배열을 새로운 배열로 연결
					arr = tmp;
				}
			}
		}
		for( i = 0 ; i < cnt ; i += 1 ) {
			System.out.print(arr[i] + " ");
		}

	}

}
