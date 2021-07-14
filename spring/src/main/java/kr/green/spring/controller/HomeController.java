package kr.green.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

@Controller
public class HomeController {
	@Autowired
    MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/template/main/home");
		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv) {
		mv.setViewName("/template/member/signin");
		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv,MemberVO user) {
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
		mv.addObject("user", dbUser);
		return mv;
	}
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.setViewName("/template/member/signup");
		return mv;
	}
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
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
	public ModelAndView memberMypageGet(ModelAndView mv) {
		
		mv.setViewName("/template/member/mypage");
		return mv;
	}
	@RequestMapping(value="/member/mypage", method = RequestMethod.POST)
	public ModelAndView memberMypagePost(ModelAndView mv, MemberVO user, HttpServletRequest request) {
		//request에 있는 세션 안에 있는 로그인한 회원 정보를 가져옴
		MemberVO sessionUser = memberService.getMember(request);
		//세션에 로그인한 회원 정보가 있고, 세션에 있는 아이디와 수정할 아이디가 같으면 회원 정보 수정함
		if(sessionUser != null && sessionUser.getId().equals(user.getId())) {
			MemberVO updatedUser = memberService.updateMember(user);
			if(updatedUser != null) {
				request.getSession().setAttribute("user", updatedUser);
			}
		}
		mv.setViewName("redirect:/member/mypage");
		return mv;
	}
	@RequestMapping(value="/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
}