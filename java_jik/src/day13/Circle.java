package day13;

public class Circle extends Figure {
	/* 원을 그릴 때 좌상점과 우하점으로 그린다면 중심점은 실수로 해야한다
	 * 예 : (0,0) (1,1)인 원에서 중심점은 (0.5,0.5)
	 * 원을 그릴 때 좌상점과 우하점으로 그린다면 원이 아닌 타원이 나올 수 있다.
	 * 예 : (0,0) (2,3)은 타원
	 * 위와 같은 이유 때문에 원을 그릴 때는 중심점과 반지름을 기준으로 그릴 것이다.
	 * */
	private int x, y;//중심점의 x좌표, y좌표
	private int r;
	public Circle(int x, int y, int r) {
		super(x - r, y - r,x + r, y + r);
		this.x = x;
		this.y = y;
		this.r = r;
	}
	@Override
	public void print() {
		System.out.println("<<원입니다>>");
		System.out.println("중심점 : " + x + "px , " + y + "px");
		System.out.println("반지름 : " + r);
	}
}
