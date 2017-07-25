/**
 * 
 *//**
 * 
 */
function idCheck(url,name){
	
		window.open(url,name,"width=500, height=230");
	

}

function checkfield(){
	
	if(document.regiform.id.value==""){ //id값이 없을 경우
		alert("아이디를 입력하세요");         //메세지 경고창을 띄운 후
		document.regiform.id.focus();     // id 텍스트박스에 커서를 위치
		return false;
		
	}else if(document.regiform.pass.value==""){
		alert("비밀번호를 입력하세요");
		document.regiform.pass.focus();
		return false;
		
	}else if(document.regiform.id.value.length>10){
		alert("아이디를 10자 이내로 적어주세요.");
		document.regiform.id.focus();
		return false;
		
	}else if(document.regiform.pass2.value==""){
		alert("비밀번호확인을 입력하세요");
		document.regiform.pass2.focus();
		return false;
		
	}else if(document.regiform.pass.value!=document.regiform.pass2.value){
		//비밀번호와 비밀번호확인의 값이 다를 경우
		
		alert("입력한 2개의 비밀번호가 일치하지 않습니다.");
		document.regiform.pass.focus();
		return false;
		
	}
	else if(document.regiform.name.value==""){
		alert("이름을 입력하세요");
		document.regiform.name.focus();
		return false;
		
	}else if(document.regiform.phone.value==""){
		alert("핸드폰 번호를 입력하세요");
		document.regiform.phone.focus();
		return false;
	}else if(document.regiform.email1.value==""){
		alert("이메일을 입력하세요");
		document.regiform.email1.focus();
		return false;
		
	}
	else if(document.regiform.dupCheck.value=="false"){
		alert("아이디 중복 체크를 확인 하세요");
		document.regiform.id.focus();     // id 텍스트박스에 커서를 위치
		return false;
	}
	else if(document.regiform.authCheck.value=="false"){
		alert("이메일 인증을 완료 하세요");
		document.regiform.input_code.focus();     // id 텍스트박스에 커서를 위치
		return false;
	}
	

	
//	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
//	
//	if(exptext.test(document.addjoin.email.value)==false){
//		//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
//		
//		alert("이 메일형식이 올바르지 않습니다.");
//		document.addjoin.email.focus();
//		exit;
//	}
	else
	return true;
	
	

	
}
