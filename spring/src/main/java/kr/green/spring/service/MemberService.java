package kr.green.spring.service;

import kr.green.spring.vo.MemberVO;

public interface MemberService {
	
	public MemberVO signin(MemberVO user);

	public boolean signup(MemberVO user);
}
