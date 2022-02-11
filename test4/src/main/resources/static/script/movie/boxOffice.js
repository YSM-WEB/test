var key = "?key=5d29f347c88ea85f6e1d732d5aa44a14" // key 앞에 <?key=>를 붙여야함 : prameter
var today=new Date();
//today.setDate(today.getDate()-19);
var year=today.getFullYear();
var month=today.getMonth();
var day=today.getDate();

day=('00'+day).slice(-2);
month=('00'+month).slice(-2);
var day2=String(year)+String(month)+String(day);

var itemPerPage = "&itemPerPage=20" //20개를 가져올것이라서
const url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
            + key
			+"&targetDt="+day2;
const url3 = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json"
            + key
			+"&targetDt="+day2;
			
var item_int = 20;

window.addEventListener('DOMContentLoaded', function() {
	var movieWrap=document.querySelectorAll('.movieWrap');
fetch(url)
            .then(response=>response.json())
            .then(function(msg){ 
                //console.log(msg);
				
						findboxOffice(msg.boxOfficeResult.dailyBoxOfficeList,1);	
						
						
            });
fetch(url3)
            .then(response=>response.json())
            .then(function(msg){ 
               // console.log(msg);
				findboxOffice(msg.boxOfficeResult.weeklyBoxOfficeList,0);	
            });


async function findboxOffice(boxOffice,what){
	var table=document.createElement('table');
				//movieWrap.appendChild(table);
				for(var i=0; i<boxOffice.length;i++){
					var movie=document.createElement('td');
					movie.className="movieRank";
					var img = document.createElement('img');
					var tr=document.createElement('tr');
					//var num=document.createElement('td');
					var name=document.createElement('td');
					var increase=document.createElement('td');
					
					
					if(i==0){	
						img.src=await findmovieInfo(boxOffice[i].movieCd,what);
						movie.appendChild(img);	
						//num.innerHTM="";
					}else{
						movie.textContent=i+1;
					}

					
					name.textContent=boxOffice[i].movieNm;
					
					if(boxOffice[i].rankOldAndNew=="NEW"){
						increase.className="tdNew";
						increase.textContent="NEW";
					}else{
						if(boxOffice[i].rankInten==0){
							increase.textContent="";
						}
						else if(boxOffice[i].rankInten>0){
							increase.className="tdRankP";
							increase.textContent="↑"+boxOffice[i].rankInten;
						}else{
							increase.className="tdRankM";
							increase.textContent="↓"+Math.abs(boxOffice[i].rankInten);	
						}
						
					}
					
					tr.append(movie,name,increase);
					table.appendChild(tr);
					movieWrap[what].appendChild(table);
					
				}
}
function findmovieInfo(movieNum,what){
	var url="http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo"
			+key
			+"&movieCd="+movieNum;	
	const res=fetch(url);
	return res.then(res=>res.json()).then(function(msg){
		//console.log(msg);
		var movieNm = msg.movieInfoResult.movieInfo.movieNm;
		var prdtYear = msg.movieInfoResult.movieInfo.prdtYear;
		var genreNm = msg.movieInfoResult.movieInfo.genres[0].genreNm;
		var nationNm =	msg.movieInfoResult.movieInfo.nations[0].nationNm;
		var url = "/movie/find?"
				+"keyword="+movieNm
				+"&prdtYear="+prdtYear
				+"&genreNm="+genreNm
				+"&nationNm="+nationNm
		console.log(msg);
		return fetch(url)
	})
	.then(res=>res.json())
	.then(res=>{
		console.log(res);
		return res.items[0].image;

	});
}
})

