package com.test4.movie.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.test4.Movie;
import com.test4.movie.service.MovieService;
import com.test4.service.Service;




@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@RequestMapping("/find")
	@ResponseBody
	public String movie( //네이버 api 이용하여 이미지 가져옴
			@RequestParam String keyword,
			@RequestParam String prdtYear,
			@RequestParam String genreNm,
			@RequestParam String nationNm) throws Exception {
		
		return service.find(keyword,prdtYear,genreNm,nationNm);
	}
	@RequestMapping("/boxOffice")
	public String boxOffice() {
		
		return "movie/boxOffice";
	}
	
	@RequestMapping("/search/{movie}/{num}") //검색 페이지
	public String movieSearch(@PathVariable String movie,@PathVariable(required=false) Integer num, Model model) throws Exception {
		if(num==null) num=1;
		
		model.addAttribute("movie",service.movieListInfo(movie,num));
		model.addAttribute("title",movie);
		model.addAttribute("cur",num);
		return "movie/movieSearch";
	}
}
