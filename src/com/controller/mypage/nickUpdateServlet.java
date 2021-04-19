package com.controller.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class nickUpdateServlet
 */
@WebServlet("/nickUpdateServlet")
public class nickUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		//System.out.println(dto); 
		String nextPage =null;
		if(dto != null) {
			nextPage = "okNick.jsp";
			String userid = dto.getUserid();
			String nickName = request.getParameter("nickName");
			MemberService service = new MemberService();
			MemberDTO dto2 = new MemberDTO();
			dto2.setUserid(userid);
			dto2.setNickName(nickName);
			int n = service.nickUpdate(dto2);
			request.setAttribute("okNick", n);
			request.setAttribute("nickDto", dto2);
		}else{
			nextPage= "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
