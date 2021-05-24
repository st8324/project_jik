package day19;

public class StaticTest {

	public static void main(String[] args) {
		//객체 메소드는 클래스 메소드에서 바로 사용할 수 없다.
		//print();
		//객체 메소드를 클래스 메소드에서 사용하려면 객체를 만든 후 호출해야 한다
		StaticTest st = new StaticTest();
		st.print();
	}
	public void print() {
		System.out.println("안녕하세요");
	}
}
