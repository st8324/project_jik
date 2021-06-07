package board2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	
	private int num;
	private String title = "";
	private String contents = new String();
	private String writer ="";
	private Date registerDate;
	private int views;
	private int like;
	private String type="";
	
	public Board(int num) {
		this.num = num;
	}
	
	public Board(int num, String title, String contents, 
			String writer,String type) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.registerDate = new Date();
		this.type = type;
	}
	public void print() {
		views += 1;
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("작성자: " + writer);
		System.out.println("조회수: " + views);
		System.out.println("좋아요: " + like);
		System.out.println("작성일: " + getRegisterDate());
		System.out.println("내용 : " + contents);
	}
	public void summaryPrint() {
		System.out.print(num + " ");
		System.out.print(title + " ");
		System.out.print(writer + " ");
		System.out.print(getRegisterDate() + " ");
		System.out.print(views + " ");
		System.out.println();
	}
	public void modify(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	
	/* equals를 오버라이딩하면 ArrayList에서 제공하는 contains 또는 indexOf를 이용하기 쉽다*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegisterDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return form.format(registerDate);
	}
	
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
