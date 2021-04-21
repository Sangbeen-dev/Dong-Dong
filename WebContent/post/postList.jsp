<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.PostDTO"%>
<%@page import="java.util.List"%>
<a href="PostWriteUIServlet">글쓰기</a>


 <%
 	List<PostDTO> list = (List<PostDTO>)request.getAttribute("postList");
	for(int i=1;i<=list.size();i++){
		PostDTO dto = list.get(i-1);
		String pTitle = dto.getpTitle();
		String pContent = dto.getpContent();
		int pPrice = dto.getpPrice();
		String pImage = dto.getpImage();
		String pDate = dto.getpDate();
		String addr = dto.getAddr();
		int pNum = dto.getpNum();

		%>


<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.6.5/jquery.timeago.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.6.5/locales/jquery.timeago.ko.js"></script> -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

</script>





	<!--  var page = -1; // ajax로 날려 back단에서 select시 limit옵션을 걸기 위해
	var temp = false; // 데이터가 없을때 계속적으로 ajax호출이 되는것을 방지하기 위해
	var type = "type1"; // ajax로 날려 back단에서 확인할 type

	$(document).ready(function(){
		$(window).scroll(function(){ // 스크롤의 변화를 감지
			var scrollT = $(this).scrollTop(); // 스크롤바의 상단위치
			var scrollH = $(this).height(); // 해당 div의 높이
			var contentH = $(".p-index").height(); // 문서 전체의 내용을 갖는 div의 높이
			if(scrollT + scrollH +1 >= contentH && !temp) { // 스크롤이 아래쪽에 위치할때 
				page++; 
				select_list();
			}
		});
	});

	function select_list() {
		$.ajax({
			url: './InfiniteServelet',
			type: 'POST',
			dataType: 'JSON',
			data: {type:type, page:page},
			success : function(data){
				if(data.length > 0 ){
					$.each(data, function (idx, val){
						html = '<li> </li>'
					});
                    // 해당하는 만큼 li를 만들어서 #list 뒤에 붙임
					$("#list").append(html);
				}else{
                	// 더이상 조회할 데이터가 없을 시 temp를 true로 만들어 더이상의 ajax호출을 막음.
					temp = true;
				}
			}
		});
	} */ -->

	
		<style type="text/css"> 
a { text-decoration:none } 
</style>

<a href="PostDetailServlet?pNum=<%=pNum %>">
<div style=" background-color: white; padding:30px; width: auto; height: auto; cursor: pointer;">
<td><img src="/Dong-Dong/images/<%=pImage %>" align="top" width="100" height="100">
		<%=pTitle%>
		<tr>
		<br>
 	 	<td class="Dong"><b><%=addr%></b>
							&nbsp;</td>
							<br>	
		</tr>					
 	 	
 	 		<%=pDate%> <br>	
 	 	
 	 	<img src="/Dong-Dong/images/util/favorite.png" align="right" width="30" height="30">	
 	 		</div>
 	 			<br>
 	 			
          <%=pPrice%><br>


<hr>
</div>
 </body> 
</html>     



<%
    }//end for
%>

