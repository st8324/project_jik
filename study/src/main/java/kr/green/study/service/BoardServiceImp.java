package kr.green.study.service;

import org.springframework.stereotype.Service;

import kr.green.study.dao.BoardDAO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImp implements BoardService {
	private BoardDAO boardDao;
}
