<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<!DOCTYPE html>
 <html> 
 <head> 
 
<link href="/static/css/practice/imgSound.css" rel="stylesheet"/> 	
 </head>
  <body> 
 <div class="imgSound">
 	<div class="imgSoundWrap">
 		
			<div class="imgSoundtle">
			
				<div class="sound">
					<audio controls id="sound">
						
					</audio>
				</div>
				
				<div class="canNfont">
					<canvas id="canSeason" width="500" height="350">

 					</canvas>
					<span class="seasonfont">spring</span> 
					<span class="colorchangeBtn">click	</span>
				</div>
				
			</div>
			
			<div class="colorChange">
				<div class="changeLogo">color Change</div>
 				<div class="waveChange Btn">Wave</div>
 				<div class="backChange Btn">Back</div>
 				<div class="changeFont">
 					<div class="waveNum Num">1 / 5</div>
 					<div class="backNum Num">1 / 5</div>
 				</div>
 			</div>
		</div>
		<canvas id="canSeason2" width="1100" height="900">
 		</canvas>
 		
 </div>

  </body> 
  <script type="text/javascript" src="/static/script/practice.js"></script>
  
 </html>
