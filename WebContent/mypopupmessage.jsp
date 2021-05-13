<%@page import="com.dto.MemberDTO"%>
<%@page import="sun.net.www.content.image.png"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.MyOrderSheetDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
MemberDTO dto =(MemberDTO)session.getAttribute("login");
String userid = dto.getUserid();
int saleCount = (Integer)request.getAttribute("saleCount");
List<MyOrderSheetDTO> list = (List<MyOrderSheetDTO>)request.getAttribute("message");
String oMessage1 = list.get(0).getoMessage();
int oNum = list.get(0).getoNum();
int pNum = list.get(0).getpNum();
String bUserid = list.get(0).getbUserid();
String sUserid = list.get(0).getsUserid();
String oMessage = list.get(0).getoMessage();
String nickName = list.get(0).getNickName();
String userImage = list.get(0).getUserImage();

%>
<html>
<head>
<meta charset="UTF-8">
<title>메세지 더보기</title>
<style type="text/css">
.form-group{
	margin: 10px;
}

</style>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	//상대프로필보기
    	$("#user").click(function() {
			location.href="userprofile.jsp?nickName="+"<%=nickName%>"+"&userImage="+"<%=userImage%>"+"&saleCount="+"<%=saleCount%>";
		})
    	
    	$("#chat").click(function() {
			location.href="chat/chat.jsp";
		})
		//삭제버튼
		$("#delete").on("click", function() {
			var num = $(this).attr("data-xxx");
			var popup = "1";
			console.log(num);
			location.href="myOrderDelServlet?oNum="+num+"&popup="+popup; 
		});//end delBtn
		
		
		
 });//end ready
</script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">	
<style type="text/css">
	* {
		font-family: 'Nanum Gothic', sans-serif;
		font-size: 15px;
		font-weight : 400;
	} 
</style>
</head>
<body>
<br><br>
<div class="container">
    <div class="row profile">
		<div class="col-md-3">
				<div class="form-group">
					<label for="주문 메세지">주문 메세지</label>
					<textarea class="form-control rounded-0"
						 rows="10" readonly> <%=oMessage1 %></textarea>
				</div>
				<div class="profile-usermenu">
					<ul class="nav">
					
						<li id="user">
							<a href="#">
							<i class="glyphicon glyphicon-user"></i>
							<%= bUserid %></a>
						</li>
						
					
					</ul>
				</div>
				<!-- END MENU -->
			</div>
		</div>
		<br>
		<div style="text-align: center;">
		<button id="chat">채팅</button>&nbsp;<button id="delete" data-xxx=<%=oNum %>>메세지 삭제</button>
		</div>
	</div>
</body>
</html>