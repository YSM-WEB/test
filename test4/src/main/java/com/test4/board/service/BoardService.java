package com.test4.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.test4.board.Board;
import com.test4.board.dao.BoardDao;

@Service
public class BoardService {

	@Autowired
	BoardDao dao;
	
	public void boardWrite(Board board) {
		
		dao.boardWrite(board);
	}
	
	public List<Board> board(int num){ //  게시판 목록 return
		
		return dao.board(num);
	}
	
	public Map<String,Integer> boardfind(int num) {
		
		Map<String, Integer> map=new HashMap<String, Integer>();
		int page=(int)Math.ceil((double)dao.boardfind()/10.0);
		int start=num/10*10+1;
		int end=0;
		if(start+9<page) {
			end=start+9;
		}else {
			end=page;
		}
		map.put("start", start); //게시판 페이지 첫번쨰 순서
		map.put("end", end);	// 게시판 마지막 페이지 순서
		map.put("current", num+1); // 게시판 페이지의 현재 페이지
		map.put("allpage", page); // 게시판의 모든 페이지 수 
		
		
		return map;
	}
	public Board boardview(int num) {
		
		return dao.boardview(num);
	}
	public void boardRemove(int num) {
		dao.boardRemove(num);
	}
	public void replyWrite(HashMap<String, Object> map) {
		dao.replyWrite(map);
	}
	public List<Map<String,String>> boardReply(int num) {
		return dao.boardReply(num);
	}
}
