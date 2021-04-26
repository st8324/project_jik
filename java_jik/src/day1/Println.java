package day1;

public class Println {

	public static void main(String[] args) {
		/* System.out.println() : ()안에 있는 내용을 콘솔에 출력하는 메소드(기능)
		 * 						  내용을 출력 후 엔터를 침 
		 * System.out.println(문자열)
		 * System.out.println(정수)
		 * System.out.println(실수)
		 * System.out.println(논리형)
		 * System.out.println(문자)
		 * */
		System.out.println("Hello");
		System.out.println(1);
		System.out.println(3.14);
		System.out.println(true);
		System.out.println('A');
		
		System.out.println(1 + 2 + 3);//6이 출력
		//문자열1 + 정수2 => 문자열12가 됨
		//문자열12 + 정수3 => 문자열123
		System.out.println("1" + 2 + 3);//123이 출력
		//문자열 1과 2를 먼저 더하는 것이 아니라 정수2와 정수3을 더 한 후 문자열
		//1과 더함=> 문자열 1과 정수 5를 더함
		System.out.println("1" + (2 + 3));//15가 출력
		System.out.println(1 + 2 + "3");//33이 출력
		
	}

}
