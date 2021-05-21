package day18;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest2 {

	public static void main(String[] args) {
		/* 중복되지 않는 5개의 수가 입력될때가 입력한 후, 입력이 완료되면 종료하는
		 * 코드를 작성하세요.
		 * 예시>
		 * 정수를 입력하세요 : 1
		 * 정수를 입력하세요 : 2
		 * 정수를 입력하세요 : 3
		 * 정수를 입력하세요 : 4
		 * 정수를 입력하세요 : 1
		 * 정수를 입력하세요 : 2
		 * 정수를 입력하세요 : 3
		 * 정수를 입력하세요 : 5
		 * 입력된 정수 : 1 2 3 4 5(출력은 순서에 상관없이)
		 * */
		//필요한 객체를 생성
		HashSet<Integer> set = new HashSet<Integer>();
		Scanner scan = new Scanner(System.in);
		
		//반복문을 통해 정수를 콘솔에서 입력 받음
		while(set.size() < 5) {
			System.out.print("정수를 입력하세요 : ");
			//Integer num = scan.nextInt();
			//set.add(num);
			set.add(scan.nextInt());
		}
		//입력받아서 저장했던 숫자들을 출력
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			//Integer tmp = it.next();
			//System.out.print(tmp + " ");
			System.out.print(it.next() + " ");
		}
		scan.close();
	}

}
