<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	MemberDTO dto = (MemberDTO) session.getAttribute("login");
	String bUserid = dto.getUserid();
	String sUserid = (String) request.getParameter("sUserid");
	String pNum = (String) request.getParameter("pNum");
	String pPrice = (String) request.getParameter("pPrice");
%>

<body>
<form action= "OrderSheetAddServlet">
	희망가격<br>
	<input type = "text" name = "oPrice" id = "oPrice" value = "<%=pPrice %>"><br>
	
	전달하고 싶은 내용<br>
	<input type = "text" name = "oMessage" id = "oMessage" placeholder="거래 날짜, 방법 등"><br>
	
	<input type = "submit" value = "전송">
</form>
</body>