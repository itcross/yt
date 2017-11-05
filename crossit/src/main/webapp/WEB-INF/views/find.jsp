<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<button id="btn">클릭</button>
<script type="text/javascript">
$(function(){
	
	$("#btn").on('click',function(){
		$.ajax({
			type : 'get',
			url : 't',
			success : function(data){
				alert(data);
				location.href="t2"
			},
			error : function(){
				alert("error!!!");
			}	
		});
	});
})
</script>

</body>

</html>