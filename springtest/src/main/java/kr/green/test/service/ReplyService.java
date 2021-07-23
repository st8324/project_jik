package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.ReplyVO;

public interface ReplyService {

	int insertReply(ReplyVO rvo);

	ArrayList<ReplyVO> getReplyList(int rp_bd_num, Criteria cri);

	int getTotalCount(int rp_bd_num);

}
