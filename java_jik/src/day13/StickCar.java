package day13;

public class StickCar extends Car {
	
	public StickCar(String type, String company) {
		super(type, company);
		super.setGear('1');
	}
	@Override
	public void setGear(char gear) {
		//수동은 1,2,3,4,5단과 후진 r만 가능하기 때문에
		//기어값이 D가 올수 없다. 기어값이 D, N등 다른 값이 오면 1단으로 설정
		switch(gear) {
		case '1','2','3','4','5','r':
			super.setGear(gear);
			break;
		default:
			super.setGear('1');
		}
	}
}
