package com.controller.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;


@WebServlet("/PostWriteUIServlet")
public class PostWriteUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PostWriteUIServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인이 된 경우 -> 글쓰기화면으로 전환
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		if(dto != null) {
			// 로그인이 된 경우 -> 글쓰기 화면으로 전환
			response.sendRedirect("postWrite.jsp");
		} else {
			// 로그인 안 된 경우 -> 로그인 화면으로 전환
			session.setAttribute("mesg","회원 전용 기능입니다. 로그인 해주세요.");
			response.sendRedirect("LoginUIServlet");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
