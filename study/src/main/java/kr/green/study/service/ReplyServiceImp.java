package kr.green.study.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kr.green.study.dao.BoardDAO;
import kr.green.study.dao.ReplyDAO;
import kr.green.study.pagination.Criteria;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.MemberVO;
import kr.green.study.vo.ReplyVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService {
	
	private ReplyDAO replyDao;
	private BoardDAO boardDao;
	
	@Override
	public String insertReply(ReplyVO reply, MemberVO user) {
		if(reply == null || reply.getRp_bd_num() <= 0 || user == null)
			return "FAIL";
		BoardVO board = boardDao.selectBoard(reply.getRp_bd_num());
		if(board == null || board.getType().equals("IMAGE"))
			return "FAIL";
		reply.setRp_me_id(user.getId());
		replyDao.insertReply(reply);
		return "OK";
	}

	@Override
	public ArrayList<ReplyVO> getReplyList(int rp_bd_num, Criteria cri) {
		return replyDao.selectReplyList(rp_bd_num, cri);
	}

	@Override
	public int getTotalCount(int rp_bd_num) {
		return replyDao.selectTotalCount(rp_bd_num);
	}

	@Override
	public String modifyReply(ReplyVO reply, MemberVO user) {
		if(reply == null || user == null)
			return "FAIL";
		ReplyVO dbReply = replyDao.selectReply(reply.getRp_num());
		if(dbReply == null || !dbReply.getRp_me_id().equals(user.getId()))
			return "FAIL";
		replyDao.updateReply(reply);
		return "OK";
	}

	@Override
	public String deleteReply(int rp_num, MemberVO user) {
		if(user == null || rp_num <= 0)
			return "FAIL";
		ReplyVO dbReply = replyDao.selectReply(rp_num);
		if(dbReply == null || !dbReply.getRp_me_id().equals(user.getId()))
			return "FAIL";
		replyDao.deleteReply(rp_num);
		return "OK";
	}
}
