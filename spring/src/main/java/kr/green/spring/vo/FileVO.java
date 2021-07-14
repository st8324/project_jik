package kr.green.spring.vo;

import lombok.Data;

@Data
public class FileVO {
	private int num;
	private int board;
	private String name;
	private String state;
	private String ori_name;

	public FileVO() {}
	public FileVO(int board, String name, String ori_name) {
		this.board = board;
		this.name = name;
		this.ori_name = ori_name;
	}
}
