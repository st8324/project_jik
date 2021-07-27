package kr.green.test.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import kr.green.test.vo.MemberVO;

public interface MemberService {
	public void signup(MemberVO user);

	public MemberVO signin(MemberVO user);

	public MemberVO getMember(HttpServletRequest r);

	public MemberVO updateMember(MemberVO user, MemberVO sUser);

	public boolean idCheck(String id);

	public void keepLogin(String id, String session_id, Date session_limit);

	public MemberVO getMemberByCookie(String value);
}
