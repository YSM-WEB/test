<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
 <html> 
 <head> 
<link href="/static/css/board/view.css" rel="stylesheet"/> 	
 </head>
 <body> 
	<div class="boardview">
		<div class="viewWrap">
			<div class="viewname"><span>${view.boardName }</span>
				<span class="viewicon"><img src="${cp }/static/images/eye.png">${view.boardLook }</span>
				<span class="viewicon"><img src="${cp }/static/images/clock.png">
					<fmt:parseDate value="${view.boardTime}" var="dateValue" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd"/>
				</span>
			</div>
			<span class="Nick">${view.boardNick }</span> 님
			<div class="viewcontents">
				<div class="viewcontentsWrap" ><pre>${view.boardWrite}</pre></div>
			</div>
			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal.username" var="username"/>
				<c:if test="${view.boardNick eq username }">
					<input type="button" value="글삭제" onclick="boardRemove();" class="remove">
				</c:if>
			</sec:authorize>
		</div>
		<div class="userReply">
			<c:if test="${reply ne null}">
				<c:forEach var="list" items="${reply }">
					<div class="replyTle">
						<div class="userInfo">${list.memid } &#40;${list.replyTime }&#41;</div>
						<div class="replyText">${list.replyText }</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
		<form id="form">
			<div class="reply">

				<div class="replyWrap">
					<textarea placeholder="댓글을 적어주세요" name="reply"></textarea>
				</div>
				<div class="replyBtn">
					<input type="submit" value="댓글등록">
				</div>

			</div>
		</form>
		
	</div>
 </body> 
 
 <script type="text/javascript">
 function boardRemove(){ 
	 location.href="${cp}/board/remove/${view.boardNum}";
 }
 var user=null;
 var userReply=document.querySelector('.userReply');
 <sec:authorize access="isAuthenticated()">
	user='<sec:authentication property="principal.username"/>';
 </sec:authorize>
 form.addEventListener('submit',function(e){
 	e.preventDefault();
 	if(user==null){
 		location.href="/login";
 	}else if(form.reply.value.replace(/^\s+|\s+$/g,'')==''){
 		alert('공백입니다 내용입력 필수');
 	}else{
 		var url="/board/replyWrite";
 	 	fetch(url,{
 	 		method:"POST",
 	 		headers:{
 	 			"Content-Type" : "application/json",
 	 		},
 	 		body : JSON.stringify({
 	 			id:user,
 	 			text:form.reply.value,
 	 			num:${view.boardNum},
 	 		}),
 	 	})
 	 		.then(function(){
 	 			
 	 			var replyTle =document.createElement('div');
 	 			var userInfo =document.createElement('div');
 	 			var replyText=document.createElement('div');
 	 			replyTle.className='replyTle';
 	 			userInfo.className='userInfo';
 	 			replyText.className='replyText';
 	 			userInfo.textContent=user+' (new)';
 	 			replyText.textContent=form.reply.value;
 	 			form.reply.value='';
 	 			
 	 			replyTle.append(userInfo,replyText);
 	 			userReply.appendChild(replyTle);
 	 		})	
 	}
 	
 	
 })
 </script>
 </html>
