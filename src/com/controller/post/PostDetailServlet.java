package com.controller.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.MemberService;
import com.service.PostService;

@WebServlet("/PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String pNum = request.getParameter("pNum");
    	
    	PostService pService = new PostService();
    	MemberService mService = new MemberService();
    	
    	
    	PostDTO pDTO = pService.getPostByPNum(Integer.parseInt(pNum));
    	MemberDTO mDTO = mService.mypage(pDTO.getUserid());
    	
    	// 데이터 파싱 후 페이지 이동
    	request.setAttribute("pNum", String.valueOf(pDTO.getpNum()));
    	request.setAttribute("pCategory", pDTO.getpCategory());
    	request.setAttribute("pHit", String.valueOf(pDTO.getpHit()));
    	request.setAttribute("pImage", pDTO.getpImage());
    	request.setAttribute("pPrice", String.valueOf(pDTO.getpPrice()));
    	request.setAttribute("addr", pDTO.getAddr());
    	request.setAttribute("pContent", pDTO.getpContent());
    	request.setAttribute("pDate", pDTO.getpDate());
    	request.setAttribute("pTitle", pDTO.getpTitle());

    	request.setAttribute("userid", mDTO.getUserid());
    	request.setAttribute("username", mDTO.getUsername());
    	
    	RequestDispatcher dis = request.getRequestDispatcher("postDetail.jsp");
    	dis.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}