package kr.green.study.service;

import java.util.ArrayList;

import kr.green.study.pagination.Criteria;
import kr.green.study.vo.MemberVO;
import kr.green.study.vo.ReplyVO;

public interface ReplyService {

	String insertReply(ReplyVO reply, MemberVO user);

	ArrayList<ReplyVO> getReplyList(int rp_bd_num, Criteria cri);

	int getTotalCount(int rp_bd_num);

	String modifyReply(ReplyVO reply, MemberVO user);

	String deleteReply(int rp_num, MemberVO user);

}
