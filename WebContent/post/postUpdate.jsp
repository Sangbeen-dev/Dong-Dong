<%@page import="com.dto.PostDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript">
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
	PostDTO dto = (PostDTO)request.getAttribute("post");
%>
<form action="PostUpdateServlet" method="post" enctype="multipart/form-data">
	<input type="hidden" id="pNum" name="pNum" value="<%=dto.getpNum()%>">
	<input type="text" id="pTitle" name="pTitle" placeholder="상품명을 포함한 글 제목" value="<%=dto.getpTitle()%>"><br>
	<img id="thumbnail"  height="100" width="100" src="/Dong-Dong/images/<%=dto.getpImage()%>"/><br>
	사진 첨부 : 
	<!-- input type file의 accept  : 파일 창이 열릴때 이미지파일만 보이도록 해준다. -->
	<input type="file" id="photo" name="photo" accept="image/gif,image/jpg,image/png,image/jpeg"
			onchange="readURL(this);"/><br>
			
	<textarea id="pContent" name="pContent"
		placeholder="자세한 상품설명과 거래방법을 명시하세요" cols="30" rows="30"><%= dto.getpContent() %></textarea><br>
	<input type="text" id="pPrice" name="pPrice" placeholder="상품가격" value="<%=dto.getpPrice()%>"><br>
	<input type="submit" value="글 수정하기">
</form>