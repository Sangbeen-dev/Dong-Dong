<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		
		//닉네임 중복체크 버튼시 이동할 페이지와 자식창 크기 조정 함수
		function confirmNick() {
			// 자식창 중앙 정렬
			var popupWidth = 500;
			var popupHeight = 200;
			//오류 주의...
			var popupX = (window.screen.width / 2) - (popupWidth / 2);
			// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼줌
			var popupY= (window.screen.height / 2) - (popupHeight / 2);
			// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼줌
			url = "checkNick.jsp"
			open(url,"confirm", 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
			}
		//닉네임 체크 
		$("#nickCheck").click(function() {
			confirmNick();
		})
		
		//메일 선택
		$("#emailSelect").change(function() {
			$("#email2").val(this.value);
		})
		
		
		
			
 });//end ready
 
 function readURL(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				$("#thumbnail").attr('src', e.target.result);
				$("#thumbnail").attr('height', '100');
				$("#thumbnail").attr('width', '100');
				
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
    
<%
  //session에서 "login"으로 데이터 뽑기
  MemberDTO dto = (MemberDTO)session.getAttribute("login");
	String nickName = dto.getNickName();
  //System.out.print(dto);

%>
<button id="favorite">관심목록</button>&nbsp;<button id="transaction" >거래내역</button> &nbsp;
<br><br><br>
<form id="myForm" action="#" method="post" enctype="multipart/form-data"> 
<!--프로필 이미지 -->
<input type="hidden" value="<%= dto.getUserImage() %>" name="basic_photo">
<img id="thumbnail" src="/Dong-Dong/images/profile/<%= dto.getUserImage() %>" width="100" height="100" /><br>
	프로필사진 바꾸기 : 
<!-- input type file의 accept  : 파일 창이 열릴때 이미지파일만 보이도록 해준다. -->
<input type="file" id="photo" name="photo"  accept="image/gif,image/jpg,image/png,image/jpeg"
		onchange="readURL(this);"><br>
	
	
<input type="hidden" value="<%= dto.getUsername() %>" name="username">
*이름:<%= dto.getUsername() %><br>
<input type="hidden" value="<%= dto.getUserid() %>" name="userid">
*아이디: <%= dto.getUserid() %><br>

*닉네임: <span id="resultNick"><%= dto.getNickName() %></span>
<%-- <input type="text" value="<%= dto.getNickName() %>" id="nickName" name="nickName"> --%>
<button id="nickCheck">닉네임 변경하기</button>
<br>


<br> 


주소:<input type="text" value="<%= dto.getAddr() %>" name="addr" id="addr" placeholder="주소입력">
<span id="guide" style="color:#999"></span>
<br>
전화번호:<input type="text" value="<%= dto.getPhone() %>" name="phone" id="phone" placeholder="번호">

<br>
이메일:<input type="text" value="<%= dto.getEmail1() %>" name="email1" id="email1">@
       <input type="text" value="<%= dto.getEmail2() %>" id="email2" name="email2" id="email2" placeholder="직접입력">
       <select  id="emailSelect">
        <option value="daum.net">daum.net</option>
        <option value="naver.com">naver.com</option>
        <option value="gmail.com">gmail.com</option>
        <option value="hanmail.net">hanmail.net</option>
       </select>
<br>
<input id="submit" type="submit" value="수정">
<input type="reset" value="취소">
</form>
