
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
	<head>
		<title>Landed by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css?ver=0.1">
	</head>
	<body class="landing">
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
	</body>
</html>