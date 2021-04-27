package com.controller.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.controller.post.PostWriteServlet;
import com.dto.PostDTO;
import com.service.PostService;


@WebServlet("/CategorySearchServlet")
public class CategorySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logr  = LoggerFactory.getLogger(PostWriteServlet.class);

    public CategorySearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = (String)request.getParameter("category");
		
		PostService service = new PostService();
		List<PostDTO> list = service.searchByCategory(category);
		
		logr.info("Search_Category : {}", category);
		
		request.setAttribute("postList", list);
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
