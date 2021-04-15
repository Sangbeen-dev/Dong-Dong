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
		%>
		
		
		
		
            
 <hr>
  
 <br>
 	<div id="top">
 	<img src="images/items/<%=pImage %>.gif">
 	<p><%=pTitle%></p>
 	</div>
 	 <%=pDate%>
 	 <%=addr%>
 		<br> <%= pPrice%>
         
        <br>
        <br>
        <%=pContent%> 

<%
    }//end for
%>
