package kr.green.study.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.study.vo.BoardVO;
import kr.green.study.vo.FileVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

	BoardVO selectBoard(Integer num);

	void insertBoard(@Param("board")BoardVO board);

	void updateBoard(BoardVO dbBoard);

	void deleteBoard(Integer num);

	void deleteReplyBoard(Integer num);

	void insertFile(FileVO file);

	void updateViews(Integer num);

	ArrayList<FileVO> selectFileList(Integer num);

}
