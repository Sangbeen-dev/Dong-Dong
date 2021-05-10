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
		<style type="text/css">
			main{
				padding-top : 100px;
				z-index : 2;
			}
	
			header {
				/* background-image : url('/Dong-Dong/images/util/main.jpg');
				background-repeat : no-repeat;
				background-size : cover; */
				margin : 0;
				padding : 0;
				position : fixed;
				top : 0;
				left : 0;
				right : 0;
				z-index : 1;
				text-align : center;
				height : 80px;
				background-color : skyblue;
			}
		</style>
	</head>
	<body>
		<header>
			<jsp:include page = "common/top.jsp" flush="true" /><br>
		</header>
		
		<main>
			<jsp:include page = "post/postWrite.jsp" flush="true" />
		</main>
</body>
</html>