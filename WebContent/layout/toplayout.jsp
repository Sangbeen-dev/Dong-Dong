<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
/* .container {
	padding-top : 40px;
} */
/* #menu3:active{
	background-color: #CFF4FC;
} */
</style>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
//toggle 대상요소를 숨기거나 보여주는 효과를 번갈아 함
$(function() {
	$("#menu5").click(function() {
		$("#hiddenmenu").toggle("slow");
	}); // 메뉴 토글
	
	$("#menu2").click(function() {
		$("#menu1").css("background-color","white");
		$("#menu2").css("background-color","#CFF4FC");
		
	});
	$("menu3").click(function() {
		$("menu3").removeClass("active");    
		   $(this).parent().addClass("active");
	})
	

	
	
	//#CFF4FC
})
</script>	
	<div class="container">
		<div class="row">
			
			<div class="col-lg-2">

				<h3 class="my-4 text-center">MyPage</h3>
				<div class="list-group mb-4">
						<a id="menu1" href="mypage.jsp"
						class="list-group-item list-group-item-info text-center font-weight-bold border border-dark">
						회원정보</a>
						<a id="menu2" href="FavoriteListServlet"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						관심목록</a>
						<a id="menu3" href="MyPostListServlet"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						내 게시물 보기</a>
						<a id="menu4" href="OrdersheetList"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						주문 요청함 보기</a>
						<a id="menu5" href="#"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						거래내역</a>
						
						<div id="hiddenmenu" style="display:none;">
						<a id="menu5-1" href="TransactionListServlet"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						▶구매내역</a>
						<a id="menu5-2" href="TransactionListServlet"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						▶판매내역</a>
						</div><!--hiddenmenu  -->
						
						<a id="menu6" href="withdrawal.jsp"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						회원탈퇴</a>	
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-10 my-4 mb-4">