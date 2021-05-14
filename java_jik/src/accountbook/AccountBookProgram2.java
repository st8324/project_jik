package accountbook;

import java.util.Scanner;

public class AccountBookProgram2 {
	AccountBook2 book;
	Scanner scan = new Scanner(System.in);
	/* 기능	  : 내역을 입력받아 가계부에 저장하는 메소드 
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : insert */
	public void insert() {
		System.out.println("가계부 내역을 입력하세요.");
		Item item = createItem();
		book.insert(item);
	}
	/* 기능 	  : 수정할 내역의 번호와 내역정보를 입력받아 내역을 수정하는 메소드 */
	public void update() {
		System.out.print("수정할 내역의 번호를 입력 : ");
		int index = scan.nextInt();
		if(index < 1 || index > book.getCount()) {
			System.out.println("없은 내역입니다. 수정할 수 없습니다.");
			return ;
		}
		System.out.println("수정할 내역을 입력하세요.");
		Item item = createItem();
		book.update(index-1, item);
		System.out.println("수정이 완료되었습니다.");
	}
	/* 기능	  : 내역 정보를 입력받아 내역을 생성하여 알려주는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 생성된 내역 => Item
	 * 메소드명 : createItem */
	private Item createItem() {
		System.out.print("수입/지출 : ");
		String type = scan.next();
		System.out.print("날짜 : ");
		String date = scan.next();
		System.out.print("자산 : ");
		String paymentType = scan.next();
		System.out.print("분류 : ");
		String category = scan.next();
		System.out.print("금액 : ");
		int cost = scan.nextInt();
		System.out.print("내용 : ");
		String contents = scan.next();
		Item item = new Item(type, date, paymentType, category,
				cost, contents);
		return item;
	}
	
	/* 기능	  : 삭제할 번호를 입력받아 내역을 삭제하는 메소드 */
	public void delete() {
		System.out.print("삭제할 내역의 번호를 입력 : ");
		int index = scan.nextInt();
		if(index < 1 || index > book.getCount()) {
			System.out.println("없는 내역입니다. 삭제할 수 없습니다.");
			return ;
		}
		book.delete(index-1);
	}
	/* 기능    : 내역 전체를 상세 출력하는 메소드 */
	public void printItemListDetail() {
		book.printItemListDetail();
	}
	
	/* 기능 	  : 내역 전체를 간략히 출력하는 메소드 */
	public void printItemListSimple() {
		book.printItemSimple();
	}
	/* 기능	  : 확인할 내역 번호를 입력받아 내역을 상세히 출력하는 메소드 */
	public void printItem() {
		System.out.print("확인할 내역의 번호를 입력 : ");
		int index = scan.nextInt();
		if(index < 1 || index > book.getCount()) {
			System.out.println("없는 내역입니다. 확인할 수 없습니다.");
			return;
		}
		book.printItem(index-1);
	}
	
	/* 기능	  : 가계부 금액을 출력하는 메소드 */
	public void printTotal() {
		System.out.println("내역 합계 : " + book.getTotal() + "원");
	}
	public AccountBookProgram2() {
		book = new AccountBook2();
	}
	public AccountBookProgram2(int max) {
		book = new AccountBook2(max);
	}
	public void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 가계부 입력");
		System.out.println("2. 가계부 수정");
		System.out.println("3. 가계부 삭제");
		System.out.println("4. 가계부 확인");
		System.out.println("5. 가계부 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
	}
	public void printSubMenu() {
		System.out.println("------확인------");
		System.out.println("1. 전체 내역 상세");
		System.out.println("2. 전체 내역 요약");
		System.out.println("3. 선택 내역 상세");
		System.out.println("4. 내역 합계");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
	}
}
