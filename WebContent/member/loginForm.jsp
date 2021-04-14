<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type = "text/javascript">
$(function(){
 $("form").submit(function(){
		 
		 var userid = $("#userid").val();
		 var passwd = $("#passwd").val(); 
		 
		 if(userid.length ==0){
			 alert("아이디를 입력하세요")
			 $("#userid").focus();
			 return false;
		 }
		 if(passwd.length ==0){
			 alert("비밀번호를 입력하세요");
			 $("#passwd").focus();
			 return false;
		 }
	 })
})

</script>
    
<form action="LoginServlet" method="get">
아이디:<input type="text" name="userid" id="userid"><br>
비밀번호:<input type="text" name="passwd" id="passwd"><br> 
<input type="submit" value="로그인"><br>

<a href = "MemberIdSearchUIServlet">아이디 찾기</a><br>
<a href = "">비밀번호 찾기</a>
</form>
