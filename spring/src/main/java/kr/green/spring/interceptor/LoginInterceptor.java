package kr.green.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		//mv.addObejct("user",xxx)으로 정보를 전달한 내용 있으면
		//가져오는 코드
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");

	    if(user != null) {
	    	//리퀘스트에 있는 세션 정보를 가져옴
	    	HttpSession session = request.getSession();
	    	
	    	//로그인 유지를 해야하는 상황
	    	if(user.getUseCookie() != null) {
	    		//쿠기 생성
	    		Cookie loginCookie = new Cookie("loginCookie", session.getId());
	    		loginCookie.setPath("/");
	    		//쿠키 유지시간
	    		int day = 7;
	    		int amount = 60 * 60 * 24 * day;
	    		loginCookie.setMaxAge(amount);
	    		response.addCookie(loginCookie);
	    		//현재 시간에서 유지시간을 더한 날짜를 구함(로그인 시간을 기준으로 7일 뒤)
	    		Date session_limit = new Date(System.currentTimeMillis() + (1000*amount));
	    		memberService.keeplogin(user.getId(), session.getId(), session_limit);
	    	}
	    	
	        //세션에 user라는 정보를 추가
	        session.setAttribute("user", user);
	    }
	}
}
