package com.controller.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.MemberService;
import com.service.PostService;

/**
 * Servlet implementation class addrCheckServlet
 */
@WebServlet("/addrCheckServlet")
public class addrCheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		
		if(dto!=null) {
			String userid = dto.getUserid();
			String userName = dto.getUsername();
			String addr = request.getParameter("dong");
			//System.out.println("주소"+addr);
			MemberDTO dto2 = new MemberDTO();
			dto2.setUsername(userName);
			dto2.setUserid(userid);
			dto2.setAddr(addr);
			MemberService service = new MemberService();
			int n = service.addrAuth1(dto2);//db에저장된 주소랑 같은지 확인
			if(n==1) {
				request.setAttribute("auth1", addr);
			}else {
				 n = service.addrAuth2(dto2);//현재위치로 주소 변경
				request.setAttribute("auth2", addr);
			}
			nextPage = "addrauth.jsp";
			
			
		}else {
			nextPage = "LoginUIServlet";
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
