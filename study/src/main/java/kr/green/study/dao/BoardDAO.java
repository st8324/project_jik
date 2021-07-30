package kr.green.study.dao;

import java.util.ArrayList;

import kr.green.study.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

}
