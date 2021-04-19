<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
		//관심목록 버튼
		$("#favorite").on("click", function() {
			location.href ="FavoriteListServlet";
		});
		//거래내역 버튼
		$("#transaction").on("click", function() {
			location.href ="TransactionListServlet";
		});
		// 수정 정보 보내기
		$("#submit").click(function() {
			$("#myForm").attr("action","MemberUpdateServlet");		
		})
		//닉네임 중복체크 버튼
		function confirmNick() {
			if($("#nickName").val() == ""){
				alert("닉네임을 입력하세요");
				return;
			}
		url = "confirmNick?nickName=" + $("#nickName").val();
		open(url,"confirm", "width=50","height=50");
		}
		
		$("#nickCheck").click(function() {
			confirmNick();
		})
			
 });//end ready
</script>    
<%
  //session에서 "login"으로 데이터 뽑기
  MemberDTO dto = (MemberDTO)session.getAttribute("login");
	String nickName = dto.getNickName();
  //System.out.print(dto);
  

	
%>
<button id="favorite">관심목록</button>&nbsp;<button id="transaction" >거래내역</button> &nbsp;
<!-- <form id="myForm" action="MemberUpdateServlet" method="post"> -->
<form id="myForm" action="#" method="post"> 
<input type="hidden" value="<%= dto.getUsername() %>" name="username">
*이름:<%= dto.getUsername() %><br>
<input type="hidden" value="<%= dto.getUserid() %>" name="userid">
*아이디: <%= dto.getUserid() %><br>

*닉네임:<input type="text" value="<%= dto.getNickName() %>" id="nickName" name="nickName">
<button id="nickCheck">닉네임 변경(중복체크)</button>
<br>
<!--프로필 이미지  -->
<img src="/Dong-Dong/images/profile/aaa.jpg" border="0" width="80"/><br>

<br> 


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
<input id="submit" type="submit" value="수정">
<input type="reset" value="취소">
</form>
