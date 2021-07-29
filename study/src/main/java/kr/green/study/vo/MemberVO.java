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
	//권한 비교가 안되면 -100, 권한이 같으면 0, 내가 권한이 낮으면 -1, 내가 권한이 높으면 1
	public int compareAuthority(MemberVO user) {
		if(user == null)
			return -100;
		//권한이 같은 경우
		if(user.getAuthority().equals(authority))
			return 0;
		//권한이 다른 경우
		switch(authority) {
		case "USER":
			if(user.getAuthority().equals("ADMIN") || 
				user.getAuthority().equals("SUPER ADMIN"))
				return -1;
			return -100;
		case "ADMIN":
			if(user.getAuthority().equals("SUPER ADMIN"))
					return -1;
			if(user.getAuthority().equals("USER"))
					return 1;
			return -100;
		case "SUPER ADMIN":
			if(user.getAuthority().equals("ADMIN") || 
					user.getAuthority().equals("USER"))
					return 1;
			return -100;
		}
		return -100;
	}
}
