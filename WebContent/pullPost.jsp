<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String pPull = (String)request.getAttribute("pPull");

System.out.print(pPull);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript">
    		$(document).ready(function(){
    			/* //닉네임 중복체크 버튼
				$("#nickCheck").click(function() {
					if($("#nickName").val() == ""){
						alert("닉네임을 입력하세요");
						return false;
					};
					if($("#nickName").val().length>=20){
						console.log($("nickName").text().length);
						alert("닉네임이 너무 길어요");
						return false;
					};
				});//end 중복체크클릭
   	 */
 			});//end ready
		</script>    
		<style type="text/css">

		</style>
	</head>
	<body>
		현재 남아있는 끌올 횟수 : <%=pPull%><br>
		
	</body>
</html>