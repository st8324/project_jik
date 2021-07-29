package kr.green.study.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String gender;
	private String email;
	private String name;
	private String authority;
	private Boolean useCookie;
	public String getAuthorityStr() {
		if(authority.equals("USER"))
			return "회원";
		if(authority.equals("ADMIN"))
			return "관리자";
		if(authority.equals("SUPER ADMIN"))
			return "최고 관리자";
		return "";
	}
}
