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

@WebServlet("/KeywordSearchServlet")
public class KeywordSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logr  = LoggerFactory.getLogger(PostWriteServlet.class);
    public KeywordSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		PostService service = new PostService();
		List<PostDTO> list = service.searchByKeyword(keyword);
		
		logr.info("Search_keyWord : {}", keyword);
		
		request.setAttribute("postList", list);
		request.setAttribute("keyword", keyword);
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
