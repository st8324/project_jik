package kr.green.study.service;

import kr.green.study.vo.MemberVO;
import kr.green.study.vo.ReplyVO;

public interface ReplyService {

	String insertReply(ReplyVO reply, MemberVO user);

}
