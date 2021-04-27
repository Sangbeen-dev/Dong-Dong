<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--부트스트랩 css cdn  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<style>
/* .form-control {
  width: 50%;
  
} */
</style>
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
		//내 게시물 보기 버튼
		$("#mypost").on("click", function() {
			location.href ="MyPostListServlet";
		});
		// 수정 정보 보내기
		$("#submit").click(function() {
			$("#myForm").attr("action","MemberUpdateServlet");		
		})
		//회원탈퇴 버튼
		$("#withdrawal").on("click", function() {
			location.href ="WithdrawalServlet";
		})
		//동네인증 클릭시 이동할 페이지와 자식창 크기 조정 함수
		function addrcheck() {
			// 자식창 중앙 정렬
			var popupWidth = 500;
			var popupHeight = 500;
			//오류 주의...
			var popupX = (window.screen.width / 2) - (popupWidth / 2);
			// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼줌
			var popupY= (window.screen.height / 2) - (popupHeight / 2);
			// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼줌
			url = "addrcheck.jsp"
			open(url,"addrcheck", 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
			}
		//동네 인증
		$("#addrcheck").click(function() {
			addrcheck();
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
  MemberDTO dto = (MemberDTO)session.getAttribute("login");
  String nickName = dto.getNickName();
  System.out.print(dto.getUserimage());

%>
<button type="button" class="btn btn-outline-primary" id="mypost" >내가 쓴 글 보기</button> &nbsp;
<button type="button" class="btn btn-outline-success" id="favorite">관심목록</button>&nbsp;
<button type="button" class="btn btn-outline-danger" id="transaction" >거래내역</button> &nbsp;
<button type="button" class="btn btn-outline-success" id="addrcheck" >우리동네 인증하기</button> &nbsp;
<br><br><br>
<form id="myForm" action="#" method="post" enctype="multipart/form-data"> 
  <div class="container">
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
            <h2>회원정보</h2>
        </div>
<!--프로필 이미지 -->
<input type="hidden" value="<%= dto.getUserimage() %>" name="basic_photo">

<img  id="thumbnail" src="/Dong-Dong/images/profile/<%= dto.getUserimage() %>" width="100" height="100" align="center"/><br>
	프로필사진 바꾸기 : 
<!-- input type file의 accept  : 파일 창이 열릴때 이미지파일만 보이도록 해준다. -->
<input type="file" id="photo" name="photo"  accept="image/gif,image/jpg,image/png,image/jpeg"
		onchange="readURL(this);"><br>
	
 <div class="mb-3">
<%-- <input type="hidden" value="<%= dto.getUsername() %>" name="username"> --%>
	<label for="username">이름 (Name)</label>
 	<input type="text" class="form-control" name="username" value="<%= dto.getUsername() %>" readonly>
</div>

<div class="mb-3">
<%-- <input type="hidden" value="<%= dto.getUserid() %>" name="userid" > --%>
	<label for="userId">아이디 (Id)</label>
 	<input type="text" class="form-control" name="userid" value="<%= dto.getUserid() %>" readonly>
</div>

<div class="mb-3">
	<label for="resultNick">닉네임 (nickName)</label>
 	<input type="text" class="form-control" id="resultNick" name="resultNick" value="<%= dto.getNickName() %>" readonly>
	<button id="nickCheck">닉네임 변경하기</button>
</div>

<div class="mb-3">
<label for="addr">주소 (address)</label>
 <input type="text" class="form-control" id="addr" name="addr" value="<%= dto.getAddr() %>">
<!-- <span id="guide" style="color:#999"></span> -->
</div>

<div class="mb-3">
<label for="phone">전화번호 (phone)</label>
 <input type="text" class="form-control" id="phone" name="phone" value="<%= dto.getPhone() %>">
</div>

<div display="inline-block" >
<label for="email1">이메일 (email)</label><br>
 <%-- <input display="block" type="text" class="form-control" id="email1" name="email1" value="<%= dto.getEmail1() %>">@
 <input display="block" type="text" class="form-control" id="email2" name="email2" value="<%= dto.getEmail2() %>"> --%>
 <input display="block" type="text"  id="email1" name="email1" value="<%= dto.getEmail1() %>">@
 <input display="block" type="text"  id="email2" name="email2" value="<%= dto.getEmail2() %>">

<%-- 이메일:<input type="text" value="<%= dto.getEmail1() %>" name="email1" id="email1">@
       <input type="text" value="<%= dto.getEmail2() %>" id="email2" name="email2"  placeholder="직접입력"> --%>
       <select id="emailSelect">
        <option value="daum.net">daum.net</option>
        <option value="naver.com">naver.com</option>
        <option value="gmail.com">gmail.com</option>
        <option value="hanmail.net">hanmail.net</option>
       </select>
</div>
<div class="mb-3">
	<button id="submit" type="submit" class="btn btn-info">수정</button>
	<button type="reset" class="btn btn-danger" >취소</button>
	<button type="button" class="btn btn-outline-danger" id="withdrawal" style="float: right;">회원탈퇴</button> &nbsp;
</div>



</div>
</form>


