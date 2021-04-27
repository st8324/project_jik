package day2;

public class Test2_6 {

	public static void main(String[] args) {
		/* 성적을 입력 받아 입력받은 성적을 출력하는 코드를 작성하세요.
		 * A : 90이상 100이하
		 *     성적이 90보다 크거나 같고, 성적이 100보다 작거나 같으면 
		 *     A라고 출력
		 * B : 80이상 90미만
		 *     성적이 80보다 크거나 같고, 성적이 90보다 작으면
		 *     B라고 출력
		 * C : 70이상 80미만
		 * D : 60이상 70미만
		 * F : 0이상 60미만
		 * 잘못된 성적 : 0미만, 100초과 */
		int score = 105;
		if(score >= 90 && score <= 100) {
			System.out.println(score + "점은 A");
		}else if(score >= 80 && score < 90) {
			System.out.println(score + "점은 B");
		}else if(score >= 70 && score < 80) {
			System.out.println(score + "점은 C");
		}else if(score >= 60 && score < 70) {
			System.out.println(score + "점은 D");
		}else if(score >= 0 && score < 60) {
			System.out.println(score + "점은 F");
		}else {
			System.out.println(score + "점은 잘못된 성적");
		}
	}

}
