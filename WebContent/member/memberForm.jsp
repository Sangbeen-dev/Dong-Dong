<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
//form 서브밋 - 아이디 중복( 닉네임 중복), 비밀번호 불일치
$("form").on("submit",function(event){
 var userid = $("#userid").val();
 var passwd = $("#passwd").val();
 var nickName = $("#nickName").val();
 
 		if(nickName.length==0){
			alert("nickName 필수입니다.")
			$("#nickName").focus();
			event.preventDefault();	
			
 		}else if(userid.length==0){
 			alert("userid 필수")
 			$("#userid").focus();
 			event.preventDefault();		
			
 		}else if(passwd.length==0){
			alert("passwd 필수")
			$("#passwd").focus();
			event.preventDefault();
		
		}else if(passwd!=passwd2){
			alert("비밀번호가 일치하지 않습니다.")
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


//id체크 
 $("#userid").on("keyup",function(event){
	 $.ajax({
			type : "GET",
			url : "MemberIdCheckServlet",
			dataType : "text",
 			data : {
				userid : $("#userid").val()
			}, 
			success : function(responseData, status, xhr) {
			    console.log(responseData);
				$("#result").text(responseData);
			},
			error : function(xhr, status, error) {
				console.log("error");
			}
		});
});
 
//nickName체크 
 $("#nickName").on("keyup",function(event){
	 $.ajax({
			type : "GET",
			url : "MembernickNameCheckServlet",
			dataType : "text",
 			data : {
				nickName : $("#nickName").val()
			}, 
			success : function(responseData, status, xhr) {
			    console.log(responseData);
				$("#result3").text(responseData);
			},
			error : function(xhr, status, error) {
				console.log("error");
		}
	});
});

}); //end doc
 
</script>    
<form action="MemberAddServlet" method="get">
*닉네임 : <input type="text" name="nickName" id="nickName" placeholder="닉네임 입력"><span id="result3"></span>
<br>
*아이디 : <input type="text" name="userid" id="userid" placeholder="아이디 입력"><span id="result"></span>
<br>
*비밀번호 : <input type="text" name="passwd" id="passwd" placeholder="비밀번호 입력">
<br>
비빌번호확인 : <input type="text" name="passwd2" id="passwd2"><span id="result2"></span>
<br>
이름 : <input type="text" name="username" placeholder="이름"><br> 
전화번호 : <input type="text" name="phone" >
<br>
주소 : <input type="text" name="addr" id="sample4_roadAddress" placeholder="주소입력">
<span id="guide" style="color:#999"></span>
<br>
이메일 : <input type="text" name="email1" >@
       <input type="text" name="email2"  placeholder="직접입력">
       <select>
        <option value="daum.net">daum.net</option>
        <option value="naver.com">naver.com</option>
       </select>
<br>
<input type="submit" value="회원가입">
<input type="reset" value="취소">
</form>

