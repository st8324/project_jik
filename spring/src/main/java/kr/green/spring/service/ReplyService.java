package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.vo.ReplyVO;

public interface ReplyService {

	void insertReply(ReplyVO reply);

	ArrayList<ReplyVO> getReplyList(Integer num);

}
