package day15;

public interface BoardService {
	/* 기능	  : 게시글 등록하는 메소드
	 * 			게시글 제목, 내용, 작성자, 작성일이 주어지면 게시글을 등록하는 메소드
	 * 매개변수 : 게시글 제목, 내용, 작성자, 작성일 => 게시글 정보
	 * 			=> Board board
	 * 리턴타입 : 없음 => void
	 * 메소드명 : insert
	 * */
	public void insert(Board board);
	/* 기능	  : 게시글 삭제하는 메소드
	 * 			게시글 번호가 주어지면 해당 게시글 번호를 삭제한 후 삭제 여부를 알려주는 메소드
	 * 매개변수 : 게시글 번호 => int num
	 * 리턴타입 : 삭제 여부 => boolean
	 * 메소드명 : delete
	 * */
	public boolean delete(int num);
	/* 기능	  : 게시글 수정하는 메소드
	 * 			게시글 번호와 수정할 게시글정보(제목, 내용)이 주어지면 게시글을 수정하는 메소드
	 * 매개변수 : 게시글 번호와 수정할 게시글 정보 => Board board
	 * 리턴타입 : 없음 => void
	 * 메소드명 : update
	 * */
	public void update(Board board);
	/* 기능	  : 게시글번호가 주어지면 게시글을 전달하는 메소드
	 * 			게시글번호가 주어지면 주어진 게시글에 대한 게시글 정보
	 * 			(제목, 내용, 작성자, 작성일)을 알려주는 메소드
	 * 매개변수 : 게시글 번호 => int num
	 * 리턴타입 : 게시글 정보 => Board
	 * 메소드명 : getBoard
	 * */
	public Board getBoard(int num);
	/* 기능	  : 게시글 리스트를 가져오는 메소드
	 * 			게시글 정보(제목,내용,작성자,작성일)들을 가져오는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 게시글 정보들 => Board []
	 * 메소드명 : getBoardList
	 * */
	public Board[] getBoardList();
	/* 기능	  : 검색어가 들어간 게시글 리스트를 가져오는 메소드
	 * 매개변수 : 검색어 => String search
	 * 리턴타입 : 검색된 게시글 정보들 => Board []
	 * 메소드명 : getBoardList */
	public Board[] getBoardList(String search);
}

class Board{
	int num;
	String title;
	String contents;
	String writer;
	String registerDate;
}














