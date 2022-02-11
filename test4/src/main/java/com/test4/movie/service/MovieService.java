package com.test4.movie.service;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.ws.client.support.destination.AbstractCachingDestinationProvider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.test4.Movie;



@Service
public class MovieService {
	
	
	//private RestTemplate restTemplate;
	private String CLIENT_ID="MxEsyV50rgWePBk53zW9"; 
	private String CLIENT_SECRET = "aRu9yb2Q7b";
	private final RestTemplate rest = new RestTemplate(); 
	private String[] genre= {"드라마","판타지","서부","공포","로맨스","모험","스릴러","느와르"
			,"컬트","다큐멘터리","코미디","가족","미스터리","전쟁","애니메이션","범죄","뮤지컬","SF"
			,"액션","무협","에로","서스펜스","서사","블랙코미디","실험","영화카툰","영화음악","영화패러디포스터"};
	private String[] nation= {"한국","일본","미국","홍콩","영국","프랑스","기타"};
	private String[] nationX= {"KR","JP","US","HK","GB","FR","ETC"};
	
	public String find(String keyword,String prdtYear,String genreNm,String nationNm) throws Exception{
		
		return naverAPI(keyword,genreNm,nationNm,prdtYear); //네이버 api 호출
	}
	
	
	public java.util.List<Map<String,Object>> movieListInfo(String movie,int num) throws Exception {

		String url="http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json"
				+ "?key=5d29f347c88ea85f6e1d732d5aa44a14"
				+ "&curPage="+num
				+ "&movieNm="+movie
				+ "&itemPerPage=6";

		ResponseEntity<String> response =
				rest.getForEntity(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response.getBody());

		int i=0;
		String[] movieCd = new String[6];
		Iterator<JsonNode> itr = node.get("movieListResult").get("movieList").elements();
		//System.out.println(node.get("movieListResult").get("totCnt"));
		while(itr.hasNext()) { //목록에 있는 영화들 상세정보 불러오기
			JsonNode obj = (JsonNode)itr.next();
			movieCd[i] = obj.get("movieCd").asText();
			i++;		
		}
		JSONArray array = new JSONArray();
		array.add(node.get("movieListResult"));
		JSONObject obj = new  JSONObject();
		obj.put("Cnt", array);
		Map<String,Object> map = new ObjectMapper().readValue(JSONObject.toJSONString(obj)
				,Map.class);
		java.util.List<Map<String,Object>> list = movieDetailInfo(movieCd,i);
		list.add(map);
		
		return list; //영화 상세정보와 이미지 반환
	}
	public java.util.List<Map<String,Object>> movieDetailInfo(String[] movieCd,int i) throws Exception{

		String url="http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json"
				+ "?key=5d29f347c88ea85f6e1d732d5aa44a14"
				+ "&movieCd=";
		ResponseEntity<String> response;
				rest.getForEntity(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null ;
		JSONObject obj = new JSONObject() ;	
		JSONObject obj2 = new JSONObject() ;	

		JsonNode img = null ;
		JSONArray imgarray = new JSONArray();
		JSONArray array2 = new JSONArray();
		String movieList="";

		for(int j=0; j<i; j++) { //영화 상세정보와 이미지 저장
			response = rest.getForEntity(url+movieCd[j], String.class);
			node = mapper.readTree(response.getBody());
			//System.out.println(node.get("movieInfoResult").get("movieInfo"));
			img = getMovieImgGrade(
					node.get("movieInfoResult").get("movieInfo").get("movieNm").asText(),
					node.get("movieInfoResult").get("movieInfo").get("genres").get(0).get("genreNm").asText(),
					node.get("movieInfoResult").get("movieInfo").get("nations").get(0).get("nationNm").asText(),
					node.get("movieInfoResult").get("movieInfo").get("prdtYear").asText());
			
			
			imgarray.add(img); // 
			array2.add(node.get("movieInfoResult").get("movieInfo"));
		}
		obj2.put("imgGrade",imgarray ); //json으로 저장한 데이터를 list map 으로 변환하여 저장하여 반환해줌 
		obj.put("movieList",array2);

		Map<String,Object> test = new ObjectMapper().readValue(JSONObject.toJSONString(obj2)
				,Map.class);

		java.util.List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(test);
		
		Map<String,Object> map = new ObjectMapper().readValue(JSONObject.toJSONString(obj)
				,Map.class);
		list.add(map);


		return list;
	}
	
	
	public JsonNode getMovieImgGrade(String keyword,String genreNm, String nationNm, String prdtYear) throws JsonMappingException, JsonProcessingException, ParseException {
	 
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(naverAPI(keyword,genreNm,nationNm,prdtYear));
		return node;
	}
	
	
	
	
	public String naverAPI(String keyword,String genreNm, String nationNm, String prdtYear) { //네이버 api 호출
		for(int i=0; i<genre.length; i++) {
			if(genre[i]==genreNm) {
				genreNm=String.valueOf(i+1);
				break;
			}
		}
		for(int i=0; i<nation.length; i++) {
			if(nation[i].equals(nationNm)) {
				nationNm=nationX[i];
				break;
			}
			if(i==(nation.length-1)) {
				nationNm=nationX[i];
				break;
			}
		}

		String url="https://openapi.naver.com/v1/search/movie.json?query={keyword}"
				+ "&genre="+genreNm+"&country="+nationNm
				+ "&yearform="+prdtYear+"&yearto="+prdtYear;
		HttpHeaders headers = new HttpHeaders(); 
		headers.add("X-Naver-Client-Id", CLIENT_ID); 
		headers.add("X-Naver-Client-Secret", CLIENT_SECRET); 
		HttpEntity<String> requestEntity = new HttpEntity<>(headers); 
		
		
		return rest.exchange("https://openapi.naver.com/v1/search/movie.json?query=" + keyword, HttpMethod.GET, requestEntity, String.class,keyword).getBody(); 
	}
}
