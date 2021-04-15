<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%
   String mesg = (String)request.getAttribute("mesg");
  if(mesg!=null){
%>    
   <script>
     alert('<%=mesg %>');
   </script>
<%
  }
%>    
<form action="MemberPWSearchServlet" method="get">
  이름<input type="text" name="username"><br>
  아이디<input type="text" name="userid"><br>
 휴대폰    <input type="text" name="phone"><br>
이메일<input type="text"  name="email1">@
     <input type="text"  name="email2" id="email2" placeholder="직접 입력">
   <input type="submit" value="메일 보내기">  
</form>

