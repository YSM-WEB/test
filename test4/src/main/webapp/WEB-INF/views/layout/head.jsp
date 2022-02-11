<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
 <html> 
 <head> 
<link href="/static/css/layout/head.css" rel="stylesheet"/> 	

 </head>
 <body> 
	<div class="mainHead">
		<div class="mainHeadWrap">
			<div class="mainLogin">
				<sec:authorize access="isAnonymous()">
    				<a href="${cp }/login">로그인</a>
					<a href="${cp }/member">회원가입</a>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<span id="username"><sec:authentication property="principal.username"/> 님
						<div id="userinfo">
				    		<span><a href="${cp}/userinfo">마이페이지</a></span><br>
				    		<span>내정보</span><br>
				    		<span>내정보</span>
				    	</div> 
					</span> 
				    <a href="/logout">로그아웃</a>
				</sec:authorize>
			</div>
		</div>
	</div>
	<div class="mainHeadMenu">
		<div class="mainHeadMenuWrap">
			<div class="mainHeadMenuLogo"><a href="${cp }/"><span>SUNGMIN</span></a></div>
			<div class="MenuWrap">
				<ul class="MenuMain">
					<li class="li">메뉴
						<ul class="MenuInMenu">
							<li><a href="${cp }/imgSound">imgSound</a></li>
							<li><a href="${cp }/movie/boxOffice">영화</a></li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
						</ul>
					</li>
					<li class="li">메뉴
						<ul class="MenuInMenu">
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
						</ul>
					</li>
					<li class="li">메뉴얼
						<ul class="MenuInMenu">
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
						</ul>
					</li>
					<li class="li">메뉴
						<ul class="MenuInMenu">
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
						</ul>
					</li>
					<li class="li">메뉴얼
						<ul class="MenuInMenu">
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
						</ul>
					</li>
					<li class="li">게시판
						<ul class="MenuInMenu">
							<li><a href="${cp }/board">자유게시판</a></li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
							<li>메뉴</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<div class="mainHaedMenuBack"></div>
	</div>



 </body> 
 <script type="text/javascript" src="/static/script/layout/head.js"></script>
 </html>
