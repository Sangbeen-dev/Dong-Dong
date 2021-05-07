package com.controller.search;

import java.io.IOException;
import java.util.HashMap;
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
		HashMap<String,String> categoryMap = new HashMap<>();
		categoryMap.put("D","디지털, 가전");
		categoryMap.put("H","가구, 인테리어");
		categoryMap.put("BY","유아동");
		categoryMap.put("L","생활, 가공식품");
		categoryMap.put("S","스포츠, 레저");
		categoryMap.put("W","여성의류, 여성잡화");
		categoryMap.put("M","남성의류, 남성잡화");
		categoryMap.put("G","게임, 취미");
		categoryMap.put("BT","뷰티, 미용");
		categoryMap.put("PET","반려동물용품");
		categoryMap.put("BK","도서");
		categoryMap.put("T","티켓");
		categoryMap.put("P","식물");
		categoryMap.put("E","기타");
		request.setAttribute("postList", list);
		request.setAttribute("category", category);
		request.setAttribute("categoryMap", categoryMap);
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
