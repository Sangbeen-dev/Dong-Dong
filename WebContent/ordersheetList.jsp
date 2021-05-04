<%@page import="com.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../layout/toplayout.jsp" flush="true"></jsp:include>
<!--부트스트랩 css cdn  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
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
			//주문서 개별삭제 서블릿으로 변경해야함
			//location.href="PostDeleteServlet?pNum="+num; 
		});//end delBtn
		
	
		//체크한 게시글 삭제
		$("#delAllpost").click(function() {
			var num = [];
			$(".check:checked").each(function(idx, data) {
				num[idx] = $(this).val();
			});
			//주문서 all삭제 서블릿으로 변경해야함
			//location.href="PostDelAllServlet?data="+num; 
		});//end delAllpost 
		
		
	})//end ready
	
</script>
<style>



</style>


<div class="container">

<table class="table table-hover" >

	<thead>
		<tr>
			<th scope="col" class="text-center" >
			<input type="checkbox" name="allCheck" id="allCheck">전체선택</th>
			<th scope="col"  class="text-center">상품번호</th>
			<th scope="col" class="text-center">상품정보</th><!--pImage 랑 pTitle 같이 출력  -->
			<th scope="col" class="text-center">메세지</th><!--pHit  -->
			<th scope="col" class="text-center">제시가격</th>
			<th scope="col" class="text-center">작성일</th><!--pDate  -->
			<th scope="col" class="text-center"></th>
		</tr>
	</thead>
	<tbody>
	<%
	List<PostDTO> list =(List<PostDTO>)request.getAttribute("mypostList");
	for(int i=0; i<list.size(); i++){
		PostDTO dto = list.get(i);
		String pCategory = dto.getpCategory();
		String pContent = dto.getpContent();
		int pHit = dto.getpHit();
		String pImage = dto.getpImage();
		int pNum = dto.getpNum();
		int pPrice = dto.getpPrice();
		String pDate = dto.getpDate();
		String pTitle = dto.getpTitle();
		String userid = dto.getUserid();
	%>
	<tr>
		<td style="width: 10%;" class="text-center" width="1"><input type="checkbox"
			name="check" id="check" class="check"  value="<%-- <%= oNum %> --%>"></td><!--주문서번호  -->
		<td class="text-center" width="1"><%= pNum %></td><!--상품번호  -->	
		<td class="text-center" width="120"><a
			href="PostDetailServlet?pNum=<%= pNum%>"><!--메세지 띄울꺼로 수정해야함  -->
				 <img src="/Dong-Dong/images/<%= pImage %>"
				border="0"  width="80" /></a>
				<div>
				<%= pTitle %>
				<font size="2" color="#665b5f">[분류 :<%= pCategory %>]</font>
				</div></td>
		<td class="text-center" width="20"><%-- <%= oMessage %> --%></td><!--채팅메세지  -->	<!--미리보기 조금만  -->	
		<td class="text-center" width="80"><%-- <%= oPrice %> --%></td><!--제시가격  -->
		<td class="text-center" width="40"><%-- <%= oDate %> --%></td><!--주문서 보낸 날짜  -->
		
		
		<td class="text-center" align="center" width="30"
			style='padding-left: 10px'>
			<input type="button" value="삭제" id="xx<%=i %>" class="delBtn" data-xxx="<%-- <%= oNum %> --%>"><!--주문서 삭제시 오더번호로  -->
		</td>
		
	</tr>
	<%
	} 
	%>
	<hr>
	</tbody>
	<tr class="button">
		<td colspan="3" >
			<a class="text-center" href="#" id="delAllpost"> 주문서 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="main"> 계속 둘러보기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	
</table>
</div> <!--컨테이너  -->
<jsp:include page="../layout/bottomLayout.jsp" flush="true"></jsp:include>


