package com.test4.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.test4.Movie;
import com.test4.User;
import com.test4.board.Board;
import com.test4.dao.Dao;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	Dao dao;
	private final RestTemplate restTemplate = new RestTemplate();
	private String CLIENT_ID="MxEsyV50rgWePBk53zW9"; 
	private String CLIENT_SECRET = "aRu9yb2Q7b";
	
	private String openNaverMovieUrl="https://openapi.naver.com/v1/search/movie.json?query={keyword}";

	
	
	public int memberid(String id) { //회원 아이디 return
		
		return dao.memberid(id);
	}
	
	public void memberOk(String memId,String mempwd,String memname,int year,int month,int day ) { //회원가입 완료
		String birth=year+"-"+month+"-"+day;
		dao.memberOk(memId, mempwd, memname,birth);
	}
	
}
