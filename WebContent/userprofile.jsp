<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
 MemberDTO dto = (MemberDTO)session.getAttribute("login");
 //거래량 추가해야함
 String userid = (String)request.getParameter("userid");
 String userImage = (String)request.getParameter("userImage");
 String nickName = (String)request.getParameter("nickName");
 System.out.println("jsp에서=="+userImage);
 System.out.print("jsp에서=="+nickName);
 
%>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 보기</title>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
 });//end ready
</script>
</head>
<body>

<div class="container">
    <div class="row profile">
		<div class="col-md-3">
			<div class="profile-sidebar">
				<!-- SIDEBAR USERPIC -->
				<div class="profile-userpic">
					<img src="/Dong-Dong/images/profile/<%= userImage %>" class="img-responsive" alt="">
				</div>
		
				</div>
			
				<div class="profile-usermenu">
					<ul class="nav">
					
						<li>
							<a href="#">
							<i class="glyphicon glyphicon-user"></i>
							<%= nickName %></a>
						</li>
						<li>
							<a href="#" >
							<i class="glyphicon glyphicon-ok"></i>
							거래량  ??개 </a>
						</li>
					
					</ul>
				</div>
				<!-- END MENU -->
			</div>
		</div>
		<div class="col-md-9">
            <div class="profile-content">
            <i class="glyphicon glyphicon-comment"></i><br>
			   안녕하세요.
            </div>
		</div>
		<%if(dto!=null && !dto.getUserid().equals(userid)) { %>
		<div style="text-align : right">
			<a class="btn btn-danger" href="complaint/complaintUser.jsp?userid=<%=userid%>" id="complaintUser">신고</a>
		</div>
		<%}%>
	</div>
</body>
</html>