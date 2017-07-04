<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - FREE Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script language="JavaScript">
	//setTimeout("history.go(0);",3000);
	//새로고침 스크립트
</script>
  </head>

  <body>
<%Date date = new Date();
SimpleDateFormat df = new SimpleDateFormat("YYYY-M");
String d = df.format(date);

%>
  <section id="container" >
  
   		<!-- 헤더 -->
      <%@ include file="header.jsp" %>
     	 <!-- 사이드-->
      <%@ include file="sidebar.jsp" %>
      
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
       			<h4><i class="fa fa-home"></i>  HOME <i class="fa fa-angle-right"></i> 게시판 <i class="fa fa-angle-right"></i> 공지사항</h4>
       			<div class="row mt">
          		<div class="col-lg-12">
                <form class="form-horizontal style-form" method="get">
                  <div class="form-panel">
                  <h4><b>자주 묻는 질문 글쓰기</b></h4>
                  <hr class="mb">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label" style="text-align: center;">질문</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control">
                              </div>
                          </div>
                          <div class="form-group" style="display: none;">
                              <label class="col-sm-2 col-sm-2 control-label">Input focus</label>
                              <div class="col-sm-10">
                                  <input class="form-control" id="focusedInput" type="text" value="This is focused...">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label" style="text-align: center;">작성일</label>
                              <div class="col-sm-10">
                                  <input class="form-control" id="disabledInput" type="text" placeholder="<%=d %>" disabled>
                              </div>
                          </div>
                          <div class="form-group">
                          <label class="col-lg-2 col-sm-2 control-label" style="text-align: center;">답변</label>
	                          <div class="col-sm-10">
	                          		<textarea class="form-control" rows="15"></textarea>
	                          </div>
                     	  </div>
                          </div>
                          <div class="row mt" style="margin-top: 50px;">
	                          <div class="text-center col-sm-12">
									<button type="button"  class="btn btn-primary"> 등록 </button>
									<button type="button"  class="btn btn-default" onclick="history.back();"> 취소 </button>
	                          </div>
							</div>
                      </form>
                  </div>
          		</div>
          </section>
      </section>

      <!--main content end-->
     
      <!-- footer -->
      <%@ include file="footer.jsp" %>
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom switch-->
	<script src="assets/js/bootstrap-switch.js"></script>
	
	<!--custom tagsinput-->
	<script src="assets/js/jquery.tagsinput.js"></script>
	
	<!--custom checkbox & radio-->
	
	<script type="text/javascript" src="assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>
	
	<script type="text/javascript" src="assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
	
	
	<script src="assets/js/form-component.js"></script>    
    
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>