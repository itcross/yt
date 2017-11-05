
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유투브 옵션 설정</title>
</head>
<body>
<h1>유투브 업로드 설정</h1>
<form action="pp" method="POST">
제목 : <input type="text" name="title"><br>
내용 : <textarea rows="10" cols="30" name="desc"></textarea><br>
태그 :
	<input type="text" name="tag"> 
	<br>
	<input type="submit" value="전송">
</form>
</body>
</html>