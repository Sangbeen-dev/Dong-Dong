<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
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
<!-- Bootstrap js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<form action="../PostWriteServlet" method="post" enctype="multipart/form-data">
		<!-- <input type="text" id="title" name="title" placeholder="상품명을 포함한 글 제목"> -->
		<div class="row" >
			<div class="col-md-3 col-sm-2"></div>
			<div class="mb-3 col-md-6 col-sm-8">
    			<input type="text" name="title" id="title" class="form-control"
    				aria-describedby="emailHelp" placeholder="상품명을 포함한 글 제목">
  			</div>
  			<div class="col-md-3 col-sm-2"></div>
  		</div>
  		
  		<div class="row">
  			<div class="col-md-3 col-sm-2"></div>
			<div class="col-md-6 col-sm-8 mb-3">
				<select class="form-select" aria-label="Default select example" name="category">
  					<option selected>카테고리 선택</option>
  					<option value="D">[Digital]: 디지털, 가전, 게임</option>
					<option value="L">[Living]: 가구, 인테리어, 생활, 가공식품, 반려동물 용품</option>
					<option value="F">[Fashion]: 여성의류, 남성의류, 잡화</option>
					<option value="C">[Culture]: 도서, 티켓, 음반, 스포츠, 레저</option>
					<option value="E">[ETC] : 기타, 뷰티, 미용,식물</option>
				</select>
			</div>
  			<div class="col-md-3 col-sm-2"></div>
  		</div>
  		
		
		<br>
		
		<img id="thumbnail" src="/Dong-Dong/images/util/thumbnail.PNG"  /><br>
	
 		<div class="row">
 			<div class="col-md-3 col-sm-2"></div>
			<div class="mb-3 col-md-6 col-sm-8">
  				<label for="formFile" class="form-label">판매할 상품 사진</label>
  				<input class="form-control" type="file" id="photo" name="photo" 
  					accept="image/gif,image/jpg,image/png,image/jpeg" onchange="readURL(this);">
			</div>
			<div class="col-md-3 col-sm-2"></div>
		</div>
		<!-- <textarea id="content" name="content"
			placeholder="자세한 상품설명과 거래방법을 명시하세요" cols="30" rows="30"></textarea><br>
			 -->
			 
		<div class="row">
 			<div class="col-md-3 col-sm-2"></div>
			<div class="mb-3 col-md-6 col-sm-8">
  				<textarea class="form-control" name="content" rows="10"
  					placeholder="자세한 상품 설명과 거래 방법을 작성하세요"></textarea>
			</div>
			<div class="col-md-3 col-sm-2"></div>
		</div>	
			
		<!-- <input type="text" id="price" name="price" placeholder="상품가격"><br>
		 -->
		 <div class="row">
 			<div class="col-md-3 col-sm-2"></div>
			<div class="mb-3 col-md-6 col-sm-8">
    			<input type="text" name="price" id="price" class="form-control"
    				aria-describedby="price" placeholder="상품가격">
  			</div>
  			<div class="col-md-3 col-sm-2"></div>
  		</div>
  		
		<input type="submit" value="글쓰기" class="btn btn-outline-info">
		<input type="reset" value="다시입력" class="btn btn-outline-info">
		<button type="button" id="back" class="btn btn-outline-info">돌아가기</button>
	</form>
</body>