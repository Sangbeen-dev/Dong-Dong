<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="PostWriteServlet" method="post">
	<input type="text" id="title" name="title" placeholder="상품명을 포함한 글 제목"><br>
	사진 첨부 : 
	<input type="file" id="image" name="image"><br>
	<textarea id="content" name="content"
		placeholder="자세한 상품설명과 거래방법을 명시하세요" cols="30" rows="30"></textarea><br>
	<input type="text" id="price" name="price" placeholder="상품가격"><br>
	<input type="submit" value="글쓰기">
	<input type="reset" value="다시입력">
</form>