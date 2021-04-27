<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
// 여기에 인증 버튼 클릭시에 -> 이메일1,이메일 2를 이메일 처리하는 서블릿으로 넘겨줘야 하는 걸 만들어야함.

 });//end ready -->
</script>    
<style type="text/css">
form {
	text-align: center;
	margin: auto;
	padding: auto;
}

</style>
</head>
<body>
<form action="emailAuthServlet" method="post">
<!-- <form action="#"> -->
<h3> 이메일 인증</h3>
<input type="text" id="email1" name="email1" placeholder="이메일 입력" >@
<input type="text" id="email2" name="email2" >

<button id="eamilAuth">인증하기</button>
</form>
</body>
</html>