<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
 <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">Marcel Newman</h5>
              	  	
                  <li class="mt">
                      <a class="active" href="/test1/admin">
                          <i class="fa fa-dashboard"></i>
                          <span>대시보드</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-user"></i>
                          <span>회원 관리</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="user">회원 관리</a></li>
                          <li><a  href="user">탈퇴회원 관리</a></li>
                      </ul>
                      
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-file-powerpoint-o"></i>
                          <span>포트폴리오 관리</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="manageport.jsp">포트폴리오 관리</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu" style="display:none;">
                      <a href="javascript:;" >
                          <i class="fa fa-user"></i>
                          <span>재능기부 관리</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="#">재능기부 관리</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-pencil"></i>
                          <span>게시판 관리</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="notice">공지사항</a></li>
                          <li><a  href="faq">자주묻는 질문</a></li>
                      </ul>
                  </li>
                   <li class="sub-menu">
                      <a href="javascript:alert('준비중입니다.')" >
                          <i class="fa fa-bar-chart-o"></i>
                          <span>통계 관리</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:alert('준비중입니다.')" >
                          <i class="fa fa-user"></i>
                          <span>사이트 관리</span>
                      </a>
                  </li>
					
                  <li class="sub-menu">
                      <a href="javascript:alert('준비중입니다.')" >
                          <i class="fa fa-cogs"></i>
                          <span>시스템 관리</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class=" fa fa-bar-chart-o"></i>
                          <span>Charts</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="morris.html">Morris</a></li>
                          <li><a  href="chartjs.html">Chartjs</a></li>
                      </ul>
                  </li>

              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
</body>
 </html>