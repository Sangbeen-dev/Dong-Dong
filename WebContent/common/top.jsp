<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 MemberDTO dto =(MemberDTO)session.getAttribute("login");
%>   
	<!-- top부분 -->
<%
	if(dto !=null){ //회원인 경우
%>	
	안녕하세요. 
	<a href="LogoutServlet">로그아웃</a>
	<a href="MyPageServlet">mypage</a><!--수정  -->
<%
	} else{ //아닌경우
%>
	<a href="LoginUIServlet">로그인</a>
	<a href="MemberAddUIServlet">회원가입</a><!--MVC 패턴 -->
<%
	}//end if~else
%>