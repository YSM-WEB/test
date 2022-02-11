package com.test4;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

import com.test4.board.Board;
import com.test4.security.CtUserDetails;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
	List<User> userfind();
	int memberid(String id);
	void memberOk(String memId,String mempwd,String memname,String birth);
	CtUserDetails userlogin(String username);
	Board boardview(int num);
}
