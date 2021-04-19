<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	MemberDTO dto = (MemberDTO)session.getAttribute("login");

	String userid = (String)request.getAttribute("userid");
 	String username = (String)request.getAttribute("username");
  	String pNum = (String)request.getAttribute("pNum");
	String addr = (String)request.getAttribute("addr");
	String pCategory = (String)request.getAttribute("pCategory");
	String pTitle = (String)request.getAttribute("pTitle");
	String pContent = (String)request.getAttribute("pContent");
	String pPrice = (String)request.getAttribute("pPrice");
	String pImage = (String)request.getAttribute("pImage");
	String pHit = (String)request.getAttribute("pHit");
	String pDate = (String)request.getAttribute("pDate");
	boolean favorite = (boolean)request.getAttribute("favorite");
	
%>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<%if(dto!=null) {%>
	$(function() {
		$("#favorite").on("click", function(){
			$.ajax({
				type: "get",
				url: "FavorateSwitchServlet",
				data: {
					userid: <%=dto.getUserid()%>,
					pNum: <%=pNum%>,
					favorite : <%=favorite%>
				}, //data
				dataType: "text",
				success: function(data, status, xhr) {
					//$("#result").text(data);
					// 결과를 받아서 favorite 변수 변경 / 화면에 반옇
				}, //success
				error: function(xhr, status, error) {
					$("#result").append(error);
					$("#result").append(status);
				} //error
			});//ajax
		});//on
	});//ready()
<%}%>
</script>



유저 아이디 <%=userid%><br>
유저 이름 <%=username%><br>
상품 번호 <%=pNum%><br>
상품 주소 <%=addr %><br>
상품 카테고리 <%=pCategory%><br>
상품명 <%=pTitle%><br>
게시글 내용 <%=pContent%><br>
상품 가격 <%=pPrice%><br>
상품 이미지 <br>
<img src="/Dong-Dong/images/<%=pImage%>" width="100" height="100"><br>
상품 Hit 수<%=pHit%><br>
상품 등록 시간 <%=pDate%><br>

<br>
<% if(dto==null)  {%>
	<a href="">구매시 로그인이 필요합니다.</a><br>
<%} else if(userid.equals(dto.getUserid())) { %>
	<a href="PostUpdateUIServlet?pNum=<%=pNum%>">상품 정보 수정</a><br>
	<a href="PostDeleteServlet?pNum=<%=pNum%>">상품 삭제</a>
<% } else  {%>
	<button id="favorite" value="">좋아요 버튼 : <%=favorite %></button><br>
	<a href="">상품 구매</a><br>
<%} %>

<%-- <form name="postDetailForm" method="GET" >
	    <input type="hidden" name="pImage" value="<%=pImage%>"> <input
		type="hidden" name="pTitle" value="<%=pTitle%>"> <input
		type="hidden" name="pPrice" value="<%=pPrice%>">

	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>
		<tr>
			<td>
				<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
					<tr>
						<td class="td_default"><font size="5"><b>- 상품 정보 -</b></font>
							&nbsp;</td>
					</tr>
					<tr>
						<td height="5"></td>
					</tr>
					<tr>
						<td height="1" colspan="8" bgcolor="CECECE"></td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>

					<tr>
						<td rowspan="7"><img src="images/items/<%=pImage %>.gif"
							border="0" align="center" width="300" /></td>
						<td class="td_title">카테고리</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>
						 <%= pCategory %>
						</td>
					</tr>
					<tr>
						<td class="td_title">글제목</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'><%= pTitle %></td>
					</tr>
					<tr>
						<td class="td_title">가격</td>

						<td class="td_red" colspan="2" style='padding-left: 30px'>
						<%= pPrice %>
						</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>


	<br> <button>구매</button>
		 <button>채팅하기</button>
		 <br>
	&nbsp;&nbsp;
	<button id="favorite">찜하기</button>
</form> --%>
    