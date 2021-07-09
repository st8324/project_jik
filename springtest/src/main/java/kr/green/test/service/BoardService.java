package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.vo.BoardVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(Integer num);

	int updateViews(Integer num);

	void insertBoard(BoardVO board);

	int deleteBoard(Integer num);

	int updateBoard(BoardVO board);

}
