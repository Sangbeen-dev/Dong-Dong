<%@page import="java.util.List"%>
<%@page import="com.dto.CommentsDTO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	MemberDTO dto = (MemberDTO)session.getAttribute("login");
	String pNum = (String)request.getAttribute("pNum");
    List<CommentsDTO> comments = (List<CommentsDTO>)request.getAttribute("comments");
%>

<!-- Bootstrap css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- Bootstrap js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<style type="text/css">
#comments_div{
	text-align : left;
}
.comment form{
	display: none;
}
#profileImage{
	vertical-align: middle;
}
.comment{
	margin-right: 100px;
}
</style>


<script type="text/javascript">
<%if(dto!=null) {%>
	$(document).ready(function() {
		$(".update_comment").on("click", function() {
			$(this).parent().parent().parent().find(".comment-update-form").toggle(100);
			if($(this).parent().parent().parent().find(".comment-reply-form").attr("style")=="display: block;"){
				$(this).parent().parent().parent().find(".comment-reply-form").toggle(100);
			}
		});//on
		
		$(".reply_comment").on("click", function() {
			$(this).parent().parent().parent().find(".comment-reply-form").toggle(100);
			if($(this).parent().parent().parent().find(".comment-update-form").attr("style")=="display: block;"){
				$(this).parent().parent().parent().find(".comment-update-form").toggle(100);
			}
		});//on
		
		$("form").on("submit",function(event){
			var cContent = $(this).find("textarea").val();

			if(cContent.length == 0){
				alert("댓글을 입력하세요.");
				$(this).find("textarea").focus();
				event.preventDefault();	
			}  
		});
	});
<%}%>
</script>
    <!-- 댓글 기능 표시 시작 지점 --------------------------------------- -->
    <% if(comments==null){ %>
    	댓글 없음....
   	<%} else { %> 
    <div id="comments_div">
      <%for(CommentsDTO cDTO : comments) {%>
      	<%if(cDTO.getcLevel()==1) {%>
      		<div class="comment my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px; margin-left: 100px">
      	<%} else {%>
      		<div class="comment my-3 p-3 alert-secondary rounded shadow-sm" style="padding-top: 10px; margin-left: <%=100*cDTO.getcLevel()%>px">
      	<%} %>
      			<dl>
      				<dt>
      					<img id="profileImage" class="img-fluid rounded mb-4 mb-lg-0" src="/Dong-Dong/images/profile/<%=cDTO.getUserimage()%>" width="70px" height="">
      					작성자 : <%=cDTO.getNickName()%>
      					<span>
      						<%if(cDTO.getUpdateDate()==null){%>
      							<%=(cDTO.getCreateDate()).substring(0, cDTO.getCreateDate().length()-3) %>
      						<%} else {%>
      							<%=(cDTO.getUpdateDate()).substring(0, cDTO.getCreateDate().length()-3) %>(수정됨)
      						<%} %>
      					</span>
      					<%if(dto!=null) {%>
      						<a href="javascript:" class="reply_comment" id="<%=cDTO.getcNum()%>">답글</a>&nbsp;&nbsp;
      						<%if(cDTO.getUserid().equals(dto.getUserid())) {%>
      							<a href="javascript:" class="update_comment" id="<%=cDTO.getcNum()%>">수정</a>&nbsp;&nbsp;
      							<a href="CommentsDeleteServlet?pNum=<%=pNum%>&cNum=<%=cDTO.getcNum()%>">삭제</a>
      						<%} %>
      					<%} %>
      				</dt>
      				<dd>
      					
      					<h3>
      						<%=cDTO.getcContent() %>
      					</h3>
      				</dd>
      			</dl>
      			<form class="comment-reply-form" action="CommentsWriteServlet" method="post">
      				<input type="hidden" name="pNum" value="<%=pNum%>"/>
      				<input type="hidden" name="parentNum" value="<%=cDTO.getcNum()%>"/>
      	  			<textarea rows="3" cols="30" name="cContent"></textarea>
      	  			<input type="submit" value="답글"/>
      			</form>
      			<%if(dto!=null && dto.getUserid().equals(cDTO.getUserid())) %>
      			<form class="comment-update-form" action="CommentsUpdateServlet" method="post">
      				<input type="hidden" name="pNum" value="<%=pNum%>"/>
      				<input type="hidden" name="cNum" value="<%=cDTO.getcNum()%>"/>
      	  			<textarea rows="3" cols="30" name="cContent"></textarea>
      	  			<input type="submit" value="수정"/>
      			</form>
      		</div>
      <%}%>
    </div>
    <%} %>
    <%if(dto==null) {%>
    	<a href="LoginUIServlet">로그인 후 댓글 작성이 가능합니다.</a><br>
    <%} else  {%>
    <div>
      <div class="comment-form">
      	<form action="CommentsWriteServlet" method="post">
      	  <input type="hidden" name="pNum" value="<%=pNum%>"/>
      	  <textarea rows="3" cols="30" name="cContent"></textarea>
      	  <input type="submit" value="댓글달기"/>
      	</form>
      </div>
    </div>
    <%} %>

    