package day2;

public class IncreaseDecreaseOperator {
	
	public static void main(String[] args) {
		int num1 = 10, num2 = 10;
		System.out.println("  num1 = " +   num1 + ",   num2 = " + num2);
		System.out.println("++num1 = " + ++num1 + ", num2++ = " + num2++);
		System.out.println("  num1 = " +   num1 + ",   num2 = " + num2);
		//11
		num1++;
		//12
		++num1;
		//이 때 num1을 출력하면 얼마가 나올까요?
		//13
		num1 = 10;
		num2 = 10;
		System.out.println("  num1 = " +   num1 + ",   num2 = " + num2);
		num1++;//++num1;
		System.out.println("++num1 = " +   num1 + ", num2++ = " + num2);
		++num2;//num2++;
		System.out.println("  num1 = " +   num1 + ",   num2 = " + num2);
		
	}
	
}
