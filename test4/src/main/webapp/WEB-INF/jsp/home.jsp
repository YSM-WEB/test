<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 

<!DOCTYPE html>
 <html> 
 <head> 
<link href="/static/css/home.css" rel="stylesheet"/> 	
 </head>
  <body> 
	<div class="mainBox">
		<div class="mainBoxWrap">
			<div class="box">
				<div class="slideBox">
					<div class="front"></div>
					<div class="back"><a href="${cp }/imgSound"><img src="${cp }/static/images/imgSound2.PNG"></a></div>
				</div>
				<div class="infoBox">
					<div class="info">
						<div class="infoWrap">
							<p class="project"><a href="${cp }/imgSound">imgSound</a></p>
							<span>외부 api를 이용하여 계절에 맞는 이미지가 나오게 연출</br>
								이미지의 색상을 추출하여 소리의 파형을 표현
							</span>

						</div>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="slideBox">
					<div class="front"></div>
					<div class="back"><a href="${cp }/board"><img src="${cp }/static/images/freeboard.PNG"></a></div>
				</div>
				<div class="infoBox">
					<div class="info">
						<div class="infoWrap">
							<p class="project"><a href="${cp }/board">게시판</a></p>
							<span>사용자가 직접 글을 쓸 수 있는 게시판</br>
								DB와 스프링을 사용하여 데이터 저장</span>
						
						</div>
						
				
					</div>
				</div>
			</div>
			<div class="box">
				<div class="slideBox">
					<div class="front"></div>
					<div class="back"><a href="${cp }/movie/boxOffice"><img src="${cp }/static/images/moviechart.PNG"></a></div>
				</div>
				<div class="infoBox">
					<div class="info">
					
						<div class="infoWrap">
							<p class="project"><a href="${cp }/movie/boxOffice">movie chart</a></p>
							<span>일간 / 주간의 영화순위를 나타내는 차트</br>
							영화진흥원위원회api를 사용하여 일간과 주간의 박스오피스 데이터 사용</br>
							데이터를 토대로 1위영화를 네이버영화api를 사용하여 이미지 불러옴</br>
							영화를 검색 할 수 있는 기능을 추가</span>
						</div>
						
						
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
  <script src="/static/script/home.js"></script>
 </html>

