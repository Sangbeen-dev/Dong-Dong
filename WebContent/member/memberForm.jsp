<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">

$(document).ready(function(){
//form 서브밋 - 아이디 중복( 닉네임 중복), 비밀번호 불일치
$("form").on("submit",function(event){
	console.log("aaa");
 var userid = $("#userid").val();
 var passwd = $("#passwd").val();
 var passwd2 = $("#passwd2").val();
 var nickName = $("#nickName").val();
 var result = $("#result").text();
 var resul3t = $("#result3").text();
 		if(nickName.length==0){
			alert("nickName 필수입니다.")
			$("#nickName").focus();
			event.preventDefault();	
			
 		}if(result3 != "닉네임 사용가능"){
			alert("닉네임 중복되었습니다.")
 			$("#nickName").focus();
 			event.preventDefault();		
		
 		}if(userid.length==0){
 			alert("userid 필수")
 			$("#userid").focus();
 			event.preventDefault();		
			
 		}if(result != "아이디 사용 가능"){
			alert("아이디가 중복되었습니다.")
 			$("#userid").focus();
 			event.preventDefault();		
		
		} if(passwd.length==0){
			alert("passwd 필수")
			$("#passwd").focus();
			event.preventDefault();
		
		} if(passwd!=passwd2){
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
// 아이디 중복되는경우 회원가입하면 500Error
// 중복일떄 500이 아니라 , 이벤트를 막아야지 
 
 
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
				event.preventDefault();
		}
	});
});



	function maileAuth() {
		// 자식창 중앙 정렬
		var popupWidth = 500;
		var popupHeight = 200;
		//오류 주의...
		var popupX = (window.screen.width / 2) - (popupWidth / 2);
		// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼줌
		var popupY= (window.screen.height / 2) - (popupHeight / 2);
		// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼줌
		url = "emailAuth.jsp"
		open(url,"confirm", 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
		}
	//닉네임 체크 
	$("#mailAuth").click(function() {
		maileAuth();
	})

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
전화번호 : <input type="text" name="phone" id = "phone" >
<br>
주소 : <input type="text" name="addr" id="sample4_roadAddress" placeholder="주소입력">
<span id="guide" style="color:#999"></span>
<br>
이메일 : <input type="text" name="email1" >@
       <input type="text" name="email2"  placeholder="직접입력">
<!--        <select>
        <option value="daum.net">daum.net</option>
        <option value="naver.com">naver.com</option>
       </select> -->
	<button type="button" id="mailAuth">메일 인증</button>
       
<br>
<input type="submit" value="회원가입">
<input type="reset" value="취소">
</form>



