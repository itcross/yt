
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
<style>
.container{
    text-align: center;
    background-color: #e74c3c;
    overflow: hidden;
}

.box{
    display: inline-block;
    height: 200px;
    width: 33.3%;
    position: relative;
    /*margin:0 -4px -5px -2px;*/
    transition: all .2s ease;
}

/* -------------- loader4 -------------- */

.loader4{
    position: relative;
    width: 150px;
    height: 20px;

    top: 45%;
    top: -webkit-calc(50% - 10px);
    top: calc(50% - 10px);
    left: 25%;
    left: -webkit-calc(50% - 75px);
    left: calc(50% - 75px);

    background-color: rgba(255,255,255,0.2);
}

.loader4:before{
    content: "";
    position: absolute;
    background-color: #fff;
    top: 0px;
    left: 0px;
    height: 20px;
    width: 0px;
    z-index: 0;
    opacity: 1;
    -webkit-transform-origin:  100% 0%;
            transform-origin:  100% 0% ;
    -webkit-animation: loader4 10s ease-in-out infinite;
            animation: loader4 10s ease-in-out infinite;
}

.loader4:after{
    content: "LOADING ...";
    color: #fff;
    font-family:  Lato,"Helvetica Neue" ;
    font-weight: 200;
    font-size: 16px;
    position: absolute;
    width: 100%;
    height: 20px;
    line-height: 20px;
    left: 0;
    top: 0;
}

@-webkit-keyframes loader4{
    0%{width: 0px;}
    70%{width: 100%; opacity: 1;}
    90%{opacity: 0; width: 100%;}
    100%{opacity: 0;width: 0px;}
}

@keyframes loader4{
    0%{width: 0px;}
    70%{width: 100%; opacity: 1;}
    90%{opacity: 0; width: 100%;}
    100%{opacity: 0;width: 0px;}
}

</style>
<script src="//code.jquery.com/jquery.min.js"></script>
</head>
<body>
<div class="container">
	<div class="box">
            <div class="loader4"></div>
    </div>
</div>
<script>
$(function(){
	$.ajax({
		type : 'get',
		url : 't',
		data : {
			'imgName' : "${img}",
			'mp3Name' : "${mp3}"			
		},
		success : function(data){
			console.log(data);
			if(data.code == 0){
				//결과페이지 유투브 업로드 완료
				//location.href="t2?ytbID="+data.id;
			}else{
				console.log(data);
				alert("에러가 발생하였습니다.");
				window.close();	
			}
		},
		error : function(){
			alert("error!!!");
		}	
	});
})
</script>
</body>
</html>