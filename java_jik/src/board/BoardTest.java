package board;

import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		/* 다음 메뉴를 가지는 게시글 콘솔 프로그램을 만드세요.
		 * 1. 게시글 등록
		 * 2. 게시글 수정
		 * 3. 게시글 삭제
		 * 4. 게시글 목록 확인
		 * 5. 게시글 상세 확인
		 * 6. 프로그램 종료 */
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		int max = 10;
		Board []board = new Board[max];
		String title, writer, registerDate, contents, type;
		int num;
		do {
			printMenu();//메뉴를 출력
			menu = scan.nextInt();//메뉴를 선택
			//선택된 메뉴에 따라 기능 안내문 출력
			switch(menu) {
			case 1:	
				//게시글 정보를 입력(제목, 작성자, 작성일, 내용)
				System.out.println("게시글 정보를 입력하세요.");
				System.out.print("제목 : ");
				title = scan.next();
				System.out.print("작성자: ");
				writer = scan.next();
				System.out.print("작성일: ");
				registerDate = scan.next();
				System.out.print("내용 : ");
				contents = scan.next();
				//타입은 게시글로 지정, 번호는 배열의 번지를 이용
				type = "게시글";
				//num = ??
				//입력된 정보를 이용하여 게시글 생성
				
				//생성된 게시글을 배열에 저장
				
				break;
			case 2:	System.out.println("수정");	break;
			case 3:	System.out.println("삭제");	break;
			case 4:	System.out.println("목록");	break;
			case 5:	System.out.println("상세");	break;
			case 6:	System.out.println("프로그램 종료");	break;
			default:	System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 6);
		scan.close();
	}
	public static void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1.게시글 등록");
		System.out.println("2.게시글 수정");
		System.out.println("3.게시글 삭제");
		System.out.println("4.게시글 목록 확인");
		System.out.println("5.게시글 상세 확인");
		System.out.println("6.프로그램 종료");
		System.out.println("-----------------");
		System.out.print("메뉴를 선택 하세요 : ");
	}
}
