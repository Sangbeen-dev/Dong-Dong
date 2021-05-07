<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberDTO dto = (MemberDTO)session.getAttribute("login");
 	String pNum = request.getParameter("pNum");
%>

<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript">

$(function() {
	$("#ComplaintPostForm").on("submit", function(event){
		event.preventDefault();
		$.ajax({
			type: "post",
			url: "/ComplaintAcceptServlet",
			data: {
				coTarget: <%=pNum%>,
				userid : <%=dto.getUserid()%>,
				coType : 2,
				coContent : $("#coContent").val()
			}, //data
			dataType: "text",
			success: function(data, status, xhr) {
				if(data=="true"){
					opener.alert("게시글 신고가 완료되었습니다.");
					window.close();
				} else {
					opener.alert("게시글 신고가 실패하였습니다.");
					window.close();
				}//if_else
			}, //success
			error: function(xhr, status, error) {
				$("#result").append(error);
				$("#result").append(status);
			} //error
		});//ajax
	});//on
});//end ready
</script>
<body>
<form id="ComplaintPostForm">
	신고 분류<br>
	<select class="complaint-select" name="category" id="category" >
  					<option value="C">광고/홍보 게시글입니다.</option>
					<option value="L">실제로 판매하지 않는 허위매물입니다.</option>
					<option value="A">부적절한 사진 또는 글내용이 포함되어 있습니다.</option>
					<option value="E">기타</option>
				</select><br>
	세부 신고 내용<br>
	<textarea rows="20" cols="20" name="coContent" id="coContent"></textarea><br>
	<input type = "submit" value = "신고">
</form>
</body>