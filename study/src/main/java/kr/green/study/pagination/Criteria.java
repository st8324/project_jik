package kr.green.study.pagination;

import lombok.Data;

@Data
public class Criteria {

	private int page; 
	private int perPageNum;
	private String sortType;//id, authority로 정렬
	private String sort;//desc, asc
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.sortType = "id";
		this.sort = "asc";
	}
	
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	public String getNotSort() {
		if(sort.equals("asc"))
			return "desc";
		else
			return "asc";
	}
}
