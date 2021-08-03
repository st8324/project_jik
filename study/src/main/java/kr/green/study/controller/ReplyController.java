package kr.green.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.study.service.MemberService;
import kr.green.study.service.ReplyService;
import kr.green.study.vo.MemberVO;
import kr.green.study.vo.ReplyVO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
	
	private ReplyService replyService;
	private MemberService memberService;
	
	@PostMapping("/add")
	public String addPost(@RequestBody ReplyVO reply, HttpServletRequest request) {
		MemberVO user = memberService.getMemberByRequest(request);
		return replyService.insertReply(reply, user);
	}
}
