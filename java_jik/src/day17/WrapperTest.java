package day17;

public class WrapperTest {

	public static void main(String[] args) {
		Integer num1 = 1;
		int num2 = 2;
		System.out.println(num1 + num2);
		num1 = null;
		System.out.println(num1);
		//num2 = null;//에러 발생 기본 타입은 null을 저장할 수 없음
		num1 = new Integer(1);//가능은 하나 생성자를 이용해 만들지는 않음
		System.out.println(num1);
		//기본타입을 객체로 만드는 것을 박싱
		num1 = 1;
		//객체를 기본타입으로 만드는 것을 언박싱
		num2 = num1;
		System.out.println(num2);
		//문자열을 기본타입으로 변환
		//래퍼클래스.parse래퍼클래스(문자열);
		String str = "1234";
		num2 = Integer.parseInt(str);
		System.out.println(num2);
	}

}
