package day13;

public class Figure {
	//왼쪽위의 점과 오른쪽 아래점으로 이루어진 직각 사각형안에 도형이 그려진다
	private int left, up;
	private int right, down;
	
	public Figure(int left, int up, int right, int down) {
		if(right < left) {
			int tmp = right;
			right = left;
			left = tmp;
		}
		
		this.left = left;
		this.right = right;
		
		if(down < up) {
			int tmp = down;
			down = up;
			up = tmp;
		}
		
		this.up = up;
		this.down = down;
	}
	public void moveRD(int right, int down) {
		this.right = right;
		this.down = down;
	}
	public void moveLU(int left, int up) {
		this.left = left;
		this.up = up;
	}
	public void print() {
		System.out.println("좌상점 : " + left  + "px , " + up   + "px");
		System.out.println("우하점 : " + right + "px , " + down + "px");
	}
	public int getLeft() {
		return left;
	}
	public int getUp() {
		return up;
	}
	public int getRight() {
		return right;
	}
	public int getDown() {
		return down;
	}
}
