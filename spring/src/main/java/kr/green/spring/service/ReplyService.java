package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.ReplyVO;

public interface ReplyService {

	void insertReply(ReplyVO reply);

	ArrayList<ReplyVO> getReplyList(Integer num, Criteria cri);

	int getTotalCount(Integer num);

	String deleteReply(ReplyVO reply, MemberVO user);

}
