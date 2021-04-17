package com.controller.post;

import java.io.IOException;

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

@WebServlet("/PostUpdateUIServlet")
public class PostUpdateUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		String pNum = request.getParameter("pNum");
		String nextPage = null;
		
		if(mDTO==null) {
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
			nextPage = "main";
		} else {
			PostService service = new PostService();
			PostDTO pDTO = service.getPostByPNum(Integer.parseInt(pNum));
			
			if(mDTO.getUserid().equals(pDTO.getUserid())){
				request.setAttribute("post", pDTO);
				nextPage = "postUpdate.jsp";
				// 성공 메세지 생성
			} else {
				session.setAttribute("mesg", "자신이 쓴 글만 수정이 가능합니다.");
				nextPage = "main";
			}
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
