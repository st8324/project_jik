package kr.green.spring.vo;

import lombok.*;

@Data
@NoArgsConstructor
public class ReplyVO {
	private int rp_num;
	private int rp_bd_num;
	private String rp_me_id;
	private String rp_content;
	private String rp_valid;
}
