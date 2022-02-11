var menu=document.getElementsByClassName("MenuInMenu");
	
	for(var i=0; i<menu.length; i++){
		 
	}
	document.querySelector(".mainHaedMenuBack").addEventListener("animationend",what);
	
	function what(){ //애니 끝나고 none으로 변경
 		if(document.querySelector(".mainHaedMenuBack").style.animationName=="ani2"){
 			document.querySelector(".mainHaedMenuBack").style.display="none";
 		}
 		for(var i=0; i<menu.length; i++){
 			if(menu[i].style.animationName=="anima2"){
 				menu[i].style.display="none";	
 			}
 			
 		}
 	}
	
 	document.querySelector(".MenuWrap").addEventListener("mouseover",function(){ //메뉴 배경
 		document.querySelector(".mainHaedMenuBack").style.animationName="ani1";
 		document.querySelector(".mainHaedMenuBack").style.display="block";
 		
 	});
 	document.querySelector(".MenuWrap").addEventListener("mouseout",function(){
 		document.querySelector(".mainHaedMenuBack").style.animationName="ani2";
 		document.querySelector(".mainHaedMenuBack").style.animationFillMode="forwards";
 		
 	});
 	
 	document.querySelector(".MenuWrap").addEventListener("mouseover",function(){ //메뉴
 		document.querySelector(".MenuWrap").style.animationName="animation1";
 		document.querySelector(".MenuWrap").style.animationFillMode="forwards";
 		for(var i=0; i<menu.length; i++){
 			menu[i].style.animationName="anima1";
 			menu[i].style.display="block";
 		}	
 	});
 	document.querySelector(".MenuWrap").addEventListener("mouseout",function(){
 		document.querySelector(".MenuWrap").style.animationName="animation2";
 		document.querySelector(".MenuWrap").style.animationFillMode="forwards";
 		for(var i=0; i<menu.length; i++){
 			menu[i].style.animationName="anima2";
 			menu[i].animationFillMode="forwards";
 		}	
 		
 		
 	});