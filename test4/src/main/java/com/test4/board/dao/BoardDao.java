package com.test4.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test4.board.Board;
import com.test4.board.BoardMapper;

@Repository
public class BoardDao {
	
	@Autowired
	BoardMapper mapper;
	
	public void boardWrite(Board board) {
		mapper.boardWrite(board);
	}
	
	public List<Board> board(int num){
		
		return mapper.board(num);
	}
	public int boardfind() {
		
		return mapper.boardfind();
	}
	public Board boardview(int num) {
		mapper.boardLook(num);
		return mapper.boardview(num);
	}
	public void boardRemove(int num) {
		mapper.boardRemove(num);
	}
	public void replyWrite(HashMap<String, Object> map) {
		mapper.replyWrite(map);
		mapper.replyUp((int)map.get("num"));
	}
	public List<Map<String,String>> boardReply(int num){
		List<Map<String,String>> map = mapper.boardReply(num);
		System.out.println(map);
		return map;
	}
	
}
