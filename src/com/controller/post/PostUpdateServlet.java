package com.controller.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.FavoriteService;
import com.service.PostService;

@WebServlet("/PostUpdateServlet")
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String pNum = request.getParameter("pNum");
		
		if(dto==null) {
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
		} else {
			PostService pService = new PostService();
			FavoriteService fService = new FavoriteService();
			
			PostDTO pDTO = pService.getPostByPNum(Integer.parseInt(pNum));
			if(dto.getUserid().equals(pDTO.getUserid())){
				PostDTO uDTO = new PostDTO();
				
				uDTO.setpNum(Integer.parseInt(pNum));
				uDTO.setpTitle(request.getParameter("pTitle"));
				uDTO.setpContent(request.getParameter("pContent"));
				uDTO.setpPrice(Integer.parseInt(request.getParameter("pPrice")));
				//uDTO.setpImage(request.getParameter("pImage"));
				uDTO.setpImage("test"); // 이미지 수정은 일반 보류
				int updateResult = pService.updatePost(uDTO);
				
				if(updateResult==1) {
					System.out.println("포스트 업데이트 성공");
				}
			} else {
				session.setAttribute("mesg", "자신이 쓴 글만 수정이 가능합니다.");
			}
		}
		// session or request에 결과 입력
		response.sendRedirect("PostDetailServlet?pNum="+pNum);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
