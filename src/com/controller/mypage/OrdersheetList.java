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
import com.dto.OrderSheetDTO;
import com.dto.PostDTO;
import com.service.OrderSheetService;
import com.service.PostService;

/**
 * Servlet implementation class OrdersheetList
 */
@WebServlet("/OrdersheetList")
public class OrdersheetList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		if(dto!=null) {
			String userid = dto.getUserid();
			OrderSheetService service = new OrderSheetService();
			List<MyOrderSheetDTO> list = service.ordersheetList(userid);
			request.setAttribute("ordersheetList", list);
			nextPage = "ordersheetList.jsp";
			
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
