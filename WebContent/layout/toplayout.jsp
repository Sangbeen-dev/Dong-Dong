<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>

span {
	font-weight: bold;
}

</style>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
//toggle 대상요소를 숨기거나 보여주는 효과를 번갈아 함
$(function() {
	$("#menu5").click(function() {
		$("#hiddenmenu2").toggle("slow");
	}); // 메뉴 토글
	
	$("#menu4").click(function() {
		$("#hiddenmenu1").toggle("slow");
	});
	
})
</script>	
	<div class="container">
		<div class="row">
			
			<div class="col-lg-2">

				<h3 class="my-4 text-center">MyPage</h3>
				<div class="list-group mb-4">
						<a id="menu1" href="mypage.jsp"
						class="list-group-item list-group-item-info text-center font-weight-bold border border-dark">
						<span>회원정보</span></a>
						<a id="menu2" href="FavoriteListServlet"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						<span>관심목록</span></a>
						<a id="menu3" href="MyPostListServlet"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						<span>내 게시물 보기</span></a>
						<a id="menu4" href="#"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						<span>주문 요청함 보기</span></a>
						
						<div id="hiddenmenu1" style="display:none;">
						<a id="menu4-1" href="MyOrdersheetList"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						▶발신함</a>
						<a id="menu4-2" href="OrdersheetList"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						▶수신함</a>
						</div><!--hiddenmenu  -->
						
						<a id="menu5" href="#"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						<span>거래내역</span></a>
						
						<div id="hiddenmenu2" style="display:none;">
						<a id="menu5-1" href="BuyListServlet"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						▶구매내역</a>
						<a id="menu5-2" href="SaleListServlet"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						▶판매내역</a>
						</div><!--hiddenmenu  -->
						
						<a id="menu6" href="withdrawal.jsp"
						class="list-group-item list-group-item-action text-center font-weight-bold border border-dark">
						<span>회원탈퇴</span></a>	
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-10 my-4 mb-4">