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
			});
	</script>
	<!-- Bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" 
		integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

	<style type="text/css">
		*{
			text-align : center;
		}
	</style>
</head>
<body>
<!-- 메뉴 부분 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<form action="KewordSearchServlet" method="get">
		<div class="row">
			<div class="col-md-1 col-sm-1"></div>
			<div class="mb-3 col-md-8 col-sm-8">			
    			<input type="text" name="keyWorld" id="keyword" class="form-control"
    				placeholder="검색할 상품명">
			</div>
			<div class="col-md-2 col-sm-2">
				<!-- 돋보기 아이콘 넣고 파일 이름 수정하기  -->
				<img src="/Dong-Dong/images/util/search_icon.jpg" id="search_icon">
			</div>
			<div class="col-md-1 col-sm-1"></div>
		</div>
	</form>
</body>