<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dongdong market-Home</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#main").click(function() {
			location.href="main";
		})
		
	})//end ready
</script>
<style type="text/css">
	header{
		position : fixed;
		top : 0;
		left : 0;
		right : 0;
		z-index : 1;
		background-color : white;
		text-align : center;
	}
	
	main{
		padding-top : 180px;
		z-index : 2;
	}
</style>
</head>
<body>
<%
	String mesg = (String)session.getAttribute("mesg");
	if(mesg != null){
%>
	<script type = "text/javascript">
		alert('<%=mesg %>');
	</script>
<%
	//
	session.removeAttribute("mesg");
	}
%>

<header>

<img id="main" src="/Dong-Dong/images/util/DongDonglogo.png" width="222" height="52" style="cursor: pointer;"/><br><br>

<jsp:include page="common/top.jsp" flush="true"></jsp:include><br>
<jsp:include page="common/menu.jsp" flush="true"></jsp:include><br>
</header>
<!-- content추가예정 -->
<main>
<jsp:include page="post/postList.jsp" flush="true"></jsp:include><br>
</main>
</body>
</html>