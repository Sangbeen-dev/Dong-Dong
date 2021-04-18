<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.PostDTO"%>
<%@page import="java.util.List"%>
<a href="PostWriteUIServlet">글쓰기</a>
<a href="">

 <%
 	List<PostDTO> list = (List<PostDTO>)request.getAttribute("postList");
	for(int i=1;i<=list.size();i++){
		PostDTO dto = list.get(i-1);
		String pTitle = dto.getpTitle();
		String pContent = dto.getpContent();
		int pPrice = dto.getpPrice();
		String pImage = dto.getpImage();
		String pDate = dto.getpDate();
		String addr = dto.getAddr();
		int pNum = dto.getpNum();
		%>
		
		
		
		
            
 <hr>
  
 <td>
	<table style='padding:15px'>
		<tr>
			<td>
	<a href="PostDetailServlet?pNum=<%=pNum %>">
 	<img src="/Dong-Dong/images/<%=pImage %>" align="top" width="100" height="100">
 	<br>
 	<%=pTitle%>			
 	 	<br><%=addr%>
 		<br> <%= pPrice%>
         <br> <%= pDate %>
        <br>
        <br>
        <%=pContent%> 
		<tr>
		
		</table>
<%
    }//end for
%>
