package kr.green.study.service;

import org.springframework.stereotype.Service;

import kr.green.study.dao.MemberDAO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImp implements MemberService{
	
	MemberDAO memberDao;
}
