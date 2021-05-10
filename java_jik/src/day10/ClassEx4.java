package day10;

import java.util.Scanner;

public class ClassEx4 {

	public static void main(String[] args) {
		/* 콘솔에서 x좌표와 y좌표를 입력받아 점을 만들고, 만들어진 점의 위치를
		 * 출력하는 예제 */
		Scanner scan = new Scanner(System.in);
		//콘솔에서 정수를 입력받아 변수에 저장하는 코드를 작성해보세요.
		System.out.print("좌표를 입력해주세요(x,y순으로) : ");
		int x = scan.nextInt();
		int y = scan.nextInt();
		//입력받은 좌표를 이용하여 점을 생성
		Point pt = new Point();
		//질문 : 만들어진 pt의 x,y좌표는? (0,0) 
		pt.print();
		//pt의 초기값을 입력한 값인 4,5로 변경하는 코드를 작성하세요.
		//pt.setX(x);
		//pt.setY(y);
		
		pt.move(x, y);
		
		pt.print();
		
		scan.close();
	}

}
