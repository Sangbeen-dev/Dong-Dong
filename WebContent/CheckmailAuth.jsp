<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 체크를 만들어야 합니다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
		$("button").click(function() {
			var authnum = $("#Authnum").val();
			var mailAuth = "인증완료"
			
			if ( authnum != "인증완료") {
				alert("인증 실패");
				event.preventDefault();	
				
				window.close(); 
			}else {
				alert("인증되었습니다.")
				opener.$("#result4").text(mailAuth); 
				window.close(); 
			}
		});
 });
</script>
</head>
<body>

<h4><input id="Authnum" type="text" placeholder="인증번호 입력"></input></h4>
<button>확인</button>


</body>
</html>