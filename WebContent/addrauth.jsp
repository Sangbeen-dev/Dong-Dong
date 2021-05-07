<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String addr1 = (String)request.getAttribute("auth1");
String addr2 = (String)request.getAttribute("auth2");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.auth {
	text-align: center;
	border: solid 3px gray;
	margin: auto;
	padding: auto;
}
</style>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	$("#auth1").click(function() {
    		 var addr11 = $("#addrA1").text();
    		console.log(addr11);
			opener.$("#addr").val(addr11); 
			window.close(); 
		});
    	$("#auth2").click(function() {
    		var addr22 = $("#addrA2").text();  
    		console.log(addr22);
			opener.$("#addr").val(addr22);
			window.close();
		});
 });//end ready
</script>
</head>
<body>
<%
if(addr1!=null){ %>
<div class="auth">
<h4><%= addr1 %>&nbsp;인증성공!<br>우리 동네는&nbsp;<span id="addrA1"><%= addr1 %></span>!!</h4>
<button id="auth1" >확인</button>
</div>
<%} else {%>
<div class="auth">
<h4>현재 위치로 인증성공!<br>우리 동네는&nbsp;<span id="addrA2"><%= addr2 %></span>!! </h4>
<button id="auth2">확인</button>
</div>
<%} %>

</body>
</html>