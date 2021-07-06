package kr.green.spring.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int num;
	private String title;
	private String contents;
	private String writer;
	private String valid;
	private Date registered;
	private int views;
}
