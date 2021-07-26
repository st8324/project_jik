package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("id")String id);

	void signup(@Param("user")MemberVO user);

	int updateMember(@Param("user")MemberVO dbUser);

	ArrayList<MemberVO> getMemberByEmail(@Param("email")String email);
	
}
