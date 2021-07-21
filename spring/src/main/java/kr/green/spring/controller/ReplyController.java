package kr.green.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.green.spring.service.ReplyService;
import kr.green.spring.vo.ReplyVO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReplyController {

	private ReplyService replyService;
	
	@PostMapping(value="/reply/ins")
	public String replyInsPost(@RequestBody ReplyVO reply) {
		replyService.insertReply(reply);
		return "ok";
	}
	@GetMapping(value="/reply/list/{num}")
	public HashMap<String, Object> replyListGet(
			@PathVariable("num") Integer num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<ReplyVO> list = replyService.getReplyList(num);
		map.put("list", list);
		return map;
	}
}
