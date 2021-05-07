<%@page import="com.dto.PostDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
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
	</style>
</head>
<body>
<!-- 메뉴 부분 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<form action="KeywordSearchServlet" method="get">
		
		<div class="row">
			<div class="col-lg-2 col-md-1 col-sm-1"></div>
			<div class="mb-3 col-lg-7 col-md-9 col-sm-9 col-xs-11" id="keywordBox">			
    			<input type="text" name="keyword" id="keyword" class="form-control" placeholder="검색할 상품명">
			</div>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1" id="imgBox">
				<img src="/Dong-Dong/images/util/search_category.png" id="search" width="110" height="30" style="cursor: pointer; ">
			</div>
			<div class="col-lg-2 col-md-1 col-sm-1"></div>
		</div>
	</form>

</body>