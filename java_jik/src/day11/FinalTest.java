package day11;

public class FinalTest {

	public static void main(String[] args) {
		FinalTest ft = new FinalTest();
		System.out.println(ft.sum(1,2));
		//TestC.PI2 = 5;//에러 발생 : 상수를 수정하려고 했기 때문에
		TestC c = new TestC();
		//c.PI = 3;//에러 발생 : 상수를 수정하려고 했기 때문에
	}
	public int sum(int num1, int num2) {
		return num1 + num2;
	}
}

class TestC{
	public final double PI = 3.14;
	public static final double PI2 = 3.14;
	public final int MAX_COUNT;
	public TestC() {
		MAX_COUNT = 10;//final변수를 생성자에서 초기화
	}
}