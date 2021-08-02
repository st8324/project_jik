package kr.green.study.service;

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

import kr.green.study.dao.BoardDAO;
import kr.green.study.utils.UploadFileUtils;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.FileVO;
import kr.green.study.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	private BoardDAO boardDao;
	private String uploadPath = "D:\\JAVA_JIK\\uploadfiles";
	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public BoardVO getBoard(Integer num) {
		if(num == null)
			return null;
		return boardDao.selectBoard(num);
	}

	@Override
	public void insertBoard(BoardVO board, MultipartFile[] fileList, MemberVO user) throws Exception {
		if(board == null || user == null)
			return;
		board.setWriter(user.getId());
		board.setGroupOrd(0);
		boardDao.insertBoard(board);
		
		if(fileList == null)
			return;
		int size = fileList.length < 3 ? fileList.length : 3;
		for(int i = 0; i<size; i++) {
			insertFile(fileList[i], board.getNum());
		}
	}

	@Override
	public void insertReplyBoard(BoardVO board, MemberVO user) {
		if(board == null || user == null)
			return;
		board.setWriter(user.getId());
		BoardVO dbBoard = boardDao.selectBoard(board.getOriNo());
		if(dbBoard == null)
			return;
		board.setTitle(dbBoard.getTitle());
		boardDao.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board, MemberVO user, MultipartFile[] fileList, Integer[] fileNumList) {
		if(user == null || board == null)
			return;
		BoardVO dbBoard = boardDao.selectBoard(board.getNum());
		if(dbBoard == null || !user.getId().equals(dbBoard.getWriter()))
			return;
		dbBoard.setTitle(board.getTitle());
		dbBoard.setContents(board.getContents());
		boardDao.updateBoard(dbBoard);
		
		ArrayList<FileVO> fList = boardDao.selectFileList(board.getNum());
		//fList에서 첨부파일 번호들만 ArrayList로 변환
		
		//배열 fileNumList를 ArraylList로 변환
		
		//fList에 있는 첨부파일 번호들 중에서 fileNumList에 없는 첨부파일을 삭제
		
		//fileList에 있는 첨부파일 추가
		
	}

	@Override
	public void deleteBoard(Integer num, MemberVO user) {
		if(num == null || user == null)
			return ;
		BoardVO board = boardDao.selectBoard(num);
		if(board == null || !board.getWriter().equals(user.getId()))
				return;
		boardDao.deleteBoard(num);
		boardDao.deleteReplyBoard(num);
		
		ArrayList<FileVO> fList = boardDao.selectFileList(num);
		if(fList == null || fList.size() == 0)
			return;
		for(FileVO tmp: fList) {
			deleteFile(tmp);
		}
	}

	@Override
	public void updateViews(Integer num) {
		boardDao.updateViews(num);
	}

	@Override
	public ArrayList<FileVO> getFileList(Integer num) {
		if(num == null)
			return null;
		return boardDao.selectFileList(num);
	}

	@Override
	public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
		InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
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
	private void insertFile(MultipartFile tmp, int num) throws Exception {
		if(tmp == null || tmp.getOriginalFilename().length() == 0) {
			return;
		}
		String name = UploadFileUtils.uploadFile(uploadPath, tmp.getOriginalFilename(), tmp.getBytes());
		FileVO file = new FileVO(num, name, tmp.getOriginalFilename());
		boardDao.insertFile(file);
	}
	private void deleteFile(FileVO tmp) {
		File file = new File(uploadPath+tmp.getName());
		if(file.exists())
			file.delete();
		boardDao.deleteFile(tmp.getNum());
	}
}
