package day7;

public class MethodEx7 {

	public static void main(String[] args) {
		int [] arr= new int[] {1,2,3,4,5};
		int num = 3;
		System.out.println(contains(arr, num, arr.length));
		System.out.println(contains(arr, num, 2));
		
		//initRandomArray(arr, 1, 9);
		arr = initRandomArray2(3, 1, 9);
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
	}
	/* 기능 : 배열이 주어지고, 주어진 배열에서 0번지부터 count개까지 확인하여
	 *       정수 num가 있는지 없는지 확인하는 메소드
	 * 		 (배열에 정수 num가 있는지 중복체크)
	 * 매개변수 : 배열([1,2,3,4,5], 정수 num(7) => int []arr, int num
	 * 			갯수 => int count
	 * 리턴타입 : 있는지 없는지 => 참 또는 거짓 => boolean
	 * 메소드명 : contains
	 *  */
	public static boolean contains(int []arr, int num, int count) {
		//예외처리 : 배열의 크기보다 count가 큰 경우
		if(arr.length < count) {
			//비교할 갯수를 배열의 크기로 수정
			count = arr.length;
		}
		for(int i= 0; i < count; i +=1) {
			//배열의 값과 num의 값이 같은 경우(중복된 경우)
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	/* 기능 : 배열에 중복되지 않는 랜덤한 수를 생성하여 저장하는 메소드
	 * 매개변수 : 배열, 랜덤한 수를 만들기 위한 범위 
	 * 			=> int [] arr, int min, int max
	 * 리턴타입 : 없음 => void
	 * 메소드명 : initRandomArray
	 * */
	public static void initRandomArray(int []arr, int min, int max) {
		//예외 처리1 : 배열이 없는 경우
		if(arr == null) {
			return;
		}
		//예외 처리2 : min과 max가 바뀐 경우
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		//예외 처리3 : 랜덤 범위의 갯수가 배열의 크기보다 작은 경우
		if(max - min + 1 < arr.length) {
			return ;
		}
		//배열에 랜덤으로 수를 생성하여 저장(중복 제거)
		int cnt = 0; //배열에 저장된 수의 갯수
		while(cnt < arr.length) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			//중복 체크 후 중복되지 않으면 저장
			if(!contains(arr, r, cnt)){
				arr[cnt] = r;
				cnt+=1;
			}
		}
	}
	public static int[] initRandomArray2(int size, int min, int max) {
		int [] arr= new int[size];
		//예외 처리2 : min과 max가 바뀐 경우
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		//배열에 랜덤으로 수를 생성하여 저장(중복 제거)
		int cnt = 0; //배열에 저장된 수의 갯수
		while(cnt < arr.length) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			//중복 체크 후 중복되지 않으면 저장
			if(!contains(arr, r, cnt)){
				arr[cnt] = r;
				cnt+=1;
			}
		}
		return arr;
	}
}
