package kr.green.test.service;

import java.util.Date;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
    MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public void signup(MemberVO user) {
		if(user == null) 
			return;
		//필수 항목 체크
		if( user.getId() == null || user.getId().trim().length() == 0 ||
			user.getPw() == null || user.getPw().trim().length() == 0 ||
			user.getName() == null || user.getName().trim().length() == 0 ||
			user.getEmail() == null || user.getEmail().trim().length() == 0)
			return;
		//정규표현식 체크해야 하는데 나중에 할 예정
		
		//암호화
		String ePw = passwordEncoder.encode(user.getPw());
		user.setPw(ePw);
		//회원가입
		memberDao.insertMember(user);
	}

	@Override
	public MemberVO signin(MemberVO user) {
		if(user == null || user.getId() == null || user.getId().trim().length() == 0
			|| user.getPw() ==null || user.getPw().trim().length() == 0)
			return null;
		MemberVO dbUser = memberDao.getMember(user.getId());
		if(dbUser == null)
			return null;
		if(passwordEncoder.matches(user.getPw(), dbUser.getPw())) {
			dbUser.setUseCookie(user.getUseCookie());
			return dbUser;
		}
		return null;
	}

	@Override
	public MemberVO getMember(HttpServletRequest r) {
		if(r == null || r.getSession() == null)
			return null;
		return (MemberVO) r.getSession().getAttribute("user");
	}

	@Override
	public MemberVO updateMember(MemberVO user, MemberVO sUser) {
		if(user == null || sUser == null || 
			user.getId() == null || !user.getId().equals(sUser.getId()))
			return null;
		if(user.getPw() != null && user.getPw().trim().length() != 0) {
			String ePw = passwordEncoder.encode(user.getPw());
			sUser.setPw(ePw);
		}
		sUser.setEmail(user.getEmail());
		sUser.setGender(user.getGender());
		sUser.setName(user.getName());
		memberDao.updateMember(sUser);
		return sUser;
	}

	@Override
	public boolean idCheck(String id) {
		if(id == null || id.length() == 0 )
			return false;
		return memberDao.getMember(id) == null ? true : false;
	}

	@Override
	public void keepLogin(String id, String session_id, Date session_limit) {
		if(id == null || session_id == null || session_limit == null) {
			return;
		}
		memberDao.keepLogin(id, session_id, session_limit);
	}

	@Override
	public MemberVO getMemberByCookie(String value) {
		
		return memberDao.getMemberByCookie(value);
	}

	@Override
	public String findPw(String id) {
		if(id == null)
			return "FAIL";
		
		MemberVO user = memberDao.getMember(id);
		
		if(user == null)
			return "FAIL";
		//비밀번호 8자리 랜덤 생성
		String newPw = newRandomPw(8);
		//새 비밀번호로 변경
		user.setPw(newPw);
		updateMember(user, user);
		//새 비밀번호를 메일로 전송
		try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom("stajun@gmail.com");
	        messageHelper.setTo(user.getEmail());     
	        messageHelper.setSubject("새 비밀번호입니다."); 
	        messageHelper.setText("","발급된 새 비밀번호는 <h3>" + newPw + "</h3>입니다.");  // 메일 내용

	        mailSender.send(message);
	        return "SUCCESS";
	    } catch(Exception e){
	        System.out.println(e);
	    }
		
		return "FAIL";
	}
	private String newRandomPw(int size) {
		int min = 0, max = 61;
		String str = "";
		for(int i = 0; i<size; i++) {
			int r = (int)(Math.random()*(max - min + 1) + min);
			if( r < 10)
				str += r;
			else if(r < 36)
				str += (char) ('a' + (r - 10));
			else if(r < 62)
				str += (char) ('A' + (r - 36));
		}
		return str;
	}
}
