package kr.green.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;
import lombok.Data;

@Controller
public class HomeController {
	@Autowired
    MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv) {
		mv.setViewName("signin");
		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv,MemberVO user) {
		System.out.println(user);
		//서비스에게 아이디와 비밀번호를 전달하면, 해당 정보가 DB에 있으면
		//회원 정보를 없으면 null을 반환
		//작업이 다 끝난 후 URI가 /signin인 곳으로 넘어감
		MemberVO dbUser = memberService.signin(user);
		//회원 정보가 있으면 => 로그인에 성공하면
		if(dbUser != null) {
			mv.setViewName("redirect:/");
		}
		//회원 정보가 없으면 => 일치하는 아이디가 없던지, 비밀번호가 잘못되던지
		//				 => 로그인 실패
		else {
			mv.setViewName("redirect:/signin");
		}
		return mv;
	}
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.setViewName("signup");
		return mv;
	}
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
		System.out.println(user);
		//서비스에게 회원 정보를 주면서 회원 가입하라고 일을 시키고, 회원 가입이 성공하면 true를
		//실패하면 false를 알려달라고 요청
		boolean isSignup = memberService.signup(user);
		//회원 가입에 성공하면 메인으로 실패하면 회원가입 페이지로
		if(isSignup) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	@RequestMapping(value="/member/mypage", method = RequestMethod.GET)
	public ModelAndView memberMypageGet(ModelAndView mv, String id) {
		//서비스에게 아이디를 주면서 회원 정보를 가져오라고 시킴
		MemberVO user = memberService.getMember(id);
		//가져온 회원 정보를 화면에 전달
		mv.addObject("user", user);
		mv.setViewName("member/mypage");
		return mv;
	}
	@RequestMapping(value="/member/mypage", method = RequestMethod.POST)
	public ModelAndView memberMypagePost(ModelAndView mv, MemberVO user) {
		//서비스에게 회원 정보를 주면서 수정하라고 요청
		memberService.updateMember(user);
		mv.setViewName("redirect:/member/mypage");
		return mv;
	}
}