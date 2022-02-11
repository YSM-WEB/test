var key = "?key=5d29f347c88ea85f6e1d732d5aa44a14" // key 앞에 <?key=>를 붙여야함 : prameter
var findurl="http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json"
			+key
			+"&itemPerPage=3"
			+"&movieNm=";
var	movieList=document.getElementById('movie');
var timer='';
var fontDel=0;
var fontDel2=0;
document.getElementById('movieSearch').addEventListener('keyup',function(e){

	clearTimeout(timer);
	timer=setTimeout(function(){
		fetch(findurl + e.target.value)
		.then(res => res.json())
		.then(function(res) {
			if (movieList.hasChildNodes()) {
				while (movieList.hasChildNodes()) {
					movieList.removeChild(movieList.firstChild);
				}
			}
			datalistAdd(res);
			if(fontDel==0){
				
				fontDel2=1;
				fontDel=1;
			}
		})
		.catch()
	},300);
	
})
function datalistAdd(res){
	for (var i = 0; i < res.movieListResult.movieList.length; i++) {
				var option = document.createElement('option');
				option.value = res.movieListResult.movieList[i].movieNm;
				movieList.append(option);
			}
}
document.getElementById('movieSearch').addEventListener('keydown',function(e){
		if(fontDel2==1){
		var movie=document.getElementById('movieSearch');
				if(movie.value.replace(/^\s+|\s+$/g,'')!=''){
				movie.value=movie.value.substr(0,movie.value.length-1);	
				fontDel2=0;	
				}
		}	
})



form.addEventListener('submit',e=>{
	e.preventDefault();
	var movie=document.getElementById('movieSearch');	
	if(fontDel2==1){
		movie.value=movie.value.substr(0,movie.value.length-1);	
		fontDel2=0;	
	}
	if(movie.value.replace(/^\s+|\s+$/g,'')!=''){
		console.log(movie.value);
		location.href="/movie/search/"+movie.value+"/1";
	}
	
})