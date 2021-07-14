package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;

public interface BoardDAO {
	
	ArrayList<BoardVO> getBoardList(@Param("cri")Criteria cri);

	BoardVO getBoard(@Param("num")Integer num);

	void insertBoard(@Param("board")BoardVO board);

	int updateBoard(@Param("board")BoardVO board);

	int getTotalCount(@Param("cri")Criteria cri);

	void insertFile(@Param("file")FileVO fileVo);

}
