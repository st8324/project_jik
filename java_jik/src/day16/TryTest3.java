package day16;

public class TryTest3 {

	public static void main(String[] args) {
		int num1 = 1, num2 = 0;
		try {
			System.out.println(num1 / num2 );
		}catch(Exception e) {
			System.out.println("예외 발생");
			//return을 통해 메소드를 종료하기 전 finally를 실행
			return ;
		}finally {
			System.out.println("finally 실행");
		}
		System.out.println("프로그램 종료");
	}

}
