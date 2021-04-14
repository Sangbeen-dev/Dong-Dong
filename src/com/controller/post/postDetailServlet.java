package com.controller.post;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.PostService;

@WebServlet("/postDetailServlet")
public class postDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//String pNum = request.getParameter("pNum");
    	String pNum = "5"; // 테스트 값
    	
    	PostService service = new PostService();
    	
    	HashMap<String, String> map = service.getPostDetailByPNum(Integer.parseInt(pNum));
    	
    	System.out.println(map);
    	// 데이터 파싱 후 페이지 이동
    	
    	RequestDispatcher dis = request.getRequestDispatcher("postDetailPage.jsp");
    	dis.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
