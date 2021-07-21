package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.stereotype.*;

import kr.green.spring.dao.ReplyDAO;
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
	public ArrayList<ReplyVO> getReplyList(Integer num) {
		if(num == null)
			return null;
		return replyDao.getReplyList(num);
	}
}
