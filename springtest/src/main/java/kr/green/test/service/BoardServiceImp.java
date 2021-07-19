package kr.green.test.service;

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

import kr.green.test.dao.BoardDAO;
import kr.green.test.pagination.Criteria;
import kr.green.test.utils.UploadFileUtils;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.MemberVO;

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
//		if(num == null) {
//			return null;
//		}
//		return boardDao.getBoard(num);
		return num == null ? null : boardDao.getBoard(num);
	}

	@Override
	public int updateViews(Integer num) {
		//다오에게 게시글 정보를 가져오라고 요청
		BoardVO board = boardDao.getBoard(num);
		if(board == null) {
			return 0;
		}
		board.setViews(board.getViews()+1);
		return boardDao.updateBoard(board);
	}

	@Override
	public void insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if(board == null || board.getTitle().trim().length() == 0) {
			return;
		}
		if(user == null || user.getId() == null || user.getId().trim().length() == 0)
			return;
		board.setWriter(user.getId());
		boardDao.insertBoard(board);

		if(files == null || files.length == 0)
			return;
		for(MultipartFile file : files) {
			insertFile(file, board.getNum());
		}
	}

	@Override
	public int deleteBoard(Integer num, MemberVO user) {
		if(num == null) {
			return 0;
		}
		BoardVO board = boardDao.getBoard(num);
		if(board == null) {
			return 0;
		}
		if(user == null || !user.getId().equals(board.getWriter())) {
			return -1;
		}
		//게시글에 있는 첨부파일을 가져옴
		ArrayList<FileVO> fileList = boardDao.getFileList(num);
		//첨부파일들을 반복문을 이용하여 하나씩 삭제처리(이때, 서버에 있는 파이을 삭제)
		if(fileList != null && fileList.size() != 0) {
			for(FileVO file : fileList) {
				deleteFile(file);
			}
		}
		board.setValid("D");
		return boardDao.updateBoard(board);
	}

	@Override
	public int updateBoard(BoardVO board, MemberVO user, MultipartFile[] files, Integer[] filenums) {
		if(board == null || board.getNum() <= 0) {
			return 0;
		}
		if(user == null) {
			return -1;
		}
		BoardVO dbBoard = boardDao.getBoard(board.getNum());
		if(dbBoard == null || !user.getId().equals(dbBoard.getWriter())) {
			return -1;
		}
		//기존 첨부파일 중 정보가 넘어오지 않은 첨부파일 삭제(화면에서 첨부파일 옆에 있는 x버튼 클릭)
		//기존 첨부파일 가져옴
		ArrayList<FileVO> dbFileList = boardDao.getFileList(dbBoard.getNum());
		
		//화면 가져온 첨부파일을 배열에서 리스트로 변경(리스트에서 제공하는 contains를 이용하기 위해서)
		ArrayList<Integer> arrayFilenums = new ArrayList<Integer>();
		if(filenums != null) {
			for(int tmp : filenums) {
				arrayFilenums.add(tmp);
			}
		}
		
		//기존 첨부파일 중에서 화면에서 가져온 첨부파일에 번호가 없으면 해당 첨부파일 삭제
		for(FileVO tmp : dbFileList) {
			if(!arrayFilenums.contains(tmp.getNum())) {
				deleteFile(tmp);
			}
		}
		
		//새로운 첨부파일 추가
		if(files != null && files.length != 0) {
			for(MultipartFile file : files) {
				insertFile(file, board.getNum());
			}
		}
		dbBoard.setContents(board.getContents());
		dbBoard.setTitle(board.getTitle());
		return boardDao.updateBoard(dbBoard);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.getTotalCount(cri);
	}

	@Override
	public ArrayList<FileVO> getFileList(Integer num) {
		if(num == null)
			return null;
		return boardDao.getFileList(num);
	}

	@Override
	public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
		InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
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
	private void deleteFile(FileVO file) {
		//서버에 있는 파일을 삭제
		File f = new File(uploadPath + file.getName());
		if(f.exists()) {
			f.delete();
		}
		//DB에 첨부파일 정보를 삭제 처리
		boardDao.deleteFile(file.getNum());
	}
	private void insertFile(MultipartFile file, int num) {
		if(file != null && file.getOriginalFilename().length() != 0) {
			try {
				//첨부파일을 업로드 한 후 경로를 반환해서 ori_name에 저장
				String name = UploadFileUtils.uploadFile(uploadPath, 
						file.getOriginalFilename(), file.getBytes());
				//첨부파일 객체 생성
				FileVO fvo = new FileVO(num,name,file.getOriginalFilename());
				//DB에 첨부파일 정보 추가
				boardDao.insertFile(fvo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
