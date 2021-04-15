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

@WebServlet("/PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String pNum = request.getParameter("pNum");
    	
    	PostService service = new PostService();
    	
    	HashMap map = service.getPostDetailByPNum(Integer.parseInt(pNum));
    	
    	System.out.println(map);
    	// 데이터 파싱 후 페이지 이동
    	request.setAttribute("pNum", String.valueOf(map.get("PNUM")));
    	request.setAttribute("pCategory", map.get("PCATEGORY"));
    	request.setAttribute("pHit", String.valueOf(map.get("PHIT")));
    	request.setAttribute("pImage", map.get("PIMAGE"));
    	request.setAttribute("pPrice", String.valueOf(map.get("PPRICE")));
    	request.setAttribute("username", map.get("USERNAME"));
    	request.setAttribute("userid", map.get("USERID"));
    	request.setAttribute("addr", map.get("ADDR"));
    	request.setAttribute("pContent", map.get("PCONTENT"));
    	request.setAttribute("pDate", String.valueOf(map.get("PDATE")));
    	request.setAttribute("pTitle", map.get("PTITLE"));
    	
    	RequestDispatcher dis = request.getRequestDispatcher("postDetail.jsp");
    	dis.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}