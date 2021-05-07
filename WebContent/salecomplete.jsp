<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
/* 	int n = (Integer) request.getAttribute("sale"); */
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	text-align: center;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("button").click(function() {
			opener.parent.location.reload();
			window.close();
		})
	});//end ready
</script>
</head>
<body>
	<h3>판매가 완료 되었습니다.</h3>
	<button>확인</button>
</body>
</html>