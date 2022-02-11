var list=document.getElementsByClassName('tooltip');
form.onsubmit=function(e){
	e.preventDefault();
	var cor=document.getElementsByClassName('correct');
	var cor1=document.getElementsByClassName('correct1');
	if(!(cor.length==4&&cor1.length==2)){
		alert("모든정보를 입력해주세요");
		//return false;
	}else{
		alert('가입완료(회원정보는 저장되지 않습니다. 로그인 기본아이디를 이용해주세요.)');
		//return true;
	}
}
form.memId.addEventListener('blur',function(){
	if(form.memId.value==""){
		form.memId.className="";
		list[0].textContent="공백입니다. 아이디를 입력해주세요.";
	}else if(!/^[A-Za-z0-9]{6,15}$/.test(form.memId.value)){
		form.memId.className="";
			list[0].textContent="영문과 숫자를 사용한 6~15자리 아이디를 입력해주세요";
	}else{
		var data="id="+form.memId.value+"&";
		var xhr=new XMLHttpRequest();
		
		xhr.open('POST','/memberid');	
		xhr.setRequestHeader('content-Type',"application/x-www-form-urlencoded");
		
		xhr.send(data);
		
		xhr.addEventListener('load',function(){
			var result=xhr.responseText;
			if(result==1){
				
				form.memId.className="";
				list[0].textContent="중복된아이디입니다.";
			}else{
				list[0].textContent="";
				form.memId.className="correct";
			}
		});
	}
	
});
form.memPwd.addEventListener('blur',function(){
	if(form.memPwd.value==""){
		form.memPwd.className="";
		list[1].textContent="영문,숫자,특수문자를 사용한 8~16자리를 입력해주세요";
	}else if(!/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/.test(form.memPwd.value)){
			form.memPwd.className="";
			list[1].textContent="영문,숫자,특수문자를 사용한 8~16자리를 입력해주세요";
	}else{
		list[1].textContent="";
		form.memPwd.className="correct";
	}
});
form.memPwdOk.addEventListener('blur',function(){
	if(form.memPwdOk.value==""){
		form.memPwdOk.className="";
		list[2].textContent="비밀번호가 일치하지 않습니다.";
		
	}
	else if(form.memPwdOk.value==form.memPwd.value){
		list[2].textContent="";
		form.memPwdOk.className="correct";
	}else{
		form.memPwdOk.className="";
		list[2].textContent="비밀번호가 일치하지 않습니다.";
	}
});
form.memName.addEventListener('blur',function(){
	if(form.memName.value==""){
		form.memName.className="";
		list[3].textContent="이름을 입력해주세요";
	}else if(!/^[가-힣]{3,17}$/.test(form.memName.value)){
		form.memName.className="";
		list[3].textContent="이름을 입력해주세요";
	}else{
		list[3].textContent="";
		form.memName.className="correct";
	}
	
});
form.memBirthYear.addEventListener('blur',function(){
	var now=new Date();
	var year=now.getFullYear();
	
	if(form.memBirthYear.value==""){
		form.memBirthYear.className="";
		list[4].textContent="년도4자리를 입력해주세요.";
	}else if(!(form.memBirthYear.value==year||form.memBirthYear.value>=year-100)){
		form.memBirthYear.className="";
		list[4].textContent="년도4자리가 맞지않아요";
	}else{
		list[4].textContent="";
		form.memBirthYear.className="correct1";
	}
	
});
form.memBirthDay.addEventListener('blur',function(){
	if(form.memBirthDay.value==""){
		form.memBirthDay.className="";
		list[4].textContent="날짜를 입력해주세요.";
	}else if(!(form.memBirthDay.value<=31||form.memBirthYear.value>=1)){
		form.memBirthDay.className="";
		list[4].textContent="날짜가 맞지않아요";
	}else{
		list[4].textContent="";
		form.memBirthDay.className="correct1";
	}
	
});