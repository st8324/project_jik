package day10;

import java.util.Scanner;

public class ClassEx5 {

	public static void main(String[] args) {
		/* Circle 클래스를 이용하여 원 객체를 생성한 후 테스트 하는 예제 */
		Circle c1 = new Circle();
		c1.print();
		//중심점을 5,5로 이동
		c1.move(5, 5);
		//반지름 길이 변경 5로
		c1.setRadius(5);
		c1.print();
		//Scanner라는 클래스를 이용하여 scan 객체를 선언하고,
		//new를 이용하여 객체를 만들고, 만들어진 객체의 멤버변수를
		//Scanner(System.in) 생성자를 이용하여 초기화
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		scan.close();
	}

}
