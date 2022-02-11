<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
 <html> 
 <head> 
<link href="/static/css/board/board.css" rel="stylesheet"/> 	
 </head>
  <body> 
	<div class="board">
		<div class="boardWrap">
			<div class="boardNpage">
				<div class="page">
					<table>
						<c:forEach var="result" items="${board}">
		 					<tr>
							<td class="boardName"><a href="${cp}/view/${result.boardNum}">${result.boardName }</a></td>
							<td class="boardNick"><img src="${cp }/static/images/user.png"><span>${result.boardNick}</span></td>
							<td class="boardTime"><img src="${cp }/static/images/clock.png"><span><fmt:parseDate value="${result.boardTime}" var="dateValue" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd"/></span></td>
							<td class="boardLook"><img src="${cp }/static/images/eye.png"><span>${result.boardLook }</span></td>
							<td class="boardReply"><img src="${cp }/static/images/memo.png"><span>${result.boardReply }</span></td>
							</tr>
						</c:forEach>
						
					</table>
				</div>
				<div class="WriteBtn"><a href="${cp}/board/write">글쓰기</a></div>
				<div class="paging">
					<c:if test="${page.start ne 1 }">
						<span><a href="${cp}/board/1"><<</a></span>
						<span><a href="${cp}/board/${page.start-1}"><</a></span>
					</c:if>
					<c:forEach var="pages" begin="${page.start}" end="${page.end}">
		 					
		 				<c:choose>
						<c:when test="${pages == page.current }">
							<span>${pages}</span>
						</c:when>
						<c:otherwise>
							<a href="/board/${pages}">${pages}</a>
						</c:otherwise>
						</c:choose>
					</c:forEach>			
					<c:if test="${page.allpage>page.start+9}">
						<span><a href="${cp}/board/${page.end+1}">></a></span>
						<span><a href="${cp}/board/${page.allpage}">>></a></span>
					</c:if>
					
				</div>
			</div>
		</div>
	</div>

  </body>
 </html>

