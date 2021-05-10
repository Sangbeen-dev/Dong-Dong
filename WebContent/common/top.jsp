<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<head>
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
				$("#main").click(function() {
					location.href="main";
				})
				
				$("#back").on("click", function() {
					location.href ="main";
				});
				
				$("#search").on("click", function(){
					location.href="CategorySearchUIServlet";
				});
				
			    $("#keyword").keydown(function(e) {
				    if (e.keyCode == 13) {
				        $('form').submit();
				    }
				});
			});
	</script>
	<!-- Bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" 
		integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<style type="text/css">
		#imgBox {
			padding : 0;
		}
		
		#main{
			margin-top : 10px;
		}
		
		#keyword, #search, #user_section{
			margin-top:20px;
		}
		
	</style>
</head>
<body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

<div class="row">
	<div class="col-md-3" id="logo">
		<img id="main" src="/Dong-Dong/images/util/DongDonglogo.png" width="222" height="52" style="cursor: pointer;"/><br><br>
		<!-- 원래 값 : width="222" height="52" -->
	</div>

	<div class="col-md-5" id="search_bar">
		<form action="KeywordSearchServlet" method="get">	
    		<input type="text" name="keyword" id="keyword" class="form-control" placeholder="검색할 상품명">
		</form>
	</div>
	<div class="col-md-1" id="imgBox">
		<img src="/Dong-Dong/images/util/search_category.png" id="search" width="110" height="30" style="cursor: pointer; ">
	</div>

<%
 MemberDTO dto =(MemberDTO)session.getAttribute("login");
%>
	<div class="col-md-3">
		<div id="user_section">
<%
	if(dto !=null){ //회원인 경우
%>	
	
	안녕하세요. 
		<a href="LogoutServlet">로그아웃</a>
		<a href="MyPageServlet">mypage</a><!--수정  -->
		<a href="PostWriteUIServlet">글쓰기</a>
	
<%
	} else{ //아닌경우
%>
		<a href="LoginUIServlet">로그인</a>
		<a href="MemberAddUIServlet">회원가입</a><!--MVC 패턴 -->
<%
	}//end if~else
%>
	</div>
	</div>

</div>

</body>