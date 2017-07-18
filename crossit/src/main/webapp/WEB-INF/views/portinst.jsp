
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
<h2>포트폴리오 등록</h2>
부분 : <input type="text" name="position"><br>
사진첨부 : <input type="file" name="picture1"> -- 추가버튼시 사진첨부(최대3개)<br>
제목 : <input type="text" name="r_subject"><br>
키워드 : <input type="text" name="r_hash"><br>
SNS 주소 : <input type="text" name="sns_url"> -- 추가버튼시 텍스트추가(최대2개)<br>
이름 : <input type="text" name="name_kr"><br>
(이름)영문 : <input type="text" name="name_en"><br>
생년월일 : <input type="text" name="r_birth"><br>
경력 : <input type="text" name="r_degree"><br>
PHONE : <input type="text" name="r_phone"><br>
이메일주소 : <input type="text" name="r_email"><br>
주소 : <input type="text" name="r_address"><br>
<br><br>
<h3>업무스킬</h3>
<input type="text" name="skill"> 점수 : <input type="text" name="score" size="10px"> -- 추가시 입력텍스트 추가(최대 5개)<br>
<h3>취미 및 재능</h3>
<input type="text" name="r_address"> 점수 : <input type="text" name="r_score" size="10px"> -- 추가시 입력텍스트 추가(최대 5개)<br>
<h3>수행 프로젝트</h3>
프로젝트명 : <input type="text" name="PRJ_NAME"> <br>
프로젝트내용 : <input type="text" name="P_CONTENT"><br>
사용 스킬 : <input type="text" name="USED_SKILL"><br>
기간 : <input type="text" name="PERIOD_ST" size="10px"> ~ <input type="text" name="PERIOD_ex" size="10px"><br>
<h3>이미지앨범</h3>
앨범명 : <input type="text" name="CATEGORY"><br>
이미지 : <input type="file" name="IMAGE"><br>

<input type="submit" value="등록">
<input type="button" value="임시저장">
</body>
</html>