package kr.green.study.interceptor;

import java.util.Date;

import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;

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
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");

	    if(user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	        if(user.getUseCookie() != null) {
	        	Cookie loginCookie = new Cookie("loginCookie", session.getId());
	        	int timeSecond = 60 * 60 * 24 * 7;//7일을 초로 환산
	        	loginCookie.setPath("/");
	        	loginCookie.setMaxAge(timeSecond);
	        	response.addCookie(loginCookie);
	        	memberService.keepLogin(user.getId(), session.getId(), 
	        		new Date(System.currentTimeMillis() + timeSecond * 1000));
	        }
	    }
	}

}
