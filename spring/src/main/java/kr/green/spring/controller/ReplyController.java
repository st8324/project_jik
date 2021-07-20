package kr.green.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {

	@GetMapping(value="/test/{str}")
	public String test(@PathVariable("str") String str) {
		System.out.println(str);
		return "ok";
	}
}
