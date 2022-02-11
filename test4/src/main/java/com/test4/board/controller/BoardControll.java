package com.test4.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test4.board.Board;
import com.test4.board.service.BoardService;

@Controller
public class BoardControll {
	
	@Autowired
	BoardService service;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	
	
	@RequestMapping("/board/write") //게시판 글쓰는 페이지
	public String board() {
		
		return "board/write";
	}
	@RequestMapping(value="/board/writeComplete",method=RequestMethod.POST) // 글쓴거 등록
	public String boardComplete(Board board) {
		service.boardWrite(board);
		return "redirect:/board";
	}
	@RequestMapping(value={"/board/{num}","/board"}) // 게시판 목록 페이지당 10개
	public String board(@PathVariable(required=false) Integer num, Model model) {
		if(num==null) num=0;
		else num-=1;
		
		List<Board> board=service.board(num*10);
		model.addAttribute("page",service.boardfind(num));
		model.addAttribute("board",board);
		return "board/board";
	}
	@RequestMapping(value="/view/{num}") // 게시판 글 보는 페이지
	public String boardview(@PathVariable Integer num,Model model) {
	
		model.addAttribute("view",service.boardview(num));
		model.addAttribute("reply",service.boardReply(num));

		return "board/view";
	}
	@RequestMapping(value="/board/remove/{num}") // 글 삭제
	public String boardRemove(@PathVariable Integer num) {
		service.boardRemove(num);
		return "redirect:/board";
	}
	@RequestMapping(value="/board/replyWrite",method=RequestMethod.POST) // 댓글 등록
	@ResponseBody
	public void replyWrite(@RequestBody HashMap<String, Object> map) {
		service.replyWrite(map);
	}
}
