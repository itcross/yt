
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>개인포트이력입니다.</h1>

<br><br><br>
<table width="800px" border="1">
	<tr>
		<td>아이디(출력하면 안됨)</td>
		<td>${f.user_id}</td>
	</tr>
	<tr>
		<td>포지션</td>
		<td>${f.position}</td>
	</tr>
	<tr>
		<td>사진</td>
		<td>${f.picture1}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${f.r_subject}</td>
	</tr>
	<tr>
		<td>해쉬태그</td>
		<td>${f.r_hash}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${f.name_kr}</td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td>${f.r_birth}</td>
	</tr>
</table><br>

${l}

<input type="button" value="수정">
<input type="button" value="삭제" id="del">


</body>
</html>