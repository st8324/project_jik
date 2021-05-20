package day17;

import java.util.Scanner;

public class StringTest8 {

	public static void main(String[] args) {
		/* compareTo(문자열) 예제 : equals(문자열)과 비슷
		 * 문자열A.compareTo(문자열B)
		 * -1 : 문자열 A가 사전순으로 앞
		 * 0  : 문자열 A,B가 같음
		 * 1  : 문자열 A가 사전순으로 뒤 */

		System.out.println("A".compareTo("B"));
		System.out.println("A".compareTo("A"));
		System.out.println("B".compareTo("A"));
		
		/* contains(문자열) 예제 : indexOf(문자열)과 비슷 */
		System.out.println("Hello".contains("He"));
		System.out.println("Hello".contains("Hi"));
	}
}
