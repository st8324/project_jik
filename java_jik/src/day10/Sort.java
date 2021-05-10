package day10;



public class Sort {

	public static void main(String[] args) {
		/* 배열 정렬 : 버블 정렬
		 *  - 옆에 요소와 비교하여 정렬하는 방법
		 *  5 4 6 9 8 7 10 [0,1]
		 *  4 5 6 9 8 7 10 [1,2]
		 *  4 5 6 9 8 7 10 [2,3]
		 *  4 5 6 9 8 7 10 [3,4]
		 *  4 5 6 8 9 7 10 [4,5]
		 *  4 5 6 8 7 9 10 [5,6]
		 *  4 5 6 8 7 9 10 =>10이 확정
		 *  4 5 6 8 7 9 10 [0,1]
		 *  4 5 6 8 7 9 10 [1,2]
		 *  4 5 6 8 7 9 10 [2,3]
		 *  4 5 6 8 7 9 10 [3,4]
		 *  4 5 6 7 8 9 10 [4,5]
		 *  4 5 6 7 8 9 10 => 9가 확정
		 *  작은 반복문의 횟수
		 *   - 0=>1=>2=>3=>4=>5(큰 반복횟수의 i값)
		 *   - 6=>5=>4=>3=>2=>1
		 *    => 6 - i < arr.length - i
		 * */
		int [] arr= new int[] {5, 4, 6, 9, 8, 7, 10};
		printArray(arr);
		System.out.println();
		for(int i = 0; i < arr.length - 1; i+=1) {
			for(int k = 0; k < arr.length - 1 - i; k += 1) {
				if(arr[k] > arr[k+1]) {
					int tmp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = tmp;
				}
				printArray(arr);
				System.out.println();
			}
		}
		printArray(arr);
	}
	public static void printArray(int []arr) {
		for(int i = 0; i<arr.length; i+=1) {
			System.out.print(arr[i] + " ");
		}
	}
}
