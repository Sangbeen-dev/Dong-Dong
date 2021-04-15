package com.controller.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ADDR = request.getParameter("ADDR");
		if(ADDR==null) {
			ADDR = "top";
		}
		PostService service = new PostService();
		List<PostDTO> list = service.PostList(ADDR);
		
		
		request.setAttribute("PostList", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
