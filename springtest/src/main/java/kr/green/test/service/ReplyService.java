package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.vo.ReplyVO;

public interface ReplyService {

	int insertReply(ReplyVO rvo);

	ArrayList<ReplyVO> getReplyList(int rp_bd_num);

}
