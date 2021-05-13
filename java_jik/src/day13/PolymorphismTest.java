package day13;

public class PolymorphismTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car2 c = new Car2();
		c.frontLeftTire = new KumhoTire();
		c.frontRightTire = new KumhoTire();
		c.backLeftTire = new HankookTire();
		c.backRightTire = new HankookTire();
		//사고 후 앞 왼쪽 바퀴를 한국타이어로 교체
		c.frontLeftTire = new HankookTire();
		boolean isOk1 = confirm(c.frontLeftTire);
		boolean isOk2 = confirm(c.frontRightTire);
	}
	/* 기능 	  : 타이어에 이상이 있는지 없는지 알려주는 메소드
	 * 매개변수 : 타이어 => Tire t
	 * 리턴타입 : 이상여부 => 참 거짓 => boolean
	 * 메소드명 : confirm 
	 * */
	//매개변수의 다형성을 확인하는 예제
	//instanceof를 이용하면 매개변수의 다형성을 처리하기가 쉬워진다.
	public static boolean confirm(Tire t) {
		//타이어 t가 한국타이어면 예외가 발생하지 않고
		//금호타이어면 예외가 발생함
		//HankookTire ht = (HankookTire)t;
		if(t instanceof HankookTire) {
			HankookTire ht = (HankookTire)t;
			//한국 타이어 검사하는 코드 작성했다고 가정
			System.out.println("한국 타이어 검사 끝!");
		}else if(t instanceof KumhoTire) {
			KumhoTire kt = (KumhoTire)t;
			//금호 타이거 검사하는 코드 작성했다고 가정
			System.out.println("금호 타이어 검사 끝!");
		}
		
		return false;
	}
}

class Car2{
	//멤버변수(필드)의 다형성
	public Tire frontLeftTire;
	public Tire frontRightTire;
	public Tire backLeftTire;
	public Tire backRightTire;
}
class Tire{}

class KumhoTire extends Tire{}
class HankookTire extends Tire{}




