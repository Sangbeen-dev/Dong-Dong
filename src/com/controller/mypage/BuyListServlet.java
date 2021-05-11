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
import com.dto.SaleDTO;
import com.service.TransactionService;

/**
 * Servlet implementation class TransactionListServlet
 */
@WebServlet("/BuyListServlet")
public class BuyListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		if(dto!=null) {
			String userid = dto.getUserid();
			System.out.println(userid);
			//구매내역
			TransactionService service = new TransactionService();
			List<PostDTO> plist = service.purchaseList(userid);
			//System.out.println("구매내역(서블릿)===="+plist); 
			request.setAttribute("purchaseList", plist);
			//판매내역 
			List<PostDTO> slist = service.saleList(userid);
			//System.out.println("판매내역(서블릿)===="+slist); 
			request.setAttribute("saleList", slist);
			
			nextPage = "BuyList.jsp";
			
		}else {
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}//end get

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
