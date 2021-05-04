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
 $("form").submit(function(){
		 
		 var oPrice = $("#oPrice").val();
		 var oAddr = $("#oAddr").val(); 
		 
		 if(oPrice.length ==0){
			 alert("희망가격을 입력하세요")
			 $("#oPrice").focus();
			 return false;
		 }
		 if(oAddr.length ==0){
			 alert("희망 장소를 입력하세요");
			 $("#oAddr").focus();
			 return false;
		 }
		 
	 }) //form end
	
	 
})

</script>

<body>
<form action= "/OrderSheetAddServlet">
	<input type = "hidden" name ="bUserid"value ="<%=bUserid %>">
	<input type = "hidden" name ="sUserid"value ="<%=sUserid %>">
	<input type = "hidden" name ="pNum"value ="<%=pNum %>">
	희망 가격<br>
	<input type = "text" name = "oPrice" id = "oPrice" value = "<%=pPrice %>"><br>
	
	희망 거래장소<br>
	<input type = "text" name = "oAddr" id = "oAddr"><br>
	
	전달하고 싶은 내용<br>
	<input type = "text" name = "oMessage" id = "oMessage" placeholder="거래 날짜, 방법 등"><br>
	
	<input type = "submit" value = "전송">
</form>
</body>