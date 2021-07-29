package kr.green.study.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum;
	private Criteria criteria;
	
	public void calcData() {
		endPage = (int) (Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);
		startPage = (endPage - displayPageNum)+1;
		int tempEndPage = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false : true;
		next = endPage * criteria.getPerPageNum() >= totalCount ? false:true;
	}
	
	public PageMaker(int totalCount, int displayPageNum, Criteria cri) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.criteria = cri;
		calcData();
	}
	
}
