<%@page import="com.dto.PostDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PostDTO dto = (PostDTO)request.getAttribute("post");
%>
<form action="PostUpdateServlet" method="post">
	<input type="hidden" id="pNum" name="pNum" value="<%=dto.getpNum()%>">
	<input type="text" id="pTitle" name="pTitle" placeholder="상품명을 포함한 글 제목" value="<%=dto.getpTitle()%>"><br>
	사진 첨부 : 
	<input type="file" id="pImage" name="pImage" accept="image/jpeg,image/gif,image/png"><br>
	<textarea id="pContent" name="pContent"
		placeholder="자세한 상품설명과 거래방법을 명시하세요" cols="30" rows="30"><%= dto.getpContent() %></textarea><br>
	<input type="text" id="pPrice" name="pPrice" placeholder="상품가격" value="<%=dto.getpPrice()%>"><br>
	<input type="submit" value="글 수정하기">
</form>