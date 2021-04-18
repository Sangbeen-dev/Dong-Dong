package com.controller.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.PostService;


@WebServlet("/main")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("login");
		PostService service = new PostService();
		List<PostDTO> list = null;
		if(member == null) {
			// 로그인이 안된상태 - 모든 글을 긁어온다.
			System.out.println("로그인 안됨");
			System.out.println(member);
			list = service.postListAll();
			
		} else {
			// 로그인 된 상태 - 로그인된 유저의 주소를 받아와서 해당주소로 작성된 글만 긁어온다.
			System.out.println("로그인 됨");
			String addr = member.getAddr();
			System.out.println("addr ="+addr);
			list = service.postListByAddr(addr);
		}
		
		
		System.out.println("list->"+list);
		request.setAttribute("postList", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

