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

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type = "text/javascript">
$(function(){
 $("#close").click(function(){
		 window.close();
	 })
	 
})

</script>

<body>

<h3>주문서가 정상적으로 전송되었습니다.</h3>
<button id = "close">닫기</button>
</body>