<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int n = (Integer)request.getAttribute("nickCheck");
String nickName = (String)request.getAttribute("nickName");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
		$("body").click(function() {
			window.close();
		})
		
 });
</script>
</head>
<body>
<%
if(n==0){ %>
<br><br>
<h4 align="center">입력하신 <%= nickName %> 사용할 수 있는 닉네임 입니다. </h4>
<%} else {%>
<br><br>
<h4 align="center">이미 사용중인 닉네임 입니다. </h4>
<%} %>
</body>
</html>