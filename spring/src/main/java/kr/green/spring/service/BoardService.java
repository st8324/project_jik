package kr.green.spring.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer num);

	void insertBoard(BoardVO board, MultipartFile file);

	int updateViews(Integer num);

	int updateBoard(BoardVO board, MultipartFile file);

	int deleteBoard(Integer num,MemberVO user);

	int getTotalCount(Criteria cri);

	FileVO getFileVO(Integer num);

	ResponseEntity<byte[]> downloadFile(String fileName) throws IOException;

}
