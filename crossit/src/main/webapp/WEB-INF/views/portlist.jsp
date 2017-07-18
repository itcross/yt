
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
<title>Insert title here</title>
</head>
<body>

포트폴리오 리스트
<br><br><br>
<table width="800px" border="1">
	<tr>
		<td>사진</td>
		<td>이름</td>
		<td>경력</td>
		<td>작성일</td>
		<td>해시태그</td>
		<td>제목</td>
	</tr>
	<c:forEach items="${portl}" var="pf">
		<tr>
			<td>${pf.picture1}</td>
			<td>${pf.name_kr}</td>
			<td>${pf.r_degree}</td>
			<td>${pf.r_wdate}</td>
			<td>${pf.r_hash}</td>
			<td>${pf.r_subject}</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>