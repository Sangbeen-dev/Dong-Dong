<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloJsp 테스트 </title>
</head>
<body>
<%
String mesg= (String)request.getAttribute("request");
String mesg2= (String)session.getAttribute("session");
String mesg3= (String)application.getAttribute("application");
%>
request: <%= request.getAttribute("request") %><br>
session: <%= session.getAttribute("session") %><br>
application: <%= application.getAttribute("application") %><br>
<hr border="2">
1>> <%= mesg %>
2>> <%=mesg2 %>
3>> <%=mesg3 %>

</body>
</html>