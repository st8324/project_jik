package day13;

public class AutoCar extends Car {
	
	public AutoCar(String type, String company) {
		super(type, company);
		super.setGear('P');
	}
	@Override
	public void setGear(char gear) {
		switch(gear) {
		case 'D','N','R','P':
			super.setGear(gear);
			break;
		default:
			super.setGear('P');
		}
	}
}
