<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="PostWriteServlet" method="post">
	<input type="text" id="title" name="title" placeholder="상품명을 포함한 글 제목"><br>
	<textarea id="content" name="content"
		placeholder="자세한 상품설명과 거래방법을 명시하세요" cols="50" rows="50"></textarea><br>
	<input type="text" id="price" name="price" placeholder="상품가격"><br>
	<input type="submit" value="글쓰기">
	<input type="reset" value="다시입력">
</form>