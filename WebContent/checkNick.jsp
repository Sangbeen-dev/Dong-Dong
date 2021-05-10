<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	//닉네임 중복체크 버튼
		$("#nickCheck").click(function() {
			if($("#nickName").val() == ""){
				alert("닉네임을 입력하세요");
				return false;
			};
			if($("#nickName").val().length>=20){
					console.log($("nickName").text().length);
					alert("닉네임은 20자를 넘어갈 수 없습니다.");
					return false;
			};
		});//end 중복체크클릭
   	
 });//end ready
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
<form action="confirmNickServlet">
<!-- <form action="#"> -->
<h3>닉네임 변경하기</h3>
닉네임을 입력하세요: <input type="text" value="" id="nickName" name="nickName">
<button id=nickCheck>중복체크</button>
</form>
</body>
</html>