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
import com.service.FavoriteService;
import com.service.OrderSheetService;

/**
 * Servlet implementation class FavoriteDelServlet
 */
@WebServlet("/myOrderDelServlet")
public class myOrderDelServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage=null;
		if(dto!=null) {
			int num = Integer.parseInt(request.getParameter("oNum"));
			String popup = request.getParameter("popup");
			OrderSheetService service = new OrderSheetService();
			int n = service.orderDel(num);
			if(popup == null) {
				nextPage ="MyOrdersheetList";
			}else {
				nextPage ="popupclose.jsp";
			}
		}else {
			nextPage = "LoginUISevlet";
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
