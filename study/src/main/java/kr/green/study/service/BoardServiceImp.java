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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.study.dao.BoardDAO;
import kr.green.study.pagination.Criteria;
import kr.green.study.utils.UploadFileUtils;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.FileVO;
import kr.green.study.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	private BoardDAO boardDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	private String uploadPath = "D:\\JAVA_JIK\\uploadfiles";
	private String uploadThumbnailPath = "D:\\JAVA_JIK\\project_jik\\study\\src\\main\\webapp\\resources\\img";
	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		return boardDao.selectBoardList(cri);
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
		//비밀번호 암호화, 단, 비밀번호가 있는 경우
		if(board.getPw() != null && board.getPw().length() != 0) {
			String encodePw = passwordEncoder.encode(board.getPw());
			board.setPw(encodePw);
		}
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
	public void updateBoard(BoardVO board, MemberVO user, MultipartFile[] fileList, Integer[] fileNumList) throws Exception {
		if(user == null || board == null)
			return;
		BoardVO dbBoard = boardDao.selectBoard(board.getNum());
		if(dbBoard == null || !user.getId().equals(dbBoard.getWriter()))
			return;
		dbBoard.setTitle(board.getTitle());
		dbBoard.setContents(board.getContents());
		boardDao.updateBoard(dbBoard);
		
		ArrayList<Integer> dbFileNumList = boardDao.selectFileNumList(board.getNum());
		int dbSize = 0;
		if(dbFileNumList != null) {
			dbSize = dbFileNumList.size();
			//배열 fileNumList를 ArraylList로 변환
			ArrayList<Integer> inputFileNumList = new ArrayList<Integer>();
			if(fileNumList != null) {
				for(Integer tmp : fileNumList) {
					inputFileNumList.add(tmp);
					dbSize--;
				}
			}
			if(dbBoard.getType().equals("IMAGE"))
				dbFileNumList.remove(0);
			//dbFileNumList에 있는 첨부파일 번호들 중에서 inputFileNumList에 없는 첨부파일을 삭제
			for(Integer tmp : dbFileNumList) {
				if(!inputFileNumList.contains(tmp)) {
					deleteFile(boardDao.selectFile(tmp));
				}
			}
		}
		//fileList에 있는 첨부파일 추가
		if(fileList == null)
			return;
		for(MultipartFile tmp : fileList) {
			if(insertFile(tmp, board.getNum()))
				dbSize++;
			if(dbSize == 3)
				break;
		}
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
	

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.getTotalCount(cri);
	}

	@Override
	public void insertBoard(BoardVO board, MultipartFile[] fileList, MemberVO user, MultipartFile mainImage) throws Exception {
		insertBoard(board,fileList,user);
		insertFile(mainImage, board.getNum(), "Y");
	}

	private boolean insertFile(MultipartFile tmp, int num, String thumbnail) throws Exception {
		if(tmp == null || tmp.getOriginalFilename().length() == 0) {
			return false;
		}
		String path;
		if(thumbnail.equals("Y")) {
			path = uploadThumbnailPath;
		}else {
			path = uploadPath;
		}
		String name = UploadFileUtils.uploadFile(path, tmp.getOriginalFilename(), tmp.getBytes());
		FileVO file = new FileVO(num, name, tmp.getOriginalFilename());
		file.setThumbnail(thumbnail);
		boardDao.insertFile(file);
		return true;
	}
	private boolean insertFile(MultipartFile tmp, int num) throws Exception {
		return insertFile(tmp, num, "N");
	}
	private void deleteFile(FileVO tmp) {
		String path;
		if(tmp.getThumbnail().equals("Y")) {
			path = uploadThumbnailPath;
		}else {
			path = uploadPath;
		}
		File file = new File(path+tmp.getName());
		if(file.exists())
			file.delete();
		boardDao.deleteFile(tmp.getNum());
	}

	@Override
	public void getThumbnail(ArrayList<BoardVO> list) {
		if(list == null || list.size() == 0)
			return;
		for(BoardVO tmp : list) {
			tmp.setThumbnail(boardDao.selectThumnail(tmp.getNum()));
		}
	}

	@Override
	public void updateBoard(BoardVO board, MemberVO user, MultipartFile[] fileList, Integer[] fileNumList,
			MultipartFile mainImage, Integer thumbnailNo) throws Exception {
		updateBoard(board, user, fileList, fileNumList);
		if(thumbnailNo != null)
			return;
		ArrayList<Integer> dbFileNumList = boardDao.selectFileNumList(board.getNum());
		deleteFile(boardDao.selectFile(dbFileNumList.get(0)));
		insertFile(mainImage, board.getNum(),"Y");
	}
}
