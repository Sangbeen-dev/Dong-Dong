package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/MemberIdSearchServlet")
public class MemberIdSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 파싱
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username").trim(); //양쪽 공백제거
		String phone = request.getParameter("phone").trim();
		String email =  request.getParameter("email").trim();
		
		String email1 = email.split("@")[0];
		String email2 = email.split("@")[1];
		
		//service.idSearch(MemberDTO)이용
		MemberDTO dto = new MemberDTO();
		dto.setUsername(username);
		dto.setPhone(phone);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		
		MemberService service = new MemberService();
		String userid = service.idSearch(dto);
		String nextPage = null;
		
		//전화번호, 사용자 이름 일치 여부검사 (mapperid = "idSearch") 후 사용자 id만 select
		if(userid == null) {
			nextPage = "idSearch.jsp";
			request.setAttribute("mesg", "등록되지 않은  회원 정보");
		}else { //일치하는 경우 메일발송
			nextPage="SendMailServlet";
			request.setAttribute("mailTo", email1 + "@" + email2);
			request.setAttribute("userid", userid);
			
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
