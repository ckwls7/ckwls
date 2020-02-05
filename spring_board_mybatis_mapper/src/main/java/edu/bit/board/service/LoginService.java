package edu.bit.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.LoginMapper;
import edu.bit.board.vo.UserVO;

@Service
public class LoginService {//비지니스 로직이 들어가야함
	
	@Autowired
	LoginMapper loginMapper;
	
	public UserVO loginUser(String id,String pw) {
		return loginMapper.loginUser(id,pw);
	}
	
}

