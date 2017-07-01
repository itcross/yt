
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css"> <!-- css -->
<script src="http://code.jquery.com/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%Date date = new Date();
SimpleDateFormat format = new SimpleDateFormat("yyyy - MM - dd");
String outtime = format.format(date);
HashMap<String,Object> map = (HashMap<String,Object>)request.getAttribute("map");
%>
<div class="main">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="side.jsp"></jsp:include>
	<div class="bo">
	<h1>검진결과 상세</h1>
	<form name="update" method="post" action="modify">
	<input type="hidden" name="no" value="<%=map.get("no")%>">
	
		<table border="1" cellpadding="0" cellspacing="0" class="botable">
			<colgroup>
				<col width="250px">
				<col width="">
			</colgroup>
			<tr height="10%">
				<td>제목</td>
				<td align="center"><%=map.get("subject") %></td>
			</tr>
			<tr height="40%">
				<td>내용</td>
				<td><textarea name="content"  id="content" cols="100%"  rows="15%" readonly><%=map.get("content") %></textarea></td>
			</tr>
		</table>
		<div class="btn">
			<input type="submit" value="수정">
			<button type="button" onclick="delmsg(<%=map.get("no")%>)">삭제</button> 
			<button type="button" onclick="location.href='list'">리스트</button> 
		</div>
		</form>
	</div>
</div>
</body>
<script type="text/javascript">
function delmsg(a){
	if(confirm("정말로 해당 글을 삭제하시겠습니까?")==true){
		location.href='delete.do?no='+a;
	}else{
		return false;
	}
}

</script>
</html>