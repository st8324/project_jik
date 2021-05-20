package day17;

import java.util.Scanner;

public class StringTest9 {

	public static void main(String[] args) {
		/* 공백을 포함한 긴 문자열을 입력 한후 단어를 입력받아 해당 단어가 몇번
		 * 나오는지 확인하는 코드를 작성하세요.
		 * 예시 >
		 * 문장 입력 : Hello. Hi. HHHH. He. His 
		 * 단어 입력 : H
		 * 횟수 : 8번
		 * 예시 >
		 * 문장 입력 : Hello. Hi. HHHH. He. His 
		 * 단어 입력 : Hi
		 * 횟수 : 2번
		 * */
		
		//Scanner를 통해 콘솔에서 문장을 입력 받음
		Scanner scan = new Scanner(System.in);
		System.out.print("문장 입력 : ");
		String str = scan.nextLine();
		
		//콘솔에서 단어를 입력 받음
		System.out.print("단어 입력 : ");
		String word = scan.next();
		
		//반복문을 통해 해당 단어가 몇번 있는지 체크(indexOf()를 이용하여)
		int count = 0;//단어의 갯수
		int index = 0;//해당 단어가 있는 시작 번지
		while(true) {
			//문장에 해당 단어가 있는 위치를 찾음
			index = str.indexOf(word);
			if(index == -1) {
				break;
			}
			count++;
			str = str.substring(index + 1);
		}
		System.out.println(count + "번");
	}

}
