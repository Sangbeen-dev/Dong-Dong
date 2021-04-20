<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
</script>


<form action="../PostWriteServlet" method="post" enctype="multipart/form-data" runat="server">
	<input type="text" id="title" name="title" placeholder="상품명을 포함한 글 제목"><br>
	<select name="category">
		<option value="D">[Digital]디지털,가전,게임</option>
		<option value="L">[Living]가구,인테리어,생활,가공식품,반려동물</option>
		<option value="F">[Fashion]여성의류,남성의류,잡화</option>
		<option value="C">[Culture]도서,티켓,음반,스포츠,레저</option>
		<option value="E">[ETC]기타,뷰티,미용,식물</option>
	</select><br>
	
	<img id="thumbnail" src="/Dong-Dong/images/util/thumbnail.PNG"  /><br>
	사진 첨부 : 
	<!-- input type file의 accept  : 파일 창이 열릴때 이미지파일만 보이도록 해준다. -->
	<input type="file" id="photo" name="photo" accept="image/gif,image/jpg,image/png,image/jpeg"
			onchange="readURL(this);"><br>
	
	<textarea id="content" name="content"
		placeholder="자세한 상품설명과 거래방법을 명시하세요" cols="30" rows="30"></textarea><br>
	<input type="text" id="price" name="price" placeholder="상품가격"><br>
	<input type="submit" value="글쓰기">
	<input type="reset" value="다시입력">
</form>