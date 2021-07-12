package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

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

	    System.out.println("인터셉터 : "+user);
	    if(user != null) {
	    	//리퀘스트에 있는 세션 정보를 가져옴
	        HttpSession session = request.getSession();
	        //세션에 user라는 정보를 추가
	        session.setAttribute("user", user);
	    }
	}
}
