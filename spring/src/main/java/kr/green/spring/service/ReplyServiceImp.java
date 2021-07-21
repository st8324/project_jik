package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.stereotype.*;

import kr.green.spring.dao.ReplyDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.ReplyVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService {
	private ReplyDAO replyDao;

	@Override
	public void insertReply(ReplyVO reply) {
		replyDao.insertReply(reply);
		
	}

	@Override
	public ArrayList<ReplyVO> getReplyList(Integer num, Criteria cri) {
		if(num == null)
			return null;
		return replyDao.getReplyList(num, cri);
	}

	@Override
	public int getTotalCount(Integer num) {
		if(num == null)
			return 0;
		return replyDao.getTotalCount(num);
	}

	@Override
	public String deleteReply(ReplyVO reply, MemberVO user) {
		if(reply == null || reply.getRp_num() <= 0) {
			return "NO_REPLY_FAIL";
		}
		if(user == null || user.getId() == null) {
			return "NO_USER_FAIL";
		}
		ReplyVO rvo = replyDao.getReply(reply.getRp_num());
		if(rvo == null) {
			return "NO_REPLY_FAIL";
		}
		if(!rvo.getRp_me_id().equals(user.getId())) {
			return "NO_REPLYER_FAIL";
		}
		rvo.setRp_valid("D");
		replyDao.updateReply(rvo);
		return "DELETE_SUCCESS";
	}
}
