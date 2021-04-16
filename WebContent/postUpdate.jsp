<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page = "common/top.jsp" flush = "true" /><br>
		<jsp:include page = "common/menu.jsp" flush ="true" /><br>
		<hr>
		<jsp:include page = "post/postUpdate.jsp" flush ="true" />
</body>
</html>