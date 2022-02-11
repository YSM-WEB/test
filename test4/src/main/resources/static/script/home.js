var slide=document.getElementsByClassName('box');
  var slideBox=document.getElementsByClassName('slideBox');
  var infoWrap=document.getElementsByClassName('infoWrap');

  document.addEventListener('scroll',function(){
	 var winY=window.pageYOffset; //스크롤 위치
	 
	 var divY=+((winY+slide[0].getBoundingClientRect().bottom)-window.innerHeight); // 스크롤위치값 + 요소 bottom 위치값 - 브라우저화면 길이 = 요소의 bottom 절대위치
	 var divY2=(winY+slide[1].getBoundingClientRect().bottom)-window.innerHeight;
	 var divY3=(winY+slide[2].getBoundingClientRect().bottom)-window.innerHeight;
	 
	 if(winY>=divY){ // 스크롤이 > 요소bottom절대값 위치 보다 커질경우
		 slideBox[0].style.animation='swing-left-fwd 0.4s cubic-bezier(0.250, 0.460, 0.450, 0.940) both';
	 	infoWrap[0].style.animation='tracking-in-expand 0.9s cubic-bezier(0.215, 0.610, 0.355, 1.000) both';
	 }
	 if(winY>=divY2){

		 slideBox[1].style.animation='swing-left-fwd 0.4s cubic-bezier(0.250, 0.460, 0.450, 0.940) both';
		 infoWrap[1].style.animation='tracking-in-expand 0.9s cubic-bezier(0.215, 0.610, 0.355, 1.000) both';
	 }
	 if(winY>=divY3){

		 slideBox[2].style.animation='swing-left-fwd 0.4s cubic-bezier(0.250, 0.460, 0.450, 0.940) both';
		 infoWrap[2].style.animation='tracking-in-expand 0.9s cubic-bezier(0.215, 0.610, 0.355, 1.000) both';
	 }
	 
  });