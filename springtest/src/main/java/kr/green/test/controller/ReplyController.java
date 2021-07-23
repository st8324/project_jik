package kr.green.test.controller;

import org.springframework.web.bind.annotation.*;

import kr.green.test.service.*;
import kr.green.test.vo.*;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService replyService;
	
	@PostMapping("/reply/ins")
	public String replyInsGet(@RequestBody ReplyVO rvo) {
		return replyService.insertReply(rvo) == 0 ? "FAIL" : "OK";
	}
	
}
