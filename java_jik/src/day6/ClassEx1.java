package day6;

public class ClassEx1 {

	public static void main(String[] args) {
		int x = 1;
		Point1 point = new Point1();
		System.out.println("main의 x : " + x);
		System.out.println("point의 x: " + point.x);
		point.x = 3;
		System.out.println("point의 x: " + point.x);
		Point1 point2 = new Point1(1,2);
		System.out.println("point2의 x: " + point2.x);
	}
}

//2차원 좌표 평면의 점을 나타내는 클래스 : Point1
//x좌표, y좌표 =>정수
class Point1{
	int x;
	int y;
	public Point1() {}
	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
