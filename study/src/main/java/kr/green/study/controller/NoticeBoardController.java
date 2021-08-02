package kr.green.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.study.pagination.Criteria;
import kr.green.study.pagination.PageMaker;
import kr.green.study.service.BoardService;
import kr.green.study.service.MemberService;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.FileVO;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/board/notice")
public class NoticeBoardController {
	
	private BoardService boardService;
	private MemberService memberService;
	
	@GetMapping("/list")
	public ModelAndView listGet(ModelAndView mv, Criteria cri) {
		cri.setType("NOTICE");
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 10, cri);
		mv.addObject("pm", pm);
		mv.addObject("list",list);
		mv.addObject("type", "/notice");
		mv.setViewName("/template/board/list");
		return mv;
	}
	@GetMapping("/detail")
	public ModelAndView detailGet(ModelAndView mv, Integer num) {
		boardService.updateViews(num);
		BoardVO board = boardService.getBoard(num);
		
		ArrayList<FileVO> fList = boardService.getFileList(num);
		
		mv.addObject("board", board);
		mv.addObject("fList", fList);
		mv.addObject("type", "/notice");
		mv.setViewName("/template/board/detail");
		return mv;
	}
	@GetMapping("/register")
	public ModelAndView registerGet(ModelAndView mv) {
		mv.setViewName("/template/board/register");
		mv.addObject("type", "/notice");
		return mv;
	}
	@PostMapping("/register")
	public ModelAndView registerPost(ModelAndView mv,BoardVO board, 
			MultipartFile [] fileList, HttpServletRequest request ) throws Exception {
		MemberVO user = memberService.getMemberByRequest(request);
		board.setType("NOTICE");
		boardService.insertBoard(board, fileList, user);
		mv.setViewName("redirect:/board/notice/list");
		return mv;
	}
	@GetMapping("/modify")
	public ModelAndView modifyGet(ModelAndView mv,Integer num) {
		BoardVO board = boardService.getBoard(num);
		ArrayList<FileVO> fList = boardService.getFileList(num);
		mv.addObject("board", board);
		mv.addObject("fList",fList);
		mv.addObject("type", "/notice");
		mv.setViewName("/template/board/modify");
		return mv;
	}
	@PostMapping("/modify")
	public ModelAndView modifyPost(ModelAndView mv,BoardVO board, HttpServletRequest request,
			MultipartFile[] fileList, Integer [] fileNumList) throws Exception {
		MemberVO user = memberService.getMemberByRequest(request);
		boardService.updateBoard(board,user,fileList, fileNumList);
		mv.addObject("num", board.getNum());
		mv.setViewName("redirect:/board/notice/detail");
		return mv;
	}
	@GetMapping("/delete")
	public ModelAndView deleteGet(ModelAndView mv,Integer num,HttpServletRequest request) {
		MemberVO user = memberService.getMemberByRequest(request);
		boardService.deleteBoard(num, user);
		mv.setViewName("redirect:/board/notice/list");
		return mv;
	}
	@ResponseBody
	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    return boardService.downloadFile(fileName);
	}
}
