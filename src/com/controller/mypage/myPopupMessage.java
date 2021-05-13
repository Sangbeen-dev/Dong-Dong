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
import com.dto.MyOrderSheetDTO;
import com.service.OrderSheetService;
import com.service.TransactionService;

/**
 * Servlet implementation class PopupMessage
 */
@WebServlet("/myPopupMessage")
public class myPopupMessage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		if(dto!=null) {
			String oNum = request.getParameter("oNum");
			//int saleCount = Integer.parseInt(request.getParameter("saleCount"));
			OrderSheetService service = new OrderSheetService();
			List<MyOrderSheetDTO> list = service.message(oNum);
			TransactionService service2 = new TransactionService();
			int saleCount = service2.saleCount(list.get(0).getbUserid());
			request.setAttribute("saleCount", saleCount);
			request.setAttribute("message", list);
			nextPage = "mypopupmessage.jsp";
			
			
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
