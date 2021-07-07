package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;

	@RequestMapping(value="/board/list")
	public ModelAndView boardList(ModelAndView mv) {
		//서비스에게 모든 게시글을 가져오라고 시킴
		ArrayList<BoardVO> list = boardService.getBoardList();
		//화면에 모든 게시글을 전송
		mv.addObject("list",list);
		mv.setViewName("board/list");
		return mv;
	}
	@RequestMapping(value="/board/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer num) {
		//게시글을 가져오기 전 조회수를 증가
		//서비스에게 게시글 번호를 주면서 게시글 조회수를 1증가시키라고 시킴
		boardService.updateViews(num);
		//서비스에게 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardService.getBoard(num);
		//가져온 게시글을 화면에 전달, 화면으로 보낼 이름은 board로
		mv.addObject("board", board);
		mv.setViewName("board/detail");
		return mv;
	}
	@RequestMapping(value="/board/register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		
		mv.setViewName("board/register");
		return mv;
	}

	@RequestMapping(value="/board/register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv,BoardVO board) {
		//서비스에게 게시글 정보(제목, 작성자, 내용)을 주면서 게시글을 등록하라고 시킴
		boardService.insertBoard(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		BoardVO board = boardService.getBoard(num);
		mv.addObject("board", board);
		mv.setViewName("board/modify");
		return mv;
	}
}
