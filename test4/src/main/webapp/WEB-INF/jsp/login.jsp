<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<!DOCTYPE html>
 <html> 
 <head> 
 <meta name="viewport" content="width=device-width,initial-scale=1">
<link href="/static/css/login.css" rel="stylesheet"/> 	
</head>
<body>
<form action="/loginOk" method="post" id="loginform" name="form">
	<div class="login">
		
		<div class="logo"><a href="${cp }/">SUNGMIN</a></div>
		<div class="loginWrap">
			
			<div class="logintip">아이디</div>
			<div class="inputWrap">
				<input type="text" name="loginid" placeholder="기본 아이디는 'user' 입니다">
			</div>
		
			
			<div class="logintip">비밀번호</div>
			<div class="inputWrap">
				<input type="password" name="loginpwd" placeholder="비밀번호는 '1234' 입니다">
			</div>
			
			
			<input type="submit" value="로그인" id="subBtn">
			<div class="tooltip">${errormsg }</div>
			
		</div>
		
	</div> 
</form>
</body> 
</html>
