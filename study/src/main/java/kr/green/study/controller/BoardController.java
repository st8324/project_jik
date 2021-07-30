package kr.green.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.green.study.service.BoardService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView listGet(ModelAndView mv) {
		
		mv.setViewName("/template/board/list");
		return mv;
	}
}
