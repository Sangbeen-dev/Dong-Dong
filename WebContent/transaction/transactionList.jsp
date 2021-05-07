<%@page import="com.dto.SaleDTO"%>
<%@page import="com.dto.PurchaseDTO"%>
<%@page import="com.dto.FavoriteDTO"%>
<%@page import="com.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="../layout/toplayout.jsp" flush="true"></jsp:include>
<!--부트스트랩 css cdn  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<style>
table {
	margin: 30px;
}
h2{
	margin: 30px;
}
</style>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		
	})//end ready
	
</script>
<div class="container c1">
<table class="table table-hover" width="90%" cellspacing="0" cellpadding="0" border="0">
	
	<h2>구매내역</h2>
	
	<thead>
		<tr>
			<th scope="col" class="text-center">상품번호</th>
			<th scope="col" class="text-center">상품정보</th><!--pImage 랑 pTitle 같이 출력  -->
			<th scope="col" class="text-center">작성일</th><!--pDate  -->
			<th scope="col" class="text-center">가격</th>
		</tr>
	</thead>
	<tbody>
	
	    
<%  
   //데이터 가져오기 //for문 작성 
	List<PostDTO> plist = (List<PostDTO>)request.getAttribute("purchaseList");
	if(plist != null){
		for(int i=0; i<plist.size(); i++){
			PostDTO dto = plist.get(i);
			String pTitle = dto.getpTitle();
			String pImage = dto.getpImage();
			int pNum = dto.getpNum();
			int pPrice = dto.getpPrice();
			String pCategory = dto.getpCategory();
			String pDate =dto.getpDate();

%>	    
	  	<tr>
		<td class="text-center" width="1"><%= pNum %></td>	
		<td class="text-center" width="120"><a
			href="PostDetailServlet?pNum=<%= pNum%>">
				<%--여기 해당상품 이동될 페이지  --%> <img src="/Dong-Dong/images/<%= pImage %>"
				border="0"  width="80" /></a>
			<!-- 	<div> -->
				<%= pTitle %><br>
				<font size="2" color="#665b5f">[분류 :<%= pCategory %>]</font>
				<!-- </div> --></td>
		<td class="text-center" width="80"><%= pPrice %></td>
		<td class="text-center" width="40"><%= pDate %></td>
	</tr>	

<%
	}//end for
}//end if
%>

</tbody>	
</table>
</div>

<br><br><br><br>

<div class="container">
<!--여기서부터 판매내역  -->
<table id="sale" class="table table-hover" width="90%" cellspacing="0" cellpadding="0" border="0">

<h2>판매내역</h2>

	<thead>
		<tr>
			<th scope="col" class="text-center">상품번호</th>
			<th scope="col" class="text-center">상품정보</th><!--pImage 랑 pTitle 같이 출력  -->
			<th scope="col" class="text-center">작성일</th><!--pDate  -->
			<th scope="col" class="text-center">가격</th>
		</tr>
	</thead>
	<tbody>

<%  
   //데이터 가져오기 //for문 작성 
	List<PostDTO> slist = (List<PostDTO>)request.getAttribute("saleList");
	if(slist != null){
		for(int i=0; i<slist.size(); i++){
			PostDTO dto = slist.get(i);
			String pTitle = dto.getpTitle();
			String pImage = dto.getpImage();
			int pNum = dto.getpNum();
			int pPrice = dto.getpPrice();
			String pCategory = dto.getpCategory();
			String pDate =dto.getpDate();
%>	    
	  		

	<tr>
		<td class="text-center" width="1"><%= pNum %></td>	
		<td class="text-center" width="120"><a
			href="PostDetailServlet?pNum=<%= pNum%>">
				<%--여기 해당상품 이동될 페이지  --%> <img src="/Dong-Dong/images/<%= pImage %>"
				border="0"  width="80" /></a>
				<!-- <div> -->
				<%= pTitle %><br>
				<font size="2" color="#665b5f">[분류 :<%= pCategory %>]</font>
				<!-- </div> --></td>
		
		<td class="text-center" width="40"><%= pDate %></td>
		<td class="text-center" width="80"><%= pPrice %></td>
	</tr>	

<%
	}//end for
}//end if
%>
</tbody>
</table> 
</div>
    