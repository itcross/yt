
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css"> <!-- css -->
<script src="http://code.jquery.com/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
Date date = new Date();
SimpleDateFormat format = new SimpleDateFormat("yyyy - MM - dd");
String outtime = format.format(date);
HashMap<String,Object> map = (HashMap<String,Object>)request.getAttribute("view");
String w = null;
String val = null;
String action = null;
String mode = request.getParameter("no");
if(request.getParameter("no")!=null){
	w = "수정";
	val = "value = ";
	outtime = "수정시 변경";
	action = "modify.do";
}else{
	w = "등록";
	val = "";
	action = "write.do";
}
%>

<div class="main">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="side.jsp"></jsp:include>
	<form name="register" onsubmit="return fsb();" action="<%=action %>" method="post">
	<input type="hidden" name="no" value="<%if(mode!=null){out.print(map.get("no"));}else{out.print("");}%>">
	<div class="bo">
	<h1>검진결과 글<%=w %></h1>
		<table border="1" cellpadding="0" cellspacing="0" class="botable">
			<colgroup>
				<col width="250px">
				<col width="">
			</colgroup>
			<tr height="10%">
				<td>제목</td>
				<%if(w=="등록"){ %>
				<td><input type="text" name="subject" id="subject" size="50px"></td>
				<%}else{ %>
				<td><input type="text" name="subject" id="subject" <%=val+map.get("subject") %> size="50px"></td>
				<%} %>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content"  id="content" cols="100%" rows="20%"><%if(mode==null){}else{out.print(map.get("content"));} %></textarea></td>
			</tr>
			<tr height="10%">
				<td>등록일시</td>
				<td><input type="text" name="regdate" value="<%=outtime%>" readonly></td>
			</tr>
		</table>
		<div class="btn">
			<input type="submit" value="<%=w%>"> 
			<input type="button" value="취소" onclick="location.href='write.do'"> 
		</div>
	</div>
	</form>
</div>
<script type="text/javascript">
function fsb(){
	if($("#subject").val()==""){
		alert("제목을 입력해주세요.");
		$("#subject").focus();
		return false;
	}
	if($("#content").val()==""){
		alert("내용을 입력해주세요.");
		$("#content").focus();
		return false;
	}
	
	return true;
	
}
</script>
</body>
</html>