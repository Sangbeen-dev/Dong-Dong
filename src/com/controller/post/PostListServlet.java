package com.controller.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.PostDTO;
<<<<<<< HEAD
import com.service.PostService;

=======

import com.service.PostService;
>>>>>>> 6e10932999344827a2a31d15e8d0f7d17b1f5cff

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/PostServlet")
public class PostListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addr = request.getParameter("addr");
		if(addr==null) {
			addr = "top";
		}
		PostService service = new PostService();
<<<<<<< HEAD
		List<PostDTO> list = service.postListByAddr(ADDR);
=======
		List<PostDTO> list = service.postList(addr);
>>>>>>> 6e10932999344827a2a31d15e8d0f7d17b1f5cff
		
		
		request.setAttribute("PostList", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
