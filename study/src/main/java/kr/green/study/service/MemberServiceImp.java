package kr.green.study.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import kr.green.study.dao.MemberDAO;
import kr.green.study.pagination.Criteria;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImp implements MemberService{
	
	MemberDAO memberDao;
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO user) {
		if(user == null)
			return false;
		//아이디 유효성 검사
		String idRegex = "^[a-z0-9_-]{5,20}$";
		if(user.getId() == null || !Pattern.matches(idRegex, user.getId()) )
			return false;
		//비밀번호 유효성 검사
		String pwRegex = "^[a-zA-Z0-9!@#]{8,16}$";
		if(user.getPw() == null || !Pattern.matches(pwRegex, user.getPw()))
			return false;
		//이메일 유효성 검사, xx@yy.zz or xx@yy.zz.cc
		String emailRegex = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		if(user.getEmail() == null || !Pattern.matches(emailRegex, user.getEmail()))
			return false;
		//이름 유효성 검사
		if(user.getName() == null || user.getName().trim().length() == 0)
			return false;
		//성별 유효성 검사
		if(user.getGender() == null)
			return false;
		//비밀번호 암호화
		String encPw = passwordEncoder.encode(user.getPw());
		user.setPw(encPw);
		memberDao.insertMember(user);
		return true;
	}

	@Override
	public MemberVO signin(MemberVO user) {
		if(user == null || user.getId() == null)
			return null;
		MemberVO dbUser = memberDao.selectUser(user.getId());
		//잘못된 ID == 회원이 아닌
		if(dbUser == null)
			return null;
		//잘못된 비번
		if(user.getPw() == null || !passwordEncoder.matches(user.getPw(), dbUser.getPw()))
			return null;
		//자동로그인 기능을 위해
		dbUser.setUseCookie(user.getUseCookie());
		return dbUser;
	}

	@Override
	public Object getMember(String id) {
		if(id == null)
			return null;
		return memberDao.selectUser(id);
	}

	@Override
	public void signout(HttpServletRequest request , HttpServletResponse response) {
		if(request == null || response == null)
			return;
		MemberVO user = getMemberByRequest(request);
		if(user == null)
			return;
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.invalidate();
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie == null)
			return ;
		loginCookie.setPath("/");
		loginCookie.setMaxAge(0);
		response.addCookie(loginCookie);
		keepLogin(user.getId(), "none", new Date());
	}

	@Override
	public void keepLogin(String id, String session_id, Date session_limit) {
		if(id == null )
			return ;
		memberDao.keepLogin(id, session_id, session_limit);
	}

	@Override
	public MemberVO getMemberByCookie(String session_id) {
		if(session_id == null)
			return null;
		return memberDao.selectUserBySeesion(session_id);
	}

	@Override
	public MemberVO getMemberByRequest(HttpServletRequest request) {
		if(request == null)
			return null;
		return (MemberVO)request.getSession().getAttribute("user");
	}

	@Override
	public ArrayList<MemberVO> getMemberList(MemberVO user , Criteria cri) {
		if(user == null || user.getAuthority().equals("USER"))
			return null;
		return memberDao.selectUserList(user.getAuthority(), cri);
	}

	@Override
	public boolean updateAuthority(MemberVO user, MemberVO loginUser) {
		if(user == null || loginUser == null)
			return false;
		System.out.println(loginUser.compareAuthority(user));
		if(loginUser.compareAuthority(user) <= 0)
			return false;
		MemberVO dbUser = memberDao.selectUser(user.getId());
		System.out.println(dbUser);
		dbUser.setAuthority(user.getAuthority());
		memberDao.updateUser(dbUser);
		return true;
	}

	@Override
	public int getTotalCount(MemberVO user) {
		if(user == null)
			return 0;
		return memberDao.getTotalCount(user.getAuthority());
	}
}
