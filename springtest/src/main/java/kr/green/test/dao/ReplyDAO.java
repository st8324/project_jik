package kr.green.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(@Param("rvo")ReplyVO rvo);

}
