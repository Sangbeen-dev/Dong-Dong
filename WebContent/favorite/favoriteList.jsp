<%@page import="com.dto.FavoriteDTO"%>
<%@page import="com.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//전체 체크
		$("#allCheck").click(function() {
			var result = this.checked;
			var num = [];
			$(".check").each(function(idx, data) {
				//this.checked = result;
				data.checked = result;
			});
		});//end allCheck
		
		//개별 삭제
		$(".delBtn").on("click", function() {
			var num = $(this).attr("data-xxx");
			location.href="FavoriteDelServlet?num="+num; 
		});//end delBtn
		
		//체크한 관심목록 삭제
		$("#delAllfavorite").click(function() {
			var num = [];
			$(".check:checked").each(function(idx, data) {
				num[idx] = $(this).val();
			});
			console.log(num);
			location.href="FavoriteDelAllServlet?data="+num;
		});//end delAllCart
		
		
	})//end ready
	
</script>

<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>-관심목록-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
	 	<td class="td_default" align="center"> 
		<input type="checkbox" name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>Hit</strong></td>
		<td class="td_default" align="center" colspan="1"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	
	
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>


	<form name="myForm" >	    
<%  
   //데이터 가져오기 //for문 작성 
	List<FavoriteDTO> list = (List<FavoriteDTO>)request.getAttribute("favoriteList");
	for(int i=0; i<list.size(); i++){
		FavoriteDTO dto = list.get(i);
		String pCategory = dto.getpCategory();
		String pContent = dto.getpContent();
		int pHit = dto.getpHIt();
		String pImage = dto.getpImage();
		int pNum = dto.getpNum();
		int pPrice = dto.getpPrice();
		String pTitle = dto.getpTitle();
		String userid = dto.getUserId();

%>	    
	  		

		<tr>
			<td class="td_default" width="80"> 
			<input type="checkbox"
				name="check" id="check" class="check" value="<%= pNum %>"></td>
			<td class="td_default" width="80"><%= pHit %></td>
			<td class="td_default" width="80"><%= pNum %></td>
			<td class="td_default" width="80">
			<a href="PostDetailServlet?pNum=<%= pNum%>"><%--여기 해당상품 이동될 페이지  --%>
			<img src="images/items/<%= pImage %>.jpg" border="0" align="center"
				width="80" /></td>
			<td class="td_default" width="300" style='padding-left: 30px'><%= pTitle %>
			
			<br> <font size="2" color="#665b5f">[분류 :<%= pCategory %>] </font></td>
			<td class="td_default" align="center" width="100"><%= pPrice %>
			</td>
			<td class="td_default" align="center" width="30"
				style='padding-left: 10px'>
				<input type="button" value="삭제" id="xx<%=i %>"
				class="delBtn" data-xxx="<%=pNum %>"></td><!--data-xxx 사용자 정의 속성  -->
			<td height="10"></td>

		</tr>
<%
	}//end for
%>


	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>
	<tr>
		<td align="center" colspan="5"><a class="a_black" href="#"
			class="a_black" href="#" id="delAllCart"> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="main"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>
</table> 
    