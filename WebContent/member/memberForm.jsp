<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//form 서브밋
$("form").on("submit",function(event){		
 var userid = $("#userid").val();
 var passwd = $("#passwd").val();
		if(userid.length==0){
			alert("userid 필수")
			$("#userid").focus();
			event.preventDefault();
		}else if(passwd.length==0){
			alert("passwd 필수")
			$("#passwd").focus();
			event.preventDefault();
		}
	});
//비번확인
$("#passwd2").on("keyup",function(){
	var passwd = $("#passwd").val();
	var mesg = "비번 불일치";
	if(passwd == $(this).val()){
		mesg = "비번 일치";
	}
	$("#result2").text(mesg);
});

//이메일 선택


 }); 
 
</script>    
<form action="MemberAddServlet" method="get">
*아이디:<input type="text" name="userid" id="userid"><br>
<span id="result"></span>

*비밀번호:<input type="text" name="passwd" id="passwd"><br>
비빌번호확인:<input type="text" name="passwd2" id="passwd2">
<span id="result2"></span>

<br>
이름:<input type="text" name="username"><br>
닉네임:<input type="text" name="nickName"><br>

<br>
<input type="text" name="addr" placeholder="주소">
<br>

전화번호:<input type="text" name="phone" >

<br>
이메일:<input type="text" name="email1" >@
       <input type="text" name="email2"  placeholder="직접입력">
       <select>
        <option value="daum.net">daum.net</option>
        <option value="naver.com">naver.com</option>
       </select>
<br>
<input type="submit" value="회원가입">
<input type="reset" value="취소">
</form>

