<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.PostDTO"%>
<%@page import="java.util.List"%>

<a href="PostWriteUIServlet">글쓰기</a>




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
		
		
		int pDateDiff = Integer.parseInt(dto.getpDateDiff());
		String pDateResult = null;
		if ((pDateDiff / 1440) >= 1){
		
			pDateResult =(pDateDiff / 1440)+ "일전";
			 
			
		 }	
		else if
			(pDateDiff / 60 >= 23){
			
			
			pDateResult =(pDateDiff / 60 )+ "시간전";
			
		}
			else if
			(pDateDiff >= 1) {
			
				pDateResult = (pDateDiff )+ "분전";
				
			}
			else{
				
				pDateResult = "방금";
				
			}
		 
	
		%>


<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.6.5/jquery.timeago.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.6.5/locales/jquery.timeago.ko.js"></script> -->
<!-- <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"> -->


<style type="text/css"> 

a { text-decoration:none } 
</style> 

<a href="PostDetailServlet?pNum=<%=pNum %>">

<div style=" background-color: white; padding:30px; width: auto; height: auto; cursor: pointer;">
<td><img src="/Dong-Dong/images/<%=pImage %>" align="top" width="100" height="100">

		<%=pTitle%>

		<br>
 	 	<b></b>&nbsp;<br> <%=pDateResult%>
 	 	
 	 	<img src="/Dong-Dong/images/util/favorite.png" align="right" width="30" height="30">	
 	 		</div>
 	 			<br>
 	 			
          <%=pPrice%><br>
		

<hr>
</div>
 </body> 
</html>     





<%
    }//end for

%>


