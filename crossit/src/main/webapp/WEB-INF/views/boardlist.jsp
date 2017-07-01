
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
<div class="main">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="side.jsp"></jsp:include>

	<form>
	<div class="bo">
	<h1>검진결과 관리</h1>
		<table border="1" cellpadding="0" cellspacing="0" class="listtable">
			<colgroup>
				<col width="10%">
				<col width="">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록일시</th>
				<th>비고</th>
			</tr>
			<%
			List<HashMap<String,Object>> list = (List<HashMap<String,Object>>)request.getAttribute("list");
			for(int i = 0 ; i < list.size() ; i++ ){
				HashMap map = list.get(i);
			%>
			<c:forEach items="list" var="list">
			<tr>
				<td><%=map.get("no") %></td>
				<td align="center"><a href="detail?no=<%=map.get("no")%>"><%=map.get("subject") %></a></td>
				<td align="center"><%=map.get("regdate") %></td>
				<td></td>
			</tr>
			</c:forEach>
			<%} %>
		</table>
		<div class="btn">
			<input type="button" value="신규 등록" onclick="location.href='write'"> 
		</div>
	</div>
	</form>
</div>
</body>
</html>