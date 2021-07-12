package kr.green.spring.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.spring.vo.MemberVO;

public interface MemberService {
	
	public MemberVO signin(MemberVO user);

	public boolean signup(MemberVO user);

	public MemberVO getMember(String id);

	public MemberVO updateMember(MemberVO user);

	public MemberVO getMember(HttpServletRequest request);
}
