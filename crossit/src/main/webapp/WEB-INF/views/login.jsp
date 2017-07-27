<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Landed by HTML5 UP</title>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="resources/style.css">
		<link rel="stylesheet" href="resources/assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<script>
		  
		function loginCheck({
		            // 태크.val() : 태그에 입력된 값
		            // 태크.val("값") : 태그의 값을 변경 
		            var userId = $("#loginid").val();
		            var userPw = $("#loginpw").val();
		            if(userId == ""){
		                alert("아이디를 입력하세요.");
		                $("#loginid").focus(); // 입력포커스 이동
		                return false; // 함수 종료
		            }
		            if(userPw == ""){
		                alert("비밀번호를 입력하세요.");
		                $("#loginpw").focus();
		                return false;
		            }
		           
		            return true;
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
						<h3>로그인</h3>
						<div class="loginform">
							<div id="loginmark"></div>
							<div id="login_box">
								<div id="welcome"></div>
								<div id="box">	
								<form action="login" method="post">						
									<input type="text" placeholder='ID' name="loginid" class="loginp placeid"/> 
									<input type="text" placeholder="PASSWORD" name="loginpw" style="margin-top:6px;" class="loginp placepw"/>
									<input type="submit" value="LOGIN" id="login_btn" style="display:inline-block;" onclick="return loginCheck()">
									<c:if test="${msg == 'failure'}">
                 				    <div style="color: red">
                        		           아이디 또는 비밀번호가 일치하지 않습니다.
            				        </div>
            				        </c:if>
									</form>
						
									<div id="botton">
										<input type="checkbox" name="saveid" value="" id="saveid">아이디 저장
										<a href="join_agree" id="gray">회원가입</a>
										<a href="findid" id="gray" style="margin-left: 33px;">ID/PW찾기</a>
									</div>
								</div>
							</div>
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
						<p>전화번호&ensp;:&ensp;<span>1588-5588</span> &emsp;&ensp;이메일&ensp;:&ensp;<span>help@naver.co</span></p>
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
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="resources/mochi.js"></script>
	</body>
</html>