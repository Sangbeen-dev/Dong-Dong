<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#main").click(function() {
			location.href="main";
		})
		
	})//end ready
	
</script>
</head>
<body>
<<<<<<< HEAD
<img id="main" src="/Dong-Dong/images/util/DongDonglogo.png" width="250" height="100" />
<br>
<!-- <h3>MyPage</h3> -->
=======
<img id="main" src="/Dong-Dong/images/util/DongDonglogo.png" width="250" height="50" />

<h3>MyPage</h3>
>>>>>>> d23f1384863dbb7d17947a373872facef4b5cd74

<jsp:include page="common/top.jsp" flush="true"></jsp:include><br>
<jsp:include page="common/menu.jsp" flush="true"></jsp:include><br>
<hr>
<jsp:include page="member/mypage.jsp" flush="true"></jsp:include>

</body>
</html>