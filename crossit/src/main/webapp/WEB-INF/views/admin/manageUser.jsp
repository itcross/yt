<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
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
//스크립트끝-->
</script>
  </head>

  <body>

  <section id="container" >
  
   		<!-- 헤더 -->
      <%@ include file="header.jsp" %>
     	 <!-- 사이드-->
      <%@ include file="sidebar.jsp" %>
      
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
       			<h4>  HOME <i class="fa fa-angle-right"></i> 회원관리 <i class="fa fa-angle-right"></i> 회원관리</h4>
       			<div class="row mtbox2">
       			<h3 style="margin-left: 30px;">회원목록</h3>
       			<hr class="mb" style="margin-left: 20px;margin-right: 20px;">
	       			<div class="col-md-2 col-sm-2 col-sm-offset-1 col-md-offset-1 box0" style="display: none;">
               			<div class="box1">
		  					<h3>회원목록</h3>
               			</div>
               		</div>
               		<div class="col-md-6 col-sm-12 col-md-offset-6">
               		<div class="row">
               		<form class="form">
               			<div class="col-md-3 form-group">
               			<select class="form-control col-md-3">
               				<option>선택</option>
               			</select>
               			</div>
               			<div class="col-md-6 form-group" >
               				<input type="text" class="form-control">
               			</div>
               			<div class="col-md-3">
               				<button type="button" class="btn btn-primary">검색</button>
               			</div>
               		</form>
               		</div>
               		</div>
	                  		</div>
                  		<div class="row">             
	                  <div class="col-md-12 mt">
	                  	<div class="content-panel">
	                          <table class="table table-hover">
		                  	  	  <colgroup>
		                  	  	  	<col width="5%">
		                  	  	  	<col width="10">
		                  	  	  	<col width="10">
		                  	  	  	<col width="10">
		                  	  	  	<col width="10">
		                  	  	  	<col width="10">
		                  	  	  	<col width="10">
		                  	  	  	<col width="10">
		                  	  	  	<col width="10">
		                  	  	  </colgroup>
	                              <thead>
	                              <tr>
	                                  <th>No.</th>
	                                  <th>아이디</th>
	                                  <th>이름</th>
	                                  <th>생년월일</th>
	                                  <th>휴대폰번호</th>
	                                  <th>이메일주소</th>
	                                  <th>성별</th>
	                                  <th>가입일</th>
	                                  <th>비밀번호<br>초기화</th>
	                              </tr>
	                              </thead>
	                              <tbody>
	                             <c:forEach var="board" items="${tmeList}">
										<tr>
											<td>${board.user_no }</td>
											<td>
											${board.user_id }
											</td>
											<td>${board.user_name }</td>
											<td>${board.user_birth }</td>
											<td>${board.user_phone }</td>
											<td>${board.user_email }</td>
											<td>${board.user_sex }</td>
											<td>${board.reg_date }</td>
											</tr>
								</c:forEach>
	                            </tbody>
	                          </table>
	                  	  </div>
	                  </div>
				</div>
				<div class="row mt text-center" >
					<div class="btn-group">
	
					<c:if test="${totalCnt > 0}">
  					<c:set var="pageCount" value="${totalCnt / listMax + ( totalCnt % listMax == 0 ? 0 : 1)}"/>
   					<c:set var="startPage" value="${pageMax*(pageGroupNum-1)+1}"/>
   					<c:set var="endPage" value="${startPage + pageMax-1}"/>
   
   					<c:if test="${endPage > pageCount}" >
   				    <c:set var="endPage" value="${pageCount}" />
   					</c:if>
          
   					<c:if test="${pageGroupNum > 1}">
        			<a href="user?pageNum=${(pageGroupNum-2)*pageMax+1 }">[이전]</a>
   					</c:if>
   					
					<c:forEach var="i" begin="${startPage}" end="${endPage }">
					
					<a href="user?pageNum=${i}">[
          			<c:if test="${currentNum == i}">
        			 	${i} ]
        			
       			  	</c:if>
       			
      				</a>
 		
</c:forEach>


   					<c:if test="${pageGroupNum < pageGroupCount}">
       				 <a href="list?pageNum=${pageGroupNum*pageMax+1}">[다음]</a>
   					</c:if>
				</c:if>
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
    <script src="assets/js/jquery-1.8.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="assets/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="assets/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="assets/js/sparkline-chart.js"></script>    
	<script src="assets/js/zabuto_calendar.js"></script>	
	
	<script type="text/javascript">
        $(document).ready(function () {
        	$(".go-top").click(function(){
        		$("html, body").animate({scrollTop:0});
        	});
        	
        	
        var unique_id = $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'Welcome to Dashgum!',
            // (string | mandatory) the text inside the notification
            text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="http://blacktie.co" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
            // (string | optional) the image to display on the left
            image: 'assets/img/ui-sam.jpg',
            // (bool | optional) if you want it to fade out on its own or just sit there
            sticky: true,
            // (int | optional) the time you want it to be alive for before fading out
            time: '',
            // (string | optional) the class name you want to apply to that specific message
            class_name: 'my-sticky-class'
        });

        return false;
        });
	</script>
	
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
  

  </body>
</html>
