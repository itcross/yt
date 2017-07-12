
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
						<h3>로그인</h3>
						<div class="loginform">
						<form name="login_f" method="post" action="login.do">
							<div id="loginmark"></div>
							<div id="login_box">
								<div id="welcome"></div>
								<div id="box">							
									<input type="text" placeholder='ID' name="user_id" class="loginp placeid"/> 
									<input type="text" placeholder="PASSWORD" name="user_pwd" style="margin-top:6px;" class="loginp placepw"/>
									<input type="submit" value="LOGIN" id="login_btn" style="display:inline-block;">
									<div id="botton">
										<input type="checkbox" name="saveid" value="" id="saveid">아이디 저장
										<a href="join_agree.html" id="gray">회원가입</a>
										<a href="test" id="gray" style="margin-left: 33px;">ID/PW찾기</a>
									</div>
								</div>
							</div>
						</form>
						</div>
					</div>
				</div>
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</body>
</html>