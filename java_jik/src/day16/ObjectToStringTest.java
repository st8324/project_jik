package day16;

public class ObjectToStringTest {

	public static void main(String[] args) {
		Student s = new Student("홍길동",1,1,1);
		System.out.println(s);
		System.out.println(s.toString());
	}
}
class Student{
	private String name;
	private int grade;
	private int classNum;
	private int num;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Student(String name, int grade, int classNum, int num) {
		super();
		this.name = name;
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", classNum=" + classNum + ", num=" + num + "]";
	}
	public void print() {
		System.out.println("이름 : " + name + "\n학년 : " + grade 
				+ "\n반 : " + classNum + "\n번호 : " + num);
	}
}
