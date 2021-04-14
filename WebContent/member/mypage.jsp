<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	//form 서브밋
//id, 패스워드공백확인
//비번확인
//passwd2, passwd일치확인	
//이메일 선택
	//아이디 비번 필수 입력 검사
		$("form").on("submit", function() {
			var userid = $("#userid").val();
			var passwd = $("#passwd").val();
				if(userid.length == 0){
					alert("userid 필수");
					$("#userid").focus();
					event.preventDefault();
				}else if(passwd.length == 0){
					alert("passwd 필수");
					$("#passwd").focus();
					event.preventDefault();
				}//end else if
		});//end submit
		//비밀번호 확인
		$("#passwd2").on("keyup", function() {
			var passwd = $("#passwd").val();
			var passwd2 = $("#passwd2").val();
			var mesg = "비번 불일치";
			if(passwd == passwd2){
				mesg = "비번 일치";
			}
			$("#result2").text(mesg);
		})//end keyup
		//이메일
		$("#emailSelect").on("change", function() {
			var email = $(this).val();
			$("#email2").val(email);
		});//end change
		//아이디 중복 검사
		$("#userid").on("keyup", function() {
			var id = $("#userid").val();
			console.log(id);
			$.ajax({
				type:"get",
				url: "MemberIdCheckServlet",
				dataType: "text",
				data: {
					userid : $("#userid").val() //키는 userid: 입력 id
					},
				success: function(data, status, xhr) {
					console.log("success===", status);
					$("#result1").text(data);
					console.log(mesg);
				},
				error: function(xhr, status, error) {
					console.log("error", error);
					console.log("status", status);
				}
			});//end ajax
		});//end keyup
		
		$("#favorite").on("click", function() {
			location.href ="../FavoriteServlet";
		});
		
 });
</script>    
<%
  //session에서 "login"으로 데이터 뽑기
  //MemberDTO dto = (MemberDTO)session.getAttribute("login");
  //System.out.print(dto);
  
  //아직 다 안들어서 테스트용!
	MemberDTO dto = new MemberDTO();
	dto.setUserid("1");
	dto.setPasswd("1");
	dto.setUsername("1");
	dto.setNickName("1");
	dto.setAddr("1");
	dto.setPhone("1");
	dto.setEmail1("1");
	dto.setEmail2("1");
%>
<button id="favorite">관심목록</button>&nbsp;<a href="../FavoriteServlet">거래내역</a> &nbsp;
<form action="#" method="post">
<input type="hidden" value="<%= dto.getUserid() %>" name="userid">
*아이디: <%= dto.getUserid() %><br>
<!--프로필 이미지  -->
<img src="../images/aaa.jpg" border="0" width="80"/><br>
*이름:<%= dto.getUsername() %>
<br> 
<!-- <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br> -->
주소:<input type="text" value="<%= dto.getAddr() %>" name="addr" id="addr" placeholder="주소입력">
<span id="guide" style="color:#999"></span>
<br>
전화번호:<input type="text" value="<%= dto.getPhone() %>" name="phone" id="phone" placeholder="번호">

<br>
이메일:<input type="text" value="<%= dto.getEmail1() %>" name="email1" id="email1">@
       <input type="text" value="<%= dto.getEmail2() %>" name="email2" id="email2" placeholder="직접입력">
       <select  id="emailSelect">
        <option value="daum.net">daum.net</option>
        <option value="naver.com">naver.com</option>
       </select>
<br>
<input type="submit" value="수정">
<input type="reset" value="취소">
</form>
