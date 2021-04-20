package com.controller.post;

import java.io.File;
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

@WebServlet("/PostDeleteServlet")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				int DeletePostResult = pService.deletePostByPNum(Integer.parseInt(pNum));
				
				int DeleteFavoriteResult = fService.deleteFavoriteByPNum(Integer.parseInt(pNum));
				
				//이미지 삭제
				File deleteImage = new File("c://images//"+pDTO.getpImage());
				deleteImage.delete();
				
			} else {
				session.setAttribute("mesg", "자신이 쓴 글만 삭제가 가능합니다.");
			}
		}
		// session or request에 결과 입력
		response.sendRedirect("main");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
