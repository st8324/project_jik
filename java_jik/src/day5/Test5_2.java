package day5;

public class Test5_2 {

	public static void main(String[] args) {
		//p171~172
		String str1 = "ab";
		String str2 = "ab";
		if(str1 == str2) {
			System.out.println("두 문자열이 같습니다.");
		}else {
			System.out.println("두 문자열이 다릅니다.");
		}
		
		String str3 = new String("ab");
		String str4 = new String("ab");
		if(str3 == str4) {
			System.out.println("두 문자열이 같습니다.");
		}else {
			System.out.println("두 문자열이 다릅니다.");
		}
	}
}
