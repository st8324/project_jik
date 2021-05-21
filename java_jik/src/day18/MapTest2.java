package day18;

import java.util.HashMap;
import java.util.Scanner;

public class MapTest2 {

	public static void main(String[] args) {
		/* 다음 두 기능을 가진 프로그램을 작성하세요.
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 예시 >
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 회원가입
		 * 아이디 : abc123
		 * 비밀번호: abc123
		 * 회원가입되었습니다.
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 아이디 : abc123
		 * ======이미 가입된 회원입니다.======
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 아이디 : abc123
		 * 비밀번호 : abc123
		 * ======로그인 성공======
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 아이디 : abc123
		 * 비밀번호 : 1234
		 * ======로그인 실패======
		 * */
		HashMap<String, String> map = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);
		int menu;
		//반복문
		do {
			//메뉴 출력
			System.out.println("======메뉴======");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			System.out.println("===============");
			System.out.print("메뉴 선택 : ");
			//메뉴 입력
			menu = scan.nextInt();
			String id, pw;
			//입력받은 메뉴에 따른 기능
			switch(menu) {
			//회원가입 기능
			case 1:
				//아이디 입력
				System.out.print("아이디 : ");
				id = scan.next();
				//가입된 아이디가 아니면 비밀번호 입력 후 아이디와 비밀번호를 저장
				if(!map.containsKey(id)) {
					System.out.print("비밀번호: ");
					pw = scan.next();
					map.put(id, pw);
				}
				//가입된 아이디이면 이미 가입된 아이디라고 출력
				else {
					System.out.println("===============");
					System.out.println("이미 가입된 아이디입니다.");
					System.out.println("===============");
				}
				break;
			//로그인 기능
			case 2:
				//아이디 입력
				System.out.print("아이디 : ");
				id = scan.next();
				//비밀번호 입력
				System.out.print("비밀번호: ");
				pw = scan.next();
				//아이디와 비밀번호가 일치하는 확인하여 같으면 로그인 성공
				if(map.get(id).equals(pw)) {
					System.out.println("===============");
					System.out.println("로그인 성공.");
					System.out.println("===============");
				}
				//다르면 로그인 실패라고 출력
				else {
					System.out.println("===============");
					System.out.println("로그인 실패.");
					System.out.println("===============");
				}
				break;
			//종료
			case 3:
				System.out.println("===============");
				System.out.println("프로그램을 종료합니다.");
				System.out.println("===============");
				break;
			default:
				System.out.println("===============");
				System.out.println("잘못된 메뉴입니다.");
				System.out.println("===============");
			}
		}while(menu != 3);
	}

}
