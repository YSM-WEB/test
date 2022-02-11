package com.test4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test4.Mapper;
import com.test4.User;
import com.test4.board.Board;
import com.test4.board.BoardMapper;
import com.test4.security.CtUserDetails;

@Repository
public class Dao {
	@Autowired
	Mapper mapper;

	
		
		
		
		public int memberid(String id) {
			
			return mapper.memberid(id);
		}
		
		public void memberOk(String memId,String mempwd,String memname,String birth) {
			
			mapper.memberOk(memId, mempwd, memname,birth);
		}
		
		
		
		public CtUserDetails loginuser(String username) {
			return mapper.userlogin(username);
		}
		
		public CtUserDetails userlogin(String username) { //시큐리티 로그인 정보
			// TODO Auto-generated method stub
			return mapper.userlogin(username);
		}
		
		
}
