package day10;

public class ClassEx1 {

	public static void main(String[] args) {
		A a = new A();
		a.num = 10;//public이기 때문에 에러가 발생하지 않음
		B b = new B();
		//protected : 클래스 B와 ClassEx1은 같은 패키지에 있기 때문에 에러 발생하지 않음
		b.num = 10;
		C c = new C();
		//디폴트 : 클래스 C와 ClassEx1은 같은 패키지에 있기 때문에 에러 발생하지 않음
		c.num = 10;
		D d = new D();
		//d.num = 10;//에러 발생 : num의 접근제한자가 private이어서
		d.setNum(10);
		System.out.println(d.getNum());
	}
}
