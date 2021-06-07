package board2;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardProgram {
	private ArrayList<Board> list = new ArrayList<Board>();
	private Scanner scan = new Scanner(System.in);
	private int max = 0;
	
	/* 기능	  : 게시글을 추가하는 기능
	 * 매개변수 : 없음 
	 * 리턴타입 : 없음
	 * 메소드명 : insertBoard
	 * */
	public void insertBoard() {
		//게시글 정보를 입력(제목, 작성자, 작성일, 내용)
		System.out.println("게시글 정보를 입력하세요.");
		System.out.print("제목 : ");
		String title = scan.next();
		System.out.print("작성자: ");
		String writer = scan.next();
		
		System.out.print("내용 : ");
		String contents = scan.next();
		//타입은 게시글로 지정, 번호는 배열의 번지를 이용
		String type = "게시글";
		
		//입력된 정보를 이용하여 게시글 생성
		Board tmpBoard = new Board(++max, title, contents, writer, type);
		//생성된 게시글을 배열에 저장
		list.add(tmpBoard);
		
	}
	/* 기능	  : 게시글 번호를 입력받아 입력받은 게시글을 확인하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printBoardDetail */
	public void printBoardDetail() {
		System.out.print("확인할 게시글 번호를 입력하세요 : ");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num)); 
		if(index != -1) {
			list.get(index).print();
		}else {
			System.out.println("해당 게시글이 없거나 삭제되었습니다.");
		}
	}
	/* 기능	  : 게시글 전체를 확인하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printBoardList */
	public void printBoardList() {
		for(Board tmp : list) {
				tmp.summaryPrint();
		}
	}
	
	/* 기능	  : 수정할 게시글번호와 정보를 입력받아 수정하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : modifyBoard
	 * */
	public void modifyBoard() {
		System.out.print("수정할 게시글 번호를 입력하세요 : ");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			System.out.print("제목 : ");
			String title = scan.next();
			System.out.print("내용 : ");
			String contents = scan.next();
			list.get(index).modify(title, contents);
		}else {
			System.out.println("게시글이 없거나 삭제되었습니다.");
		}
	}
	/* 기능	  : 게시글 번호를입력받아 삭제하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음=>void
	 * 메소드명 : deleteBoard
	 * */
	public void deleteBoard() {
		System.out.print("삭제할 게시글 번호를 입력하세요 : ");
		int num = scan.nextInt();
		int idex = list.indexOf(new Board(num));
		list.remove(idex);
	}
	/* 기능	  : 게시글 프로그램을 종료하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음=>
	 * 메소드명 : closeBoard
	 * */
	public void closeBoard() {
		System.out.println("프로그램 종료합니다.");
		scan.close();
	}
}
