<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<script src="http://code.jquery.com/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
</body>
<script type="text/javascript">
$(function(){
	alert("게시판 글 등록이 완료되었습니다.");
	document.location.href="list";
})

</script>
</html>