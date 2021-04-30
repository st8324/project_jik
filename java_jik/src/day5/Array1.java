package day5;

public class Array1 {

	public static void main(String[] args) {
		/* 배열 선언 */
		int [] arr1;
		int arr2[];
		
		int arr3[] = new int[5];//일반적으로 많이 사용
		int arr4[] = {1,2,3,4};
		int arr5[] = new int[] {1,2,3,4};
		
		int []arr6 = new int[5];//일반적으로 많이 사용
		int []arr7 = {1,2,3,4};
		int []arr8 = new int[] {1,2,3,4};

		int []arr9, arr10;	//arr9 : 배열, arr10: 배열
		int arr11[], arr12;	//arr11: 배열, arr12: 변수
		//배열 arr6의 첫번째 값 콘솔 출력
		System.out.println(arr6[0]);
		//배열 arr6의 두번째에 10을 저장
		arr6[1] = 10;
		//배열 arr6의 두번째 값 콘솔출력
		System.out.println(arr6[1]);
	}

}
