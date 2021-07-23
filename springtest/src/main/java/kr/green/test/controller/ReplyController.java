package kr.green.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.green.test.service.ReplyService;
import kr.green.test.vo.ReplyVO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService replyService;
	
	@PostMapping("/reply/ins")
	public String replyInsGet(@RequestBody ReplyVO rvo) {
		return replyService.insertReply(rvo) == 0 ? "FAIL" : "OK";
	}
	@GetMapping("/reply/list/{rp_bd_num}")
	public Map<String, Object> replyListGet(@PathVariable("rp_bd_num") int rp_bd_num){
		ArrayList<ReplyVO> list = replyService.getReplyList(rp_bd_num);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("replyList", list);
		return map;
	}
}
