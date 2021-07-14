package kr.green.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.MemberVO;

public interface MemberDAO {
	public void insertMember(@Param("user")MemberVO user);

	public MemberVO getMember(@Param("id")String id);

	public void updateMember(@Param("user")MemberVO sUser);
}
