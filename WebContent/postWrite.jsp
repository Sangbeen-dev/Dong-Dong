<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글쓰기</title>
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#main").click(function() {
					location.href="main";
				});
		
			});//end ready
		</script>
	</head>
	<body>
		<img id="main" src="/Dong-Dong/images/util/DongDonglogo.png" width="222" height="52" /><br><br>
		<jsp:include page = "common/top.jsp" flush="true" /><br>
		<hr>
		<jsp:include page = "post/postWrite.jsp" flush="true" />
</body>
</html>