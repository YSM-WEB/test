<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<!DOCTYPE html>
 <html> 
 <head> 
<link href="/static/css/layout/moviehead.css" rel="stylesheet"/> 	
 </head>
  <body> 
	<div class="movieHead">
		<div class="movieHeadWrap">
			<div class="movieFont">
				<a href="${cp }/movie/boxOffice"><span class="movieLogo">movie chart</span></a>
			</div>
		</div>
	</div>
	
	<div class="movieSearch">
		<div class="movieSearchWrap">
			<div class="search">
				<form id="form">
					<input type="text" list="movie" name="movie" id="movieSearch" autocomplete="off">
					<datalist id="movie">
					</datalist>
				</form>
			</div>
		</div>
	</div>
  </body> 
  <script type="text/javascript" src="/static/script/layout/moviehead.js"></script>
 </html>
