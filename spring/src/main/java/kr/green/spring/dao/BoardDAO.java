package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.BoardVO;

public interface BoardDAO {
	
	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(@Param("num")Integer num);

	void insertBoard(@Param("board")BoardVO board);

}
