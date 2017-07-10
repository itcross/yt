
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
	<body class="landing">
		<div id="page-wrapper">
			<jsp:include page="header.jsp"></jsp:include>
				<div class="sub_container">
					<div class="content">
						<h3>ID/PW 찾기</h3>
						<div class="findmenu">
							<ul>
								<li><a href="findid.html">ID찾기</a></li>
								<li id="on"><a href="#">PW찾기</a></li>
							</ul>
						</div>						
						<div class="findform" id="pw">
							<table>
								<tr>
									<td>아이디</td>
									<td><input type="text" id="user_id"></td>
								</tr>
								<tr>
									<td>이름</td>
									<td><input type="text" id="user_name"></td>
								</tr>
								<tr>
									<td>이메일 주소</td>
									<td>
										<div class="emaildiv">
										<input type="text" class="emailt" id="email1" style="margin-right:5px;"> @ <input type="text" class="emailt" id="email2" style="margin-left:5px; float:right;">
										</div>
										<select class="sel2" style="width:142px;">
											<option>직접입력</option>
										</select>								
									</td>
								</tr>
							</table>
							<div class="select" id="selectpw"><a href="#">조회</a></div>
							<div class="result" style="display:none;"><p>임시 비밀번호는 <span id="fpw"></span> 입니다.</p></div>
							<div class="goto" style="display:none;"><a href="login.html">로그인 바로가기</a></div>
						</div>
						
					</div>
				</div>
				<jsp:include page="footer.jsp"></jsp:include>
			</div>
		
	</body>
	<script type="text/javascript">
	$(function(){
		$("#selectpw").click(function(){
			$.ajax({
				type : 'POST',
				data : {
					'user_email' : $("#email1").val() + "@" + $("#email2").val() ,
					'user_name' : $("#user_name").val(),
					'user_id' : $("#user_id").val()
				},
				url : 'testpw',
				success : function(data){
					if(data.resultCode == 0){
						alert("일치하는 회원정보가 없습니다.");
					}else{
						$("#fpw").html(data.pw);
						$("#selectpw").hide();
						$(".result").fadeIn(1500);
						$(".goto").fadeIn(1500);
					}
				},
				error:function(jqXHR, textStatus, errorThrown){
		            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
		        }	
			});		
		});	
	})
	
	
	
	</script>
</html>