package kr.green.study.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.study.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO user);

	MemberVO signin(MemberVO user);

	Object getMember(String id);

	void signout(HttpServletRequest request);

}
