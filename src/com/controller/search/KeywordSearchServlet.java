package com.controller.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.controller.post.PostWriteServlet;
import com.dto.PageDTO;
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
		HttpSession session = request.getSession();
		String curPage = request.getParameter("curPage");
		String keyword = request.getParameter("keyword");
		if(curPage == null) {
			curPage = "1";
		}
		PostService service = new PostService();
		PageDTO pDTO = service.searchByKeyword(Integer.parseInt(curPage),keyword);
		
		logr.info("Search_keyWord : {}", keyword);
		
		request.setAttribute("postList",pDTO.getList());
		request.setAttribute("keyword", keyword);
		request.setAttribute("perPage", pDTO.getPerPage());
		request.setAttribute("offset", pDTO.getOffset());
		request.setAttribute("curPage",curPage);
		request.setAttribute("totalPage",pDTO.getTotalCount()/pDTO.getPerPage());
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
