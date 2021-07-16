package kr.green.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.pagination.*;
import kr.green.test.service.*;
import kr.green.test.vo.*;
import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/list")
	public ModelAndView list(ModelAndView mv,String msg, Criteria cri) {
		cri.setPerPageNum(2);
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		//현재 페이지 정보(검색타입, 검색어)에 대한 총 게시글 수를 가져와야함
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 2, cri);
		mv.addObject("pm", pm);
		mv.addObject("list", list);
		mv.addObject("msg", msg);
		mv.setViewName("/template/board/list");
		return mv;
	}
	@RequestMapping(value="/detail")
	public ModelAndView detail(ModelAndView mv, Integer num, String msg) {
		boardService.updateViews(num);
		BoardVO board = boardService.getBoard(num);
		mv.addObject("board", board);
		mv.addObject("msg", msg);
		
		ArrayList<FileVO> fileList = boardService.getFileList(num);
		mv.addObject("fileList",fileList);
		log.info(fileList);
		mv.setViewName("/template/board/detail");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registerGet(ModelAndView mv) {
		mv.setViewName("/template/board/register");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, 
			HttpServletRequest r, MultipartFile[] files) {
		MemberVO user = memberService.getMember(r);
		boardService.insertBoard(board, user, files);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public ModelAndView modifyGet(ModelAndView mv, Integer num) {
		log.info("/board/modify : "+num);
		BoardVO board = boardService.getBoard(num);
		mv.addObject("board", board);
		mv.setViewName("/template/board/modify");
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv, BoardVO board, HttpServletRequest r) {
		log.info("/board/modify:POST : " + board);
		MemberVO user = memberService.getMember(r);
		int res = boardService.updateBoard(board, user);
		String msg="";
		mv.setViewName("redirect:/board/detail");
		if(res == 1)
			msg = board.getNum()+"번 게시글이 수정되었습니다.";
		else if(res == 0)
			msg = "없는 게시글입니다.";
		else if(res == -1) {
			msg = "잘못된 접근입니다.";
			mv.setViewName("redirect:/board/list");
		}
		mv.addObject("msg", msg);
		mv.addObject("num",board.getNum());
		return mv;
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView deletePost(ModelAndView mv, Integer num,HttpServletRequest r) {
		log.info("/board/delete : "+num);
		MemberVO user = memberService.getMember(r);
		int res = boardService.deleteBoard(num, user);
		if(res == 1) {
			mv.addObject("msg",num+"번 게시글을 삭제 했습니다.");
		}else if(res == 0) {
			mv.addObject("msg","게시글이 없거나 이미 삭제되었습니다.");
		}else if(res == -1) {
			mv.addObject("msg","잘못된 접급입니다.");
		}
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}
