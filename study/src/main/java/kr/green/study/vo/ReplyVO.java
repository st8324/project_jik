package kr.green.study.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int rp_num;
	private int rp_bd_num;
	private String rp_me_id;
	private String rp_content;
	private String rp_valid;
	private Date rp_regDate;
	private Date rp_upDate;
}
