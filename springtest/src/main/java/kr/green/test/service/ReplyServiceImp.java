package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kr.green.test.dao.ReplyDAO;
import kr.green.test.pagination.Criteria;
import kr.green.test.vo.ReplyVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService {
	private ReplyDAO replyDao;

	@Override
	public int insertReply(ReplyVO rvo) {
		if(rvo.getRp_me_id() == null || rvo.getRp_me_id().length() == 0)
			return 0;
		replyDao.insertReply(rvo);
		return 1;
	}

	@Override
	public ArrayList<ReplyVO> getReplyList(int rp_bd_num, Criteria cri) {
		return replyDao.getReplyList(rp_bd_num, cri);
	}

	@Override
	public int getTotalCount(int rp_bd_num) {
		return replyDao.getTotalCount(rp_bd_num);
	}

	@Override
	public String updateReply(ReplyVO reply) {
		if(reply == null || reply.getRp_num() <= 0 || reply.getRp_me_id() == null ||
				reply.getRp_me_id().length() == 0)
			return "FAIL";
		ReplyVO dbReply = replyDao.getReply(reply.getRp_num());
		if(!reply.getRp_me_id().equals(dbReply.getRp_me_id())) {
			return "FAIL";
		}
		dbReply.setRp_content(reply.getRp_content());
		return replyDao.updateReply(dbReply) == 1 ? "SUCCESS" : "FAIL";
	}

	@Override
	public String deleteReply(ReplyVO reply) {
		if(reply == null || reply.getRp_num() <= 0 || reply.getRp_me_id() == null ||
				reply.getRp_me_id().length() == 0)
			return "FAIL";
		ReplyVO dbReply = replyDao.getReply(reply.getRp_num());
		if(!reply.getRp_me_id().equals(dbReply.getRp_me_id())) {
			return "FAIL";
		}
		dbReply.setRp_valid("D");
		return replyDao.updateReply(dbReply) == 1 ? "SUCCESS" : "FAIL";
	}
}
