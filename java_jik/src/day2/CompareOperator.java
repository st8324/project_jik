package day2;

public class CompareOperator {

	public static void main(String[] args) {
		// 비교 연산자 예제
		System.out.println("1 >  2 : " + (1 >  2));
		System.out.println("1 >= 2 : " + (1 >= 2));
		System.out.println("1 <  2 : " + (1 <  2));
		System.out.println("1 <= 2 : " + (1 <= 2));
		System.out.println("1 == 2 : " + (1 == 2));
		System.out.println("1 != 2 : " + (1 != 2));
		
		//4는 짝수인가?를 확인하기 위한 코드를 작성해보세요.
		//짝수 : 2로 나누었을 때 나머지가 0과 같으면 짝수
		//4를 2로 나누었을 때 나머지가 0과 같다
		System.out.println("4는 짝수인가? " + (4 % 2 == 0));
		//소수점 표현 방식에 의해 0.1은 정확히 0.1이 아니기 때문에
		//double로 표현 0.1과 float으로 표현한 0.1은 다르다(p.120)
		System.out.println(0.1 == 0.1f);
		//문자 A는 정수 65로 지정되어 있기 때문에 문자 A와 65를 비교하면 같다가 나옴
		System.out.println('A' == 65);
	}

}
