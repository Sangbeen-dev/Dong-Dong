<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	MemberDTO dto = (MemberDTO)session.getAttribute("login");

	String userid = (String)request.getAttribute("userid");
 	String username = (String)request.getAttribute("username");
  	String pNum = (String)request.getAttribute("pNum");
	String addr = (String)request.getAttribute("addr");
	String pCategory = (String)request.getAttribute("pCategory");
	String pTitle = (String)request.getAttribute("pTitle");
	String pContent = (String)request.getAttribute("pContent");
	String pPrice = (String)request.getAttribute("pPrice");
	String pImage = (String)request.getAttribute("pImage");
	String pHit = (String)request.getAttribute("pHit");
	String pDate = (String)request.getAttribute("pDate");
	boolean favorite = (boolean)request.getAttribute("favorite");
%>

<!-- Bootstrap css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- Bootstrap js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<style type="text/css">
*{
	text-align : center;
}
#mainImgDiv{
	max-height: 700px;
	overflow: hidden;
}
#mainImage{
	max-height: initial;
	margin-top: -10%;
}
</style>


<script type="text/javascript">
	var favorite = <%=favorite%>;
<%if(dto!=null) {%>
	$(function() {
		$("#favorite").on("click", function(){
			$.ajax({
				type: "get",
				url: "FavorateSwitchServlet",
				data: {
					pNum: <%=pNum%>,
					favorite : favorite
				}, //data
				dataType: "text",
				success: function(data, status, xhr) {
					if(data=="true"){
						$("#favoriteImg").attr("src","/Dong-Dong/images/util/favorite1.png");
						favorite = true;
					} else {

						$("#favoriteImg").attr("src","/Dong-Dong/images/util/favorite2.png");
						favorite = false;
					}//if_else
				}, //success
				error: function(xhr, status, error) {
					$("#result").append(error);
					$("#result").append(status);
				} //error
			});//ajax
		});//on
	});//ready()
<%}%>
</script>


<!-- --------------------------------페이지 표시 시작 지점--------------------------------- -->  
<!-- Page Content -->
  <div class="container">

    <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div id="mainImgDiv" class="col-lg-7">
        <img id="mainImage" class="img-fluid rounded mb-4 mb-lg-0" src="/Dong-Dong/images/<%=pImage%>" width="700px" height="">
      </div>
      <!-- /.col-lg-8 -->
      <div class="col-lg-5">
        <br>
        <h1 class="font-weight-light"><%=pTitle%></h1><br>
        <h2 class="font-weight-light"><%=pPrice%>원</h2><br>
        <h6 class="font-weight-light"><%=pDate%></h6>
        
		<table class="table">
		   <tr>
		      <th>유저</th>
		      <td><%=username%></td>
		   </tr>
		   <tr>
		      <th>거래지역</th>
		      <td><%=addr %></td>
		   </tr>
		 </tbody> 
		
		</table>
		<% 	if(dto==null)  {%>
		  <a href="">구매시 로그인이 필요합니다.</a><br>
		<%	} else if(userid.equals(dto.getUserid())) { %>
		  <a class="btn btn-primary" href="PostUpdateUIServlet?pNum=<%=pNum%>">상품 정보 수정</a>
		  <a class="btn btn-primary" href="PostDeleteServlet?pNum=<%=pNum%>">상품 삭제</a>
		<% 	} else  {%>
          <a class="btn btn-primary" href="#">구매? 하기</a>
          <a id="favorite"  class="btn">
		    <%if(favorite==true) {%>
    	    	<img id="favoriteImg" src="/Dong-Dong/images/util/favorite1.png"  width="50" height="50"/>
    	    <% } else {%>
    	    	<img id="favoriteImg" src="/Dong-Dong/images/util/favorite2.png"  width="50" height="50"/>
    	    <% }
		  	%>
		  </a>
		<%} %>
      </div>
      <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->

    <!-- Call to Action Well -->
    <div class="card text-white bg-secondary my-5 py-4 text-center">
      <div class="card-body">
        <p class="text-white m-0"><%=pContent%></p>
      </div>
      <div>
		상품 카테고리 <%=pCategory%>,상품 Hit 수<%=pHit%><br>
      </div>
    </div>
  </div>
  <!-- /.container -->

    