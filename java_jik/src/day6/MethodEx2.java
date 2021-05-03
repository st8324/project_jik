package day6;

public class MethodEx2 {

	public static void main(String[] args) {
		int [] arr = new int[] {1,2,3,4,5};
		printArray(arr);
		initArray(arr, 0);
		printArray(arr);
	}
	/* 기능	  : 정수 배열에 있는 모든 원소값을 출력하는 메소드
	 * 매개변수 : 정수 배열 => int [] arr / int arr[]
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printArray
	 * */
	public static void printArray(int []arr) {
		/* 향상된 for문
		 * - 배열이나 컬렉션프레임워크
		 * - 전체를 탐색
		 * - 수정이 아닌 경우
		 * */
		for( int tmp : arr ) {
			System.out.print(tmp + " ");
		}
		System.out.println();
	}
	/* 기능	  : 배열에 지정된 정수로 모두 초기화하는 메소드
	 * 매개변수 : 배열, 지정된 정수 => int []arr, int num
	 * 리턴타입 : 없음 => void
	 * 메소드명 : initArray
	 * */
	public static void initArray(int []arr, int num) {
		//예외 처리, 배열이 생성이 안된 경우 메소드를 종료
		if(arr == null) {
			return;
		}
		int i;
		for(i = 0; i<arr.length; i+=1) {
			arr[i] = num;
		}
	}
}
