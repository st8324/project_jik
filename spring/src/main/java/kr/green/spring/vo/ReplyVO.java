package kr.green.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.*;

@Data
@NoArgsConstructor
public class ReplyVO {
	private int rp_num;
	private int rp_bd_num;
	private String rp_me_id;
	private String rp_content;
	private String rp_valid;
	private Date rp_regDate;
	private Date rp_upDate;
	public String getRp_regDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(rp_regDate);
	}
	public String getRp_upDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(rp_upDate);
	}
}
