package kr.green.spring.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	BoardDAO boardDao;
	private String uploadPath="D:\\JAVA_JIK\\uploadfiles";

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVO getBoard(Integer num) {
		//게시글 번호가 없으면 게시글이 없다고 전달 => num가 null인지 확인하여 null이면 null을 반환
		if(num == null) {
			return null;
		}
		//다오에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardDao.getBoard(num);
		//가져온 게시글을 전달. 이때 가져온 게시글은 없을 수도 있다(null이 들어갈 수도 있다)
		return board;
		//return boardDao.getBoard(num);
	}

	@Override
	public void insertBoard(BoardVO board, MultipartFile file) {
		// 다오에게 게시글 정보를 주면서 게시글 등록하라고 시킴
		boardDao.insertBoard(board);
		if(file != null && file.getOriginalFilename().length() != 0) {
			try {
				String filename = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				FileVO fileVo = new FileVO(board.getNum(),filename,file.getOriginalFilename());
				boardDao.insertFile(fileVo);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("첨부파일 업로드 중 예외 발생");
			}
		}
	}

	@Override
	public int updateViews(Integer num) {
		//다오에게 게시글 번호를 주고 게시글을 가져오라고 시킴
		BoardVO board = boardDao.getBoard(num);
		//가져온 게시글이 있으면 가져온 게시글의 조회수를 1증가 시킴
		if(board != null) {
			board.setViews(board.getViews()+1);
			//다오에게 게시글을 주면서 게시글을 수정하라고 요청
			return boardDao.updateBoard(board);
		}
		return 0;
	}

	@Override
	public int updateBoard(BoardVO board, MultipartFile file) {
		if(board == null || board.getNum() <= 0) {
			return 0;
		}
		if(board.getValid() == null) {
			board.setValid("I");
		}
		FileVO fileVo = boardDao.getFileVO(board.getNum());
		//첨부파일이 추가되는 경우
		if(fileVo == null && (file != null && file.getOriginalFilename().length() != 0)) {
			if(file != null && file.getOriginalFilename().length() != 0) {
				try {
					String filename = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
					fileVo = new FileVO(board.getNum(),filename,file.getOriginalFilename());
					boardDao.insertFile(fileVo);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("첨부파일 업로드 중 예외 발생");
				}
			}
		}
		//첨부파일이 삭제되는 경우
		else if(fileVo != null && (file == null || file.getOriginalFilename().length() == 0)) {
			//업로드되었던 파일을 삭제
			File ftmp = new File(uploadPath+fileVo.getName());
			if(ftmp.exists()) {
				ftmp.delete();
			}
			boardDao.deleteFileVO(fileVo.getNum());
		}
		//첨부파일이 수정되는 경우
		else if(fileVo != null &&  (file != null && file.getOriginalFilename().length() != 0)) {
			//업로드되었던 파일을 삭제
			File ftmp = new File(uploadPath+fileVo.getName());
			if(ftmp.exists()) {
				ftmp.delete();
			}
			boardDao.deleteFileVO(fileVo.getNum());
			if(file != null && file.getOriginalFilename().length() != 0) {
				try {
					String filename = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
					fileVo = new FileVO(board.getNum(),filename,file.getOriginalFilename());
					boardDao.insertFile(fileVo);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("첨부파일 업로드 중 예외 발생");
				}
			}
		}
		return boardDao.updateBoard(board);
	}

	@Override
	public int deleteBoard(Integer num, MemberVO user) {
		//다오에게 게시글 번호를 주면서 가져오라고 시킴
		BoardVO board = boardDao.getBoard(num);
		if(board == null || user == null || !board.getWriter().equals(user.getId())) {
			return 0;
		}
		//가져온 게시글의 valid값을 D로 수정
		board.setValid("D");
		//다오에게 게시글 정보를 주면서 수정하라고 시킨 후 정수값을 리턴
		return boardDao.updateBoard(board);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.getTotalCount(cri);
	}

	@Override
	public FileVO getFileVO(Integer num) {
		if(num == null)
			return null;
		return boardDao.getFileVO(num);
	}

	@Override
	public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
	    try{
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
		return entity;
	}
}
