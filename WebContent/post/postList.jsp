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
<<<<<<< HEAD
		%>	
	  
=======
%>
         
>>>>>>> a732563051c31e4eb6fb5e2dc1cffa066c9436d5
 <hr>
  
 <td>
	<table style='padding:30px'>
		<tr>
			<td>
<<<<<<< HEAD
	<a href="PostDetailServlet?pNum=<%=pNum %>">
 	<img src="images/items/<%=pImage %>.gif" align="top"><%=pTitle%>
 					
 	 	<tr>
 	 	<td class="Dong"><b><%=addr%></b>
							&nbsp;</td>
		</tr>					
 	 	
 	 		<%=pDate%> <br>	
 	 	
 	 		<td>
 	 			<br>
 	 			
          <%=pPrice%><br>
        <td>
        <%=pContent%> <br>
		<td>
=======
				<a href="PostDetailServlet?pNum=<%=pNum %>"></a>
 				<img src="/Dong-Dong/images/<%=pImage %>" align="top" width="100" height="100">
 				<img src="/Dong-Dong/images/items/<%=pImage %>.gif" align="top">
 				<br>
 				<%=pTitle%>			
 	 			<br><%=addr%>
 				<br> <%= pPrice%>
         		<br> <%= pDate %>
        		<br>
        		<br>
        		<%=pContent%> 
			</td>
		<tr>
>>>>>>> a732563051c31e4eb6fb5e2dc1cffa066c9436d5
		
		</table>
<%
    }//end for
%>

