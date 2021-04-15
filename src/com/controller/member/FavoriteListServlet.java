package com.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.FavoriteDTO;
import com.dto.MemberDTO;
import com.service.FavoriteService;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/FavoriteListServlet")
public class FavoriteListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		if(dto!=null) {
			String userid = dto.getUserid();
			//System.out.println(userid);
			FavoriteService service = new FavoriteService();
			List<FavoriteDTO> list = service.favoriteList(userid);
			//System.out.println(list); 
			request.setAttribute("favoriteList", list);
			nextPage = "favoriteList.jsp";
			
		}else {
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}//end do get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
