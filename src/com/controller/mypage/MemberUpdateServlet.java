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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		
		String nextPage= null;
		if(dto != null) {
			request.setCharacterEncoding("UTF-8");
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			String username = request.getParameter("username");
			String nickName = request.getParameter("nickName");
			String addr = request.getParameter("addr");
			String phone = request.getParameter("phone");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String userImage = request.getParameter("userImage");
			MemberDTO dto2 =
					new MemberDTO(userid,passwd,username,nickName,
							addr,phone,email1,email2,userImage);
			//System.out.println("서블릿===="+dto2);
			//update실행
			MemberService service = new MemberService();
			int num = service.memberUpdate(dto2);
			//세션에 mesg '회원정보가 수정되었습니다.' 저장
			session.setAttribute("mesg", "회원정보가 수정되었습니다.");
			nextPage="main"; //MainServlet => db => top => main.jsp goodsList.jsp에서 출력
		} else {
			nextPage = "LoginUIServlet";
			request.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		RequestDispatcher dis = 
				request.getRequestDispatcher(nextPage);
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
