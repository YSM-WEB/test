package com.test4.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
	List<Board> board(int num);
	void boardWrite(Board board);
	int boardfind();
	Board boardview(int num);
	void boardLook(int num);
	void boardRemove(int num);
	void replyWrite(HashMap<String,	Object> map);
	List<Map<String,String>> boardReply(int num);
	void replyUp(int num);
}
