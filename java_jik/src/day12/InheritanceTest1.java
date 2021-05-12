package day12;

public class InheritanceTest1 {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.print();
		Child c = new Child();
		c.print();
	}
}
class Parent{
	public int num;
	private int num2;
	protected int num3;
	int num4;
	public void print() {
		System.out.println("num : " + num);
	}
}
class Child extends Parent{
	
	public void print2() {
		//System.out.println("num2: " + num2);
		System.out.println("num3: " + num3);
		System.out.println("num4: " + num4);
	}
}