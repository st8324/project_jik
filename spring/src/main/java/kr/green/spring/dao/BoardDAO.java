package kr.green.spring.dao;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> getBoardList();

}
