<%@page import="com.dto.PostDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String mesg = (String)session.getAttribute("mesg");
  if(mesg!=null){
%>    
   <script>
     alert('<%=mesg %>');
   </script>
<%
  }
  session.removeAttribute("mesg");
%>    
   
<%
  PostDTO dto = (PostDTO)request.getAttribute("postDetail");
	String pTitle = dto.getpTitle();
	String pContent = dto.getpContent();
	int pPrice = dto.getpPrice();
	String pCategory = dto.getpCategory();
	String pImage = dto.getpImage();
	String pDate = dto.getpDate();
	String addr = dto.getAddr();
	int pNum = dto.getpNum();
%>  
<%

 
 %>

<form name="postDetailForm" method="POST">
	    <input type="hidden" name="pImage" value="<%=pImage%>"> <input
		type="hidden" name="pTitle" value="<%=pTitle%>"> <input
		type="hidden" name="pPrice" value="<%=pPrice%>">

	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>
		<tr>
			<td>
				<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
					<tr>
						<td class="td_default"><font size="5"><b>- 상품 정보 -</b></font>
							&nbsp;</td>
					</tr>
					<tr>
						<td height="5"></td>
					</tr>
					<tr>
						<td height="1" colspan="8" bgcolor="CECECE"></td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>

					<tr>
						<td rowspan="7"><img src="images/items/<%=pImage %>.gif"
							border="0" align="center" width="300" /></td>
						<td class="td_title">카테고리</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>
						 <%= pCategory %>
						</td>
					</tr>
					<tr>
						<td class="td_title">글제목</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'><%= pTitle %></td>
					</tr>
					<tr>
						<td class="td_title">가격</td>

						<td class="td_red" colspan="2" style='padding-left: 30px'>
						<%= pPrice %>
						</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>


	<br> <button>구매</button>
		 <button>채팅하기</button>
		 <br>
	&nbsp;&nbsp;
	<button id="favorite">찜하기</button>
</form>
    