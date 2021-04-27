<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
				$("#back").on("click", function() {
					location.href ="main";
				});
			
				$("table tr td").css("cursor","pointer").on("click", function(e){
					var v = $(this).find("input").val();
					console.log(v);
					location.href="CategorySearchServlet?category="+v;
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
	
	<table>
		<tr>
			<td>
				<input type="hidden" value="D">
				<img src="/Dong-Dong/images/util/category_digital.png" width="100" height="100"><br>
				디지털
			</td>
			<td>
				<input type="hidden" value="H">
				<img src="/Dong-Dong/images/util/category_house.png" width="100" height="100"><br>
				가구,인테리어
			</td>
			<td>
				<input type="hidden" value="L">
				<img src="/Dong-Dong/images/util/category_living.png" width="100" height="100"><br>
				생활,가공식품
			</td>
			<td>
				<input type="hidden" value="BY">
				<img src="/Dong-Dong/images/util/category_baby.png" width="100" height="100"><br>
				유아
			</td>
		</tr>
		<tr>
			<td>
				<input type="hidden" value="F">
				<img src="/Dong-Dong/images/util/category_woman.PNG" width="100" height="100"><br>
				여성의류,여성잡화
			</td>
			<td>
				<input type="hidden" value="M">
				<img src="/Dong-Dong/images/util/category_man.PNG" width="100" height="100"><br>
				남성의류,남성잡화
			</td>
			<td>
				<input type="hidden" value="S">
				<img src="/Dong-Dong/images/util/category_sports.png" width="100" height="100"><br>
				스포츠,레저
			</td>
			<td>
				<input type="hidden" value="G">
				<img src="/Dong-Dong/images/util/category_game.png" width="100" height="100"><br>
				게임,취미
			</td>
		</tr>
		<tr>
			<td>
				<input type="hidden" value="PET">
				<img src="/Dong-Dong/images/util/category_pet.png" width="100" height="100"><br>
				반려동물용품
			</td>
			<td>
				<input type="hidden" value="BT">
				<img src="/Dong-Dong/images/util/category_beauty.png" width="100" height="100"><br>
				뷰티,미용
			</td>
			<td>
				<input type="hidden" value="BK">
				<img src="/Dong-Dong/images/util/category_book.png" width="100" height="100"><br>
				도서
			</td>
			<td>
				<input type="hidden" value="T">
				<img src="/Dong-Dong/images/util/category_ticket.png" width="100" height="100"><br>
				티켓
			</td>
		</tr>
		<tr>
			<td>
				<input type="hidden" value="P">
				<img src="/Dong-Dong/images/util/category_plant.png" width="100" height="100"><br>
				식물
			</td>
			<td>
				<input type="hidden" value="E">
				<img src="/Dong-Dong/images/util/category_etc.PNG" width="100" height="100"><br>
				기타
			</td>
		</tr>
	</table>
	

</body>