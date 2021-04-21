<%@page import="com.dto.PostDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript">
		function readURL(input){
			if(input.files && input.files[0]){
				var reader = new FileReader();
				reader.onload = function(e){
					$("#thumbnail").attr('src', e.target.result);
					$("#thumbnail").attr('height', '100');
					$("#thumbnail").attr('width', '100');
					
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		$(document).ready(function(){
			$("#back").on("click", function() {
				location.href ="PostDetailServlet?pNum="+$("#pNum").val();
			});
		});
</script>
<%
	PostDTO dto = (PostDTO)request.getAttribute("post");
%>
	<!-- Bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" 
		integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

	<style type="text/css">
	*{
		text-align : center;
	}
	</style>
	
	<!-- Bootstrap js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<form action="PostUpdateServlet" method="post" enctype="multipart/form-data">
		<input type="hidden" id="pNum" name="pNum" value="<%=dto.getpNum()%>">
		 <div class="mb-3">
    		<input type="text" name="pTitle" id="pTitle" class="form-control"
    			aria-describedby="emailHelp" placeholder="상품명을 포함한 글 제목" value="<%=dto.getpTitle()%>">
  		</div>

		<select class="form-select" aria-label="Default select example" id="pCategory" name="pCategory">
  			<option selected>카테고리 선택</option>
  			<option value="D">[Digital]</option>
			<option value="L">[Living]</option>
			<option value="F">[Fashion]</option>
			<option value="C">[Culture]</option>
			<option value="E">[ETC]</option>
		</select>
		
		<button class="btn btn-outline-info btn-sm" type="button" data-bs-toggle="collapse" 
			data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
    		카테고리 알아보기
  		</button>
  		
		<div class="collapse" id="collapseExample" style="background-color:red">
  			<div class="card card-body">
    			[Digital] : 디지털, 가전, 게임<br>
    			[Living] : 가구, 인테리어, 생활, 가공식품, 반려동물 용품<br>
    			[Fashion] : 여성의류, 남성의류, 잡화<br>
    			[Culture] : 도서, 티켓, 음반, 스포츠, 레저<br>
    			[ETC] : 기타, 뷰티, 미용,식물
  			</div>
		</div><br>
		
		<img id="thumbnail" width="100" height="100" src="/Dong-Dong/images/<%=dto.getpImage()%>" /><br>
			
		<div class="mb-3">
  			<label for="formFile" class="form-label">판매할 상품 사진</label>
  			<input class="form-control" type="file" id="photo" name="photo" 
  				accept="image/gif,image/jpg,image/png,image/jpeg" onchange="readURL(this);">
		</div>		
		
		<div class="mb-3">
  			<textarea class="form-control" id="pContent" name="pContent" rows="10"
  				placeholder="자세한 상품 설명과 거래 방법을 작성하세요"><%= dto.getpContent() %></textarea>
		</div>
			
		<div class="mb-3">
    		<input type="text" name="pPrice" id="pPrice" class="form-control"
    			aria-describedby="price" placeholder="상품가격" value="<%=dto.getpPrice()%>" >
  		</div>
  		
		<input type="submit" value="수정하기" class="btn btn-outline-info">
		<button type="button" id="back" class="btn btn-outline-info">돌아가기</button>
	</form>