<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
 <html> 
 <head> 
<link href="/static/css/board/write.css" rel="stylesheet"/> 	
 </head>
  <body> 

  <form action="${cp }/board/writeComplete" method="post">
  	<div class="boardWrite">
		<div class="boardWriteWrap">
			<div class="WriteWrap">
				<input type="hidden" value=<sec:authentication property="principal.username"/> name="boardNick"></input>
				<div class="WriteTitle">
					<input type="text" placeholder="제목을 적어주세요" name="boardName"></input>
				</div>
				<div class="WriteMemo">
					<textarea placeholder="글을 적어주세요" name="boardWrite"></textarea>
				</div>
				<div class="wirteBtn">
					<input type="submit" class="Btn" value="글쓰기"></input>
				</div>
			</div>
		</div>
	</div>
  </form>
	
  </body> 
 </html>
