<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 MemberDTO dto = (MemberDTO)request.getAttribute("nickDto"); 
 String nickName = dto.getNickName(); 
System.out.print(nickName);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
	text-align: center;
	border: solid 3px gray;
	margin: auto;
	padding: auto;
}
</style>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
		$("button").click(function() {
			var nickName = <%= nickName %>;
			console.log(nickName.length);
			opener.$("#resultNick").val(nickName);
			console.log("여기"+nickName);
			window.close();
		});
 });
</script>
</head>
<body>
<div>
<h4><%= nickName %> 으로 변경되었습니다</h4>
<button>확인</button>
</div>
</body>
</html>