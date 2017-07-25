<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Landed by HTML5 UP</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="resources/assets/css/main.css" />
		<link rel="stylesheet" href="resources/style.css">
		<script src="resources/assets/js/jquery-3.2.0.min.js"></script> <!-- 제이쿼리 라이이브러리 연동 -->	
	<script type="text/javascript">
	$(function(){//아이디 중복 확인
		$("#idcheckbtn").bind("click",function(){
			var id=$("#id").val();

	    $.ajax({
	        type:"POST",
	        data :{ "id" : id },
	        dataType:"json",
	        url :"/free/idCheck",
	        success : function(data){
	        	
	        	if(data==false){
	        		alert("사용 할 수 있는 아이디 입니다.");
	        		$("#dupCheck").val("true");
	        	}
	        	else
	        		alert("사용 할 수 없는 아이디 입니다.");
	        },
	        error : function(){
                alert("알랄랴");


	        }
	    });
	});
	});
	
	
	$(function(){//이메일 전송
		$("#send_mail").bind("click",function(){
	   
			var email= $("#email1").val()+"@"+$("#email2").val();
			$.ajax({
	        type:"POST",
	        dataType:"json",
	        data:{ "email" : email  },
	        url :"/free/regiMail",
	        success : function(data){
	        	
	        	if(data==true)
	        	alert("이메일이 성공적으로 전송되었습니다.");
	        	else
	        		alert("이메일 전송 실패");
	        	
	        },
	        error : function(){
                alert(email);


	        }
	    });
	});
	});
	
	$(function(){//이메일 인증번호 확인
		$("#check_mail").bind("click",function(){
	   
			var code=$("#input_code").val();
			
			$.ajax({
	        type:"POST",
	        dataType:"json",
	        data:{ "code" : code  },
	        url :"/free/regiMail_check",
	        success : function(data){
	        	
	        	if(data==true){
	        		alert("이메일 인증이 완료 되었습니다.");
	        		$("#authCheck").val("true");

	        	}
	        	else
	        		alert("이메일 인증이 실패하셨습니다.");
	        	
	        },
	        error : function(){
                alert("실패");


	        }
	    });
	});
	});
	

	
	
	</script>

	</head>
	<body class="landing">
	
		<div id="page-wrapper">

			<!-- Header -->
				<header id="header">
				<div class="top_blue"></div>
					<div class="tophead">
					<h1 id="logo"><a href="#"></a></h1>
						<div id="tomember">
							<ul style="width: 329px;">
								<li style="width: 30%;"><a href="login.html">로그인</a></li>
								<li style="width: 30%;"><a href="join_agree.html">회원가입</a></li>
								<li style="width: 40%;"><a href="findid.html">ID/PW 찾기</a></li>
							</ul>
						</div>
					</div>
					<div class="cat">
						<ul class="menu">
							<li><a href="#">포트폴리오</a></li>
							<li><a href="#">재능기부</a></li>
							<li><a href="#">공지사항</a></li>
							<li><a href="#">게시글 등록</a></li>
							<li><a href="modify_info.html">마이페이지</a></li>
						</ul>
					</div>
				</header>
				<div class="sub_container">
					<div class="content">
						<h3>회원가입</h3>
						<div class="joinmenu">
							<ul>
								<li>
								<div class="step"><h4 class="ico1"></h4><span>STEP 01</span>
								<p>약관동의</p></div>
								</li>
								<li class="on">
								<div class="step"><h4 class="ico2"></h4><span>STEP 02</span>
								<p>정보입력</p></div>
								</li>
								<li>
								<div class="step"><h4 class="ico3"></h4><span>STEP 03</span>
								<p>가입완료</p></div>
								</li>
							</ul>
						</div>
						<div class="joinform">
						<form action="registersuccess" method="post" name="regiform">
						<input type="hidden" id="dupCheck" name="dupCheck" value="false">	
 						<input type="hidden" id="authCheck" name="authCheck" value="false">	
							
							<table>
								<tr>
									<td>아이디</td>
									<td><input type="text" id="id" name="id">
									<input type="button" class="gray_btn" value="중복확인" id="idcheckbtn">
									</td>
								</tr>
								<tr>
									<td>비밀번호</td>
									<td><input type="text" id="pass" name="pass" ></td>
								</tr>
								<tr>
									<td>비밀번호 확인</td>
									<td><input type="text" id="pass2" name="pass2"></td>
								</tr>
								<tr>
									<td>이름</td>
									<td><input type="text" id="name" name="name"></td>
								</tr>
								<tr>
									<td>생년월일</td>
									<td>
										<select class="sel" name="b_year">
											<option>년도</option>
											<option>1990</option>
										</select>
										<select class="sel2" name="b_month">
											<option>월</option>
											<option>01</option>							
										</select>
										<select class="sel2" name="b_day">
											<option>일</option>
											<option>01</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>성별</td>
									<td>
										<select class="sel" name="c_gender">
											<option>선택</option>
											<option>남성</option>
											<option>여성</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>휴대폰번호</td>
									<td><input type="text" id="phone" name="phone"></td>
								</tr>
								<tr>
									<td>E-mail</td>
									<td>
										<div class="emaildiv">
										<input type="text" class="emailt" style="margin-right:5px;" id="email1" name="email1"> @ <input type="text" class="emailt" style="margin-left:5px; float:right;" id="email2" name="email2">
										</div>
										<select class="sel2" style="width:142px;">
											<option>직접입력</option>
										</select>
										<input type="button" class="gray_btn" value="인증번호받기" style="margin-left:24px; letter-spacing:-1.5px;" id="send_mail" name="send_mail">
									</td>
								</tr>
								<tr>
									<td>E-mail 인증</td>
									<td>
										<input type="text" class="auth" id="input_code" name="input_code">
										<input type="button" class="gray_btn" value="확인" id="check_mail" name="check_mail">
									</td>
								</tr>
							</table>
							<div class="join_btn">
								<input type="submit" value="가입" class="blue" onclick="return checkfield()"> 
								<a href="join_fn.html" class="gray cancel">취소</a>
								
							</div>
							</form>
						</div> 
					</div>
				</div>
		<!-- Footer -->
			<footer id="footer">
				<div class="foot_menu">
					<ul>	
						<li style="width: 16.6%;"><a href="#">사이트소개</a></li>
						<li style="width: 16.6%;"><a href="#">이용약관</a></li>
						<li style="width: 16.6%;"><a href="#">개인정보보호정책</a></li>
						<li style="width: 16.6%;"><a href="#">저작권보호정책</a></li>
						<li style="width: 16.6%;"><a href="#">사이트맵</a></li>
						<li style="width: 16.6%;"><a href="#">FAQ</a></li>
					</ul>
				</div>
				<div class="footWrap">
					<div class="intro">
						<p>동아리명&ensp;:&ensp;<span>CROSS IT(크아)</span></p>
						<p>팀&emsp;&emsp;명&ensp;:&ensp;<span>에취에취</span></p>
						<p>팀&emsp;&emsp;원&ensp;:&ensp;<span>박재현(기획)&emsp;&ensp;이동건(개발)&emsp;&ensp;이현빈(개발)&emsp;&ensp;한여경(개발)&emsp;&ensp;이승태(디자인)</span></p>
						<p>전화번호&ensp;:&ensp;<span>1588-5588</span> &emsp;&ensp;이메일&ensp;:&ensp;<span>help@naver.com</span></p>
						<p style="margin-top:18px; font-size:12px; letter-spacing: -0.7px; opacity: 0.7">-copyright(c)2017 Mochi Inc.All right reserved.</p>
					</div>
				</div>
			</footer>
			</div>
		<!-- Scripts -->
			<script src="resources/assets/js/jquery.min.js"></script>
			<script src="resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="resources/assets/js/jquery.dropotron.min.js"></script>
			<script src="resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="resources/assets/js/skel.min.js"></script>
			<script src="resources/assets/js/util.js"></script>
			<script src="resources/mochi.js"></script>
			<script src="resources/assets/js/util.js"></script>
			<script src="resources/assets/js/registerCheck.js?ver=1"></script>
			
	</body>
</html>