package kr.green.test.service;

import kr.green.test.vo.MemberVO;

public interface MemberService {
	public void signup(MemberVO user);

	public MemberVO signin(MemberVO user);
}
