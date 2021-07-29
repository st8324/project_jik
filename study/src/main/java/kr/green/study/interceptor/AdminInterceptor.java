package kr.green.study.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null || user.getAuthority().equals("USER") ) {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}
		return true;
	}
	
}
