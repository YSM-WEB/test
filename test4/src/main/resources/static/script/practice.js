let audioctx;
  let analyser;
  let source;
  let freArray;
 //let seasonfont=0;
  	var img=new Image();
  	img.onload=imgload;
  	img.crossOrigin='anonymous';
  	img.src="https://source.unsplash.com/800x400/?spring,blossom";
  	
	const can=document.getElementById('canSeason'); // 계절 사진
	const ctx=can.getContext('2d');
	var test=document.getElementsByClassName('seasonfont');
	
	 var audio=document.getElementById('sound');
	 	 audio.src = "/static/audio/Dayspring_Firef!es.mp3";
		audio.autoplay="true";

	const musicList=["/static/audio/Dayspring_Firef!es.mp3",
						"/static/audio/Benjamin_Tissot_happiness.mp3",
						"/static/audio/autumn keys - l u v t e a (acoustic).mp3",
						"/static/audio/sb_midvinter_snowfall_scottBuckley.mp3"];
	const seasonList=["spring,blossom","summer,sea","autumn,tree","winter,snow"];
	var musicEnd=0;
	audio.addEventListener('ended',function(){ //오디오 끝날때 애니메이션 정지
		musicEnd++;
		if(musicEnd==4) musicEnd=0;
		audio.src=musicList[musicEnd];
		img=new Image();
  		img.onload=imgload;
  		img.crossOrigin='anonymous';
  		img.src="https://source.unsplash.com/800x400/?"+seasonList[musicEnd];
		document.querySelector('.waveNum').textContent="1 / 5";
		document.querySelector('.backNum').textContent="1 / 5";
		test[0].textContent=seasonList[musicEnd].substr(0,6);
		wavecolor=0;

		
	});
	
	var audioAni;	//애니메이션
	audio.addEventListener('pause',function(){ //오디오 멈출때 애니메이션 정지
		cancelAnimationFrame(audioAni);
		
	});

	audio.addEventListener('play',function(){ // 오디오 시작히 애니메이션 시작
	
		if(audioctx==undefined){
		  	 audioctx = new (window.AudioContext || window.webkitAudioContext)();
			 analyser = audioctx.createAnalyser();
			 source= audioctx.createMediaElementSource(audio);
		
			 source.connect(analyser);
			 //source.connect(audioctx.destination);
			 analyser.connect(audioctx.destination);
			 freArray = new Uint8Array(analyser.frequencyBinCount);
		  }
		
		audioAni=requestAnimationFrame(drawCan);
	});
	
	var bars = 350; //바 갯수
	var barWidth = 7; //사각형 선 넓이
	var radius = 315; // 원 길이
	const can2=document.getElementById('canSeason2');//음악 파형
	const ctx2=can2.getContext('2d');
	
	var centerX = can2.width/2,
    centerY = can2.height/2;
    
	function drawCan(){ // 캔버스 만들어주고
		ctx2.clearRect(-550, -800, can2.width, can2.height+100); //settransform 으로 인해 자리 땡겨줘야하는듯?
		//ctx2.clearRect(0, 0, can2.width, can.height);
		analyser.getByteFrequencyData(freArray);
		
		var bars=-1;
		for(var i = 0; i < Math.PI*2; i+= (Math.PI/180 * 2)){ // Math.pi * 2 / bars 이건 막대 갯수로
			bars++;
			  drawLine(i, freArray[bars]*0.7); // 원 좌표 i , 길이
			  
		}
		
		audioAni=requestAnimationFrame(drawCan);
		
	}
	function drawLine(rad, barHeight){ // 캔버스에 선 그리기
		  ctx2.setTransform(1,0,0,1, can2.width / 2, can2.height / 2); 
		  
		  ctx2.rotate(rad); // 원 좌표 기울기 
		  
		  ctx2.translate(0, radius); // 원 길이로하여 중앙으로부터 떨어지게
		 // ctx2.beginPath();
		  ctx2.fillRect(
		    0, 
		    0, 
		    barWidth,
		    barHeight 
		  );
	}
	window.addEventListener('DOMContentLoaded',function(){
		if(window.innerWidth<1100){

			can2.width=window.innerWidth;
		}
		
	})
	window.addEventListener('resize',function(){
		if(window.innerWidth<1100){
			can2.width=window.innerWidth;
		}
		
	})
  
  var colorSort;
  var backsortColor;
  function imgload(){
	
	  var colors=[];
	  ctx.drawImage(img,0,0);
	
	  var imgdata=ctx.getImageData(0,0,can.width,can.height).data; //이미지 rgb 데이터 추출

	  var i=-4;
	  while((i += 4 )< imgdata.length){ //이미지 rgb > 16진수로
		  
		  var rgbd=[imgdata[i],imgdata[i+1],imgdata[i+2],imgdata[i+3]];
		  var hex=rgbd.map(function(rgb){
			
			 var _hex = rgb.toString(16);
			  return _hex.length==1 ? "0"+_hex : _hex;  
			  
		  });
		  
		  hex=hex.join('');
		  colors.push(hex);
		
	  }

	   colorSort={};
	   backsortColor={};
	  var fcolor=null;

	  colors.sort().forEach(function(color){ //이미지 16진수 정렬하고 색깔별로 카운트
		  
		  if(fcolor!=color){
			  colorSort[color]=0;
			  fcolor=color;
		  }
		  return colorSort[color]+=1;
	  });

	  colors=colorSort;
	  colorSort=[];
	  for(var color in colors){ // 색의 카운트 배열로 저장
		  colorSort.push([color,colors[color]]);
	  }
		  
	  colorSort.sort(function(a,b){return a[1]-b[1];}); // 정렬 해 주고 오름차순으로 다시 정렬 
	  backsortColor=colorSort.slice(0, 5);
	  
	  colorSort.reverse();
	
	  colorSort=colorSort.slice(0, 5); // 상위 몇가지 색 뽑기
	  
	 	document.querySelector('.imgSound').style.backgroundColor="#"+backsortColor[0][0];
		test[0].style.color="#"+backsortColor[0][0];
		ctx2.fillStyle = "#"+colorSort[0][0]; 
  
 }

