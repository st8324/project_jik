package day16;

public class ThrowTest {

	public static void main(String[] args) {
		int num = 1;
		try {
			if(num == 1) {
				RuntimeException e = new RuntimeException("예외");
				throw e;
				//throw new RuntimeException("예외");
			}
		}catch(RuntimeException e) {
			System.out.println("실행 예외가 발생");
		}catch(Exception e) {
			System.out.println("예외가 발생");
		}
		//Exception는 실행예외가 아니기 때문에 예외처리가 필수이다. 
		//예외처리를 안한 아래 코드는 에러 발생
		//throw new Exception("예외");
		//RuntimeException은 실행 예외이기 때문에 예외처리를 안해도 에러가 발생하지 않음
		throw new RuntimeException("예외");
	}
}
