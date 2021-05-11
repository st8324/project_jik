package day10;

/* 2차원 좌표 평면의 점을 나타내는 클래스 : Point
 * 멤버 변수 : x좌표, y좌표
 * 멤버 메소드 : 좌표를 출력하는 기능, 좌표를 이동하는 기능*/
public class Point {
	private int x, y;

	/* 기능 	  : 멤버변수 x,y좌표를 출력하는 메소드
	 * 매개변수 : 없음(멤버 변수 x,y를 이용)
	 * 리턴타입 : 없음 => void
	 * 메소드명 : print
	 * */
	public void print() {
		//멤버변수를 멤버메소드에서 사용하는 경우 따로 선언을 하지 않아도 됨
		System.out.println("(" + x + "," + y + ")");
	}
	/* 기능 	  : 지정된 좌표로 이동하는 메소드
	 * 매개변수 : 지정된 좌표 => x좌표, y좌표=> int x1, int y1
	 * 리턴타입 : 없음 => void
	 * 메소드명 : move
	 * */
	public void move(int x1, int y1) {
		x = x1;
		y = y1;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	/* 초기 x,y좌표가 x1,y1주어지면 주어진 x,y좌표로 멤버변수를 초기화하는 생성자 */
	public Point(int x1, int y1) {
		x = x1;
		y = y1;
	}
	public Point() {}
	//복사 생성자
	public Point(Point pt) {
		x = pt.x;
		y = pt.y;
	}
}