var seasonfont=0;
  document.querySelector('.colorchangeBtn').addEventListener('click',function(){
	  if(seasonfont==0){
		  seasonfont=1;
		  document.querySelector('.colorChange').style.display="inline-block";
		  document.querySelector('.seasonfont').style.display="inline-block";
console.log(seasonfont);
	  }else{
		  seasonfont=0;
		  document.querySelector('.colorChange').style.display="none";// 버튼들
		  document.querySelector('.seasonfont').style.display="none";// 캔버스글씨
console.log(seasonfont);
	  }
  });

var wavecolor=0;
  document.querySelector('.waveChange').addEventListener('click',function(){ // 음악 파동과 배경 색 바꾸는 버튼 이벤트
	  wavecolor++;
	  if(wavecolor==5){
		
		  wavecolor=0;
		  ctx2.fillStyle = "#"+colorSort[0][0]; 
			document.querySelector('.waveNum').textContent=(wavecolor+1)+" / 5";
	  }else{
		
		  ctx2.fillStyle = "#"+colorSort[wavecolor][0]; 
		 document.querySelector('.waveNum').textContent=(wavecolor+1)+" / 5";
	  }
  });	
	var backcolor=0;
  document.querySelector('.backChange').addEventListener('click',function(){
	  backcolor++;
	  if(backcolor==5){
		
		  backcolor=0;
		  document.querySelector('.imgSound').style.backgroundColor="#"+backsortColor[0][0];
			document.querySelector('.backNum').textContent=(backcolor+1)+" / 5";
		
	  }else{

		  document.querySelector('.imgSound').style.backgroundColor="#"+backsortColor[backcolor][0];
		document.querySelector('.backNum').textContent=(backcolor+1)+" / 5";
	  }
  });	  
  