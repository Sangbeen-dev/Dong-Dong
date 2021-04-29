<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int n = (Integer)request.getAttribute("nickCheck");
String nickName = (String)request.getAttribute("nickName");
System.out.print(n);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form {
	text-align: center;
	border: solid 3px gray;
	margin: auto;
	padding: auto;
}
</style>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	$("#okNick").click(function() {
			$("#nickForm").attr("action", "nickUpdateServlet");
			//중복아닐시 UpdateServlet으로 이동하여 db 적용!
		});
		$("#noNick").click(function() {
			$("#renick").attr("action", "checkNick.jsp");
			//opener.$("#nickName").focus();
			//window.close();
		});
 });//end ready
</script>
</head>
<body>
<%
if(n==0){ %>
<form id=nickForm>
<h4>입력하신 닉네임 :  <%= nickName %><br>사용할 수 있는 닉네임 입니다. </h4>
<input type="hidden" value="<%= nickName %>" name="nickName"> <!--닉네임을 히든태그로 보냄  -->
<button id=okNick>사용하기</button>
</form>
<%} else {%>
<form id=renick>
<h4 align="center">이미 사용중인 닉네임 입니다. </h4>
<button id=noNick>돌아가기</button>
</form>
<%} %>
</body>
</html>