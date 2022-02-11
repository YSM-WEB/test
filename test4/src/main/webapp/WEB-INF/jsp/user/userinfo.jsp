<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
 <html> 
 <head> 
<style>
	.userinfo{
		max-width:1360px;
		margin: 0 auto;
	}
	.userinfoWrap{
		width:100%;
		margin-top: 50px;
	}
	.userinfoInner{
		width:100%;
		display: flex;
		
	}
	.userinfoMenu{
		width:200px;
		background-color: #FFD662;
		border-radius: 7px;
		flex-shrink: 0;
	}
	
	.infoMenu{
		color:#00539C;
		font-size:25px;
		font-family:OTWelcomeBA;
		text-align: center;
		padding-top: 20px;	


	}
	.userinfoContents{
		width:100%;

		height: 700px;
		background-color: pink;
		margin-left: 10px;
		border-radius:7px; 
	}

	
</style>
 </head>
 <body> 
	<div class="userinfo">
		<div class="userinfoWrap">
			<div class="userinfoInner">
				<div class="userinfoMenu">
					<div class="infoMenu myinfo">내 정보</div>
					<div class="infoMenu myWrite">내가 쓴 글</div>
					<div class="infoMenu myReply">내가 쓴 댓글</div>
					<div class="infoMenu accountDelete">탈퇴/</div>
				</div>
				<div class="userinfoContents">
					<div class="infoWrap">
					<sec:authorize access="isAuthenticated()">
						<div class="infoId"><sec:authentication property="principal.username"/></div>
						<div class="infoName"><sec:authentication property="principal.memname"/></div>
						<div class="infobirth"><sec:authentication property="principal.membirth"/></div>
					
						</sec:authorize>
					</div>
				</div>
			</div>
		</div>
	</div>	
	
 </body> 
 </html>
