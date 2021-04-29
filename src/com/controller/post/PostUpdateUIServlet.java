package com.controller.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.controller.mypage.FavorateSwitchServlet;
import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.PostService;

@WebServlet("/PostUpdateUIServlet")
public class PostUpdateUIServlet extends HttpServlet {
	private static final Logger logr  = LoggerFactory.getLogger(PostUpdateUIServlet.class);
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 기본적인 설정 & 세션 등 생성
    	HttpSession session = request.getSession();
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		String pNum = request.getParameter("pNum");
		String nextPage = null; // 이동할 페이지
		
		if(mDTO==null) { // 로그인 정보가 없을 때
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
			nextPage = "main";
		} else { // 로그인 정보가 있는 경우
			PostService service = new PostService();
			PostDTO pDTO = service.getPostByPNum(Integer.parseInt(pNum));
			
			if(mDTO.getUserid().equals(pDTO.getUserid())){ // 현재 게시글과 로그인 정보의 유저가 일치하는지 확인
				// db에 들어있는 글내용 -> 엔터값이 <br>태그로 변환돼서 들어가있음
				// 사용자가 글 수정을 할 때 <br>태그로 보이는게 아니라 엔터값으로 처리돼서 보이게한다.
				String pContent = pDTO.getpContent();
				pContent = pContent.replaceAll("<br>", "\r\n");
				pDTO.setpContent(pContent);
				request.setAttribute("post", pDTO);
				nextPage = "postUpdate.jsp";
				
			} else { // 게시글 주인과 로그인 유저가 다른 경우
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
