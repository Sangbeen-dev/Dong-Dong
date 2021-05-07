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
import com.dto.PageDTO;
import com.dto.PostDTO;
import com.service.PostService;
import com.dao.PostDAO;
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("login");
		String curPage = request.getParameter("curPage");
		if(curPage == null) {
			curPage = "1";
		}
		PostService service = new PostService();
		String addr = null;
		if(member != null) {
			 	addr = member.getAddr();
		}
		PageDTO pDTO = service.selectAllPostPage(Integer.parseInt(curPage),(member==null?false:true),addr);

		List<PostDTO> list = null;//0~2 학생객체 저장한 list
		//0~2 학생객체 저장한 list
		int perPage = pDTO.getPerPage();//페이지에 보여질 레코드 갯수
		int totalCount = pDTO.getTotalCount();//전체 레코드 갯수
		int totalPage = totalCount/perPage;//전체 페이지 = 전체레코드 갯수 /perPage
		int offset = pDTO.getOffset();

		if(totalCount%perPage != 0) totalPage++;//나머지 있을 경우 1페이지 증가 11page
		list = pDTO.getList(); 
		
		request.setAttribute("perPage", perPage);
		request.setAttribute("offset", offset);
		request.setAttribute("postList", list);
		request.setAttribute("curPage",curPage);
		request.setAttribute("totalPage",totalPage);
		
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

