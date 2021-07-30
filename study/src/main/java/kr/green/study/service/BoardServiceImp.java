package kr.green.study.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kr.green.study.dao.BoardDAO;
import kr.green.study.vo.BoardVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImp implements BoardService {
	private BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}
}
