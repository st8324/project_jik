package day16;

public class ThrowsTest {

	public static void main(String[] args) {
		try {
			test();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void test() throws Exception, ArithmeticException{
		throw new Exception("test 메소드에서 예외 발생");
	}
}
