package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(@Param("reply")ReplyVO reply);

	ArrayList<ReplyVO> getReplyList(@Param("num")Integer num,@Param("cri") Criteria cri);

	int getTotalCount(@Param("num")Integer num);

}
