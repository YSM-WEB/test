<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<!DOCTYPE html>
 <html> 
 <head> 
 <meta name="viewport" content="width=device-width,initial-scale=1">
<link href="/static/css/member.css" rel="stylesheet"/> 	
</head>
<body>

<form action="/memberOk" method="post" id="memberform" name="form">
	<div class="membership">
		<div class="signup">
			<div class="logo">
				<a href="${cp }/">SUNGMIN</a>
			</div>
			<div class="membershipWrap">

				<div class="membertip">아이디</div>
				<div class="memberid meminfo">
					<input type="text" name="memId">
				</div>
				<div class="tooltip"></div>

				<div class="membertip">비밀번호</div>
				<div class="memberpwd meminfo">
					<input type="password" name="memPwd">
				</div>
				<div class="tooltip"></div>

				<div class="membertip">비밀번호 확인</div>
				<div class="memberpwdok meminfo">
					<input type="password" name="memPwdOk">
				</div>
				<div class="tooltip"></div>

				<div class="membertip">이름</div>
				<div class="membername meminfo">
					<input type="text" name="memName">
				</div>
				<div class="tooltip"></div>

				<div class="membertip">생년월일</div>
				<div class="memberbirth meminfo">
					<input type="text" name="memBirthYear"> <select
						name="memBirthMonth">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select> <input type="text" name="memBirthDay">
				</div>
				<div class="tooltip"></div>

				<div class="memberjoin meminfo">
					<input type="submit" value="회원가입" id="subBtn">
				</div>

			</div>
		</div>
			
		</div>
</form>

</body>
<script src="/static/script/member.js"></script> 
</html>
