<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
 	String username = (String)request.getAttribute("username");
  	int pNum = Integer.parseInt((String)request.getAttribute("pNum"));
	String pCategory = (String)request.getAttribute("pCategory");
	String pTitle = (String)request.getAttribute("pTitle");
	String pContent = (String)request.getAttribute("pContent");
	int pPrice = Integer.parseInt((String)request.getAttribute("pPrice"));
	String pImage = (String)request.getAttribute("pImage");
	int pHit = Integer.parseInt((String)request.getAttribute("pHit"));
	String pDate = (String)request.getAttribute("pDate");
%>

유저 이름 <%=username%><br>
상품 번호 <%=pNum%><br>
상품 카테고리 <%=pCategory%><br>
상품명 <%=pTitle%><br>
게시글 내용 <%=pContent%><br>
상품 가격 <%=pPrice%><br>
상품 이미지 주소 <%=pImage%><br>
상품 Hit 수<%=pHit%><br>
상품 등록 시간 <%=pDate%><br>
</body>
</html>