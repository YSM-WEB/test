<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
 <html> 
 <head> 
<link href="/static/css/movie/movieSearch.css" rel="stylesheet"/> 	
 </head>
  <body> 
	<div class="movie">
		<div class="movieWrap">
			<div class="movieTle">
		
				<c:forEach var="i" begin="0" end="${fn:length(movie[1].movieList)-1 }">
					<div class="movieInfo">
						<div class="movieTitle">${movie[1].movieList[i].movieNm }&#40;${movie[1].movieList[i].openDt}&#41;</div>
						<div class="movieInfoWrap">
							<div class="moiveImg">
								<img
									src="${movie[0].imgGrade[i].items[0].image }"
									onerror="this.src='${cp }/static/images/eye.png'"
									loading="lazy">
							</div>
							<div class="info">
								<div class="director">감독 ${movie[1].movieList[i].directors[0].peopleNm }</div>
								<div class="actor">
								배우 ${movie[1].movieList[i].actors[0].peopleNm }
								 ${movie[1].movieList[i].actors[1].peopleNm }
								 ${movie[1].movieList[i].actors[2].peopleNm }
								</div>

								<div class="etc">
									<div class="point">평점 ${movie[0].imgGrade[i].items[0].userRating }</div>
									<div class="genre">장르 ${movie[1].movieList[i].genres[0].genreNm }</div>
									<div class="playTime">시간 ${movie[1].movieList[i].showTm }</div>
								</div>

							</div>
						</div>


					</div>
					
				</c:forEach>
			</div>
			<div class="page">
				<c:set var="cnt" value="${ movie[2].Cnt[0].totCnt/6}" />
				<c:forEach var="i" begin="1" end="${cnt+(1-(cnt%1))%1 }">
					<c:choose>
						<c:when test="${i==cur}">
							<span>${i }</span>&nbsp;
						</c:when>
						<c:otherwise>
							<a href="/movie/search/${title }/${i}">${i}</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			
			
		</div>
	</div>
  </body> 
 </html>
