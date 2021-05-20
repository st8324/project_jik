package day17;

import java.util.Scanner;

public class StringTest7 {

	public static void main(String[] args) {
		/*String str = "1234-567-1564";
		String []arr = str.split("-");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		*/
		/* 취미를 한줄로 입력받아 각 취미를 출력하는 코드를 작성하세요.
		 * 예시
		 * 취미를 입력하세요(예: 영화보기,음악감상,독서 ) : 영화보기,음악감상
		 * 취미리스트
		 * 1. 영화보기
		 * 2. 음악감상
		 * */
		//취미를 입력 받음
		Scanner scan = new Scanner(System.in);
		System.out.print("취미를 입력하세요(예: 영화보기,음악감상,독서 ) : ");
		String hobby = scan.next();
		
		//구분자를 기준으로 취미를 배열로 변환하여 취미리스트에 저장
		String []hobbyList = hobby.split(",");
		
		//취미리스트를 출력
		for(int i =0; i<hobbyList.length; i++) {
			System.out.println((i+1) + ". " + hobbyList[i]);
		}
		scan.close();
	}

}
