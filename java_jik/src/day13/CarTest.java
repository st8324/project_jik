package day13;

public class CarTest {

	public static void main(String[] args) {
		AutoCar ac = new AutoCar("1종", "기아");
		StickCar sc = new StickCar("2종", "현대");
		ac.turnOn();
		ac.setGear('D');
		sc.setGear('2');
		ac.print();
		System.out.println("--------------");
		sc.print();
		
		System.out.println("--------------");
		Car c = ac;
		c.print();
		System.out.println("--------------");
		//Car c2 = new Car("1종", "기아");//안되는 경우
		Car c2 = new AutoCar("1종", "기아");//되는 경우
		ac = (AutoCar)c2;
		ac.print();
		//차를 관리하는데 수동은 수동끼리 자동은 자동끼리 관리
		AutoCar [] acList = new AutoCar[5];
		StickCar [] scList = new StickCar[5];
		acList[0] = ac;
		scList[0] = sc;
		//차를 관리하는데 수동과 자동 상관없이 같이 관리
		Car [] cList = new Car[5];
		cList[0] = ac;
		cList[1] = sc;
	}
}
