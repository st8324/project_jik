package kr.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(@Param("rvo")ReplyVO rvo);

	ArrayList<ReplyVO> getReplyList(@Param("rp_bd_num")int rp_bd_num,@Param("cri")Criteria cri);

	int getTotalCount(@Param("rp_bd_num")int rp_bd_num);

}
