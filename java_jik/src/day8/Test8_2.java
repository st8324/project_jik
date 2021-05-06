package day8;

public class Test8_2 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 작성하세요.
		 * a
		 * ab
		 * abc
		 * abcd
		 * abcde
		 * ...
		 * abcdefg...xyz
		 * 
		 * abcd ...xyz 예제와
		 * *
		 * **
		 * ***
		 * **** 예제의 혼합
		 * */
		for(char i = 'a'; i <= 'z'; i += 1) {
			for(char k = 'a'; k <= i ; k += 1) {
				System.out.print(k);
			}
			System.out.println();
		}
		String str = "";
		for(char i = 'a'; i <= 'z'; i +=1) {
			str += i;
			System.out.println(str);
		}
	}

}
