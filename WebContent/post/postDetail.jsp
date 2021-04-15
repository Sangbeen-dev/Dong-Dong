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
%>

유저 아이디 <%=userid%><br>
유저 이름 <%=username%><br>
상품 번호 <%=pNum%><br>
상품 주소 <%=addr %><br>
상품 카테고리 <%=pCategory%><br>
상품명 <%=pTitle%><br>
게시글 내용 <%=pContent%><br>
상품 가격 <%=pPrice%><br>
상품 이미지 <br>
<img src="images/items/<%=pImage%>.gif"><br>
상품 Hit 수<%=pHit%><br>
상품 등록 시간 <%=pDate%><br>

<br>
<% if(dto==null)  {%>
	<a href="">구매시 로그인이 필요합니다.</a><br>
<%} else if(userid.equals(dto.getUserid())) { %>
	<a href="PostUpdateUIServlet?pNum=<%=pNum%>">상품 정보 수정</a><br>
	<a href="PostDeleteServlet?pNum=<%=pNum%>">상품 삭제</a>
<% } else  {%>
	<a href="">상품 구매</a><br>
<%} %>