package day10;

public class Rect {
	//너비 : width, 정수, 높이 : height, 정수
	private int width, height;
	//왼쪽위의 점 : leftUp, 
	private Point leftUp;
	//오른쪽아래의 점 : rightDown, 
	private Point rightDown;
	
	/* 기능	  : 사각형의 정보를 출력하는 메소드
	 * 매개변수 : 없음 
	 * 리턴타입 : 없음 => void
	 * 메소드명 : print 
	 * */
	public void print() {
		System.out.print("왼쪽위 점 : ");
		leftUp.print();
		System.out.print("오른쪽위점 : ");
		rightDown.print();
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
	}
	/* 기능	  : 주어진 좌표로 왼쪽위의 점을 이동시키는 메소드
	 * 매개변수 : 주어진 왼쪽 위의 좌표 => int x1, int y1
	 * 리턴타입 : 없음 => void
	 * 메소드명 : move
	 * */
	public void move(int x1, int y1) {
		//왼쪽 위의 점을 이동
		leftUp.move(x1, y1);
		//오른쪽 아래의 점을 이동
		//x1을 기준으로 너비만큼 더해주고, y1을 기준으로 높이만큼 빼주면 됨
		rightDown.move(x1+width, y1-height);
	}
	/* 기능 	  : 왼쪽위의점을 기준으로 사각형의 너비와 높이를 변경하는 메소드
	 * 매개변수 : 너비와 높이 => int w, int h
	 * 리턴타입 : 없음 => void
	 * 메소드명 : resize */
	public void resize(int w, int h) {
		//너비와 높이를 수정
		width = w;
		height = h;
		//오른쪽 아래의 점 수정
		rightDown.move(leftUp.getX()+width, leftUp.getY()-height);
	}
	
	/* 기본 생성자 : 왼쪽위의 점을 나타내는 객체를 생성, 오른쪽 위의 점을 나타내는 
	 * 			   객체 생성 */
	public Rect() {
		leftUp = new Point();
		rightDown = new Point();
	}
	/* 생성자   : 좌상점과 우하점이 주어지면 해당 점을 이용한 사각형이 되도록 초기화
	 * 			좌상점, 우하점 초기화, 너비와 높이도 계산해서 초기화 
	 * 매개변수 : 
	 * */
	public Rect(int left, int up, int right, int down) {
		leftUp = new Point(left,up);
		rightDown = new Point(right, down);
		width = right - left;
		height = up - down;
	}
	public Rect(Point lu, Point rd) {
		//leftUp = lu;//lu와 leftUp은 같은 정보를 공유
		//rightDown = rd;//rd와 rightDown은 같은 정보를 공유
		leftUp = new Point(lu);
		rightDown = new Point(rd);
		width = rightDown.getX() - leftUp.getX();
		height = leftUp.getY() - rightDown.getY();
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Point getLeftUp() {
		return leftUp;
	}
	public void setLeftUp(Point leftUp) {
		this.leftUp = leftUp;
	}
	public Point getRightDown() {
		return rightDown;
	}
	public void setRightDown(Point rightDown) {
		this.rightDown = rightDown;
	}
}
