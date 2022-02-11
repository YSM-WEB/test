package com.test4.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.test4.service.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test4.Movie;
import com.test4.User;
import com.test4.board.Board;

@Controller
public class HomeController {
	
	@Autowired
	Service service;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@RequestMapping("/")
	public String home(Model model,HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");
		//프록시
		if (ip == null || ip.length() == 0) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        //웹로직
        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0) {
            ip = request.getRemoteAddr() ;
        }
        System.out.println(ip);
		return "home";
	}

	@RequestMapping("/login") //로그인 페이지
	public String login(Model model) {

		return "login";
	}
	@RequestMapping("/member")// 회원가입 페이지
	public String member(Model model) {
		return "member";
	}
	
	@RequestMapping("/memberid") // 회원가입 시 아이디 중복검사 비동기
	@ResponseBody
	public int memberid(@RequestParam String id) {
		if(service.memberid(id)==0) return 0;
		else return 1;
	}
	
	@RequestMapping(value="/memberOk",method=RequestMethod.POST) //회원가입 완료
	public String memberOk(User user) {
		service.memberOk(user.getMemId(), user.getMemPwd(), user.getMemName(),user.getMemBirthYear(),user.getMemBirthMonth(),user.getMemBirthDay());
		return "redirect:/";
	}
	@RequestMapping("/userinfo")
	public String userinfo(){
		
		return "user/userinfo";
	}
	
	@RequestMapping("/imgSound")
	public String imgSound() {
		
		return "imgSound";
	}
	

}
