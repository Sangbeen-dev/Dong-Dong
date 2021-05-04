<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int pPull = Integer.parseInt((String)request.getAttribute("pPull"));
String pDate = (String)request.getAttribute("pDate");
String pullAvailable = (String)request.getAttribute("pullAvailable");
int calDateDay = Integer.parseInt((String)request.getAttribute("calDateDay"));
String pNum = (String)request.getAttribute("pNum");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript">
    		$(document).ready(function(){
    			var pullA = "<%=pullAvailable%>";
    			var pPull = <%=pPull%>;
    			if(pullA == "T"){
					if(pPull == 3){
    					var formSubmit = document.getElementById("pullT");
    					formSubmit.onclick = function(){
    						document.pullForm.target = opener.name;
    						document.pullForm.submit();
    						self.close();
    					}
					} else {
						var formSubmit = document.getElementById("pullT");
		    			formSubmit.onclick = function(){
		    				document.pullForm.target = opener.name;
		    				document.pullForm.submit();
		    				self.close();
		    			}
					}
    			} else {
    				if(pPull == 0){
    					var write = document.getElementById("pullFWrite");
    					write.onclick = function(){
    						document.pullF.target = opener.name;
    	    				document.pullF.submit();
    						self.close();
    					}
    				}
    			}
    			
 			});//end ready
		</script>    
		<style type="text/css">
			
		</style>
	</head>
	<body>
		<%
			if(pullAvailable.equals("T")){
				if(pPull == 3){
		%>
					<!-- 끌올 가능(끌올 한번도 안해본사람) -->
					<form action="PostPullServlet" name="pullForm">
					<input type="hidden" value="<%=pNum %>" name="pNum">
					끌올 기능은 <b>3일 간격 3회</b>로 제한됩니다.<br>
					<br>
					현재 해당 글에대한 끌올 가능 횟수는 <%=pPull %>회 입니다.<br>
					<input type="button" id = "pullT" value="끌올하기">
					<button onclick="window.close()">취소</button>
					</form>
		<%
				} else {
		%>
					<!-- 끌올 가능(끌올 해본사람) -->
					<form action="PostPullServlet">
					<input type="hidden" value="<%=pNum %>" name="pNum">
					끌올 기능은 <b>3일 간격 3회</b>로 제한됩니다.<br>
					<br>
					현재 해당 글에대한 끌올 가능 횟수는 <%=pPull %>회 입니다.<br>
					최근 끌올 날짜 : <%= pDate %>(<%=calDateDay %>일전)<br>
					<input type="submit" value="끌올하기">
					<button onclick="window.close()">취소</button>
					</form>
		<%
				}
			} else {
				if(pPull > 0){
		%>
					<!-- 끌올 불가능(끌올 횟수는 남았으나 끌올한지 얼마안된경우) -->
					끌올 기능은 <b>3일 간격 3회</b>로 제한됩니다.<br>
					<br>
					최근 끌올 날짜 : <%= pDate %>(<%=calDateDay %>일전)<br>
					끌올기능을 사용한지 3일이 지나지않아 끌올이 <b>불가능</b>합니다!<br>
					<button onclick="window.close()">확인</button>
		<%
				} else {
		%>
					<!-- 끌올 불가능(끌올 횟수가 안남음) -->
					끌올 기능은 <b>3일 간격 3회</b>로 제한됩니다.<br>
					<br>
					해당 글에대한 끌올 횟수를 모두 사용하셨습니다.<br>
					<br>
					새로 글을 작성하고 싶으시다면 글쓰기 버튼을 클릭해주세요<br>
					<form action="PostWriteUIServlet" name="pullF">
					<input type="button" id="pullFWrite" value="글쓰기">
					<button id="pullFCancel" onclick="window.close()">확인</button>
					</form>
		<%
				}
			}
		%>
	</body>
</html>