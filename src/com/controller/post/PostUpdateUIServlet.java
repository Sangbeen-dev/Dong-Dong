package com.controller.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;

@WebServlet("/PostUpdateUIServlet")
public class PostUpdateUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String pNum = request.getParameter("pNum");
		String nextPage = null;
//		if(dto==null) {
		// 로그인 정보가 없으므로 로그인 하라는 에러 메세지 등 생성
//		nextPage = "main"
//		} else {
//			PostService service = new PostService();
//			PostDTO pDTO = service.getPostByPNum(Integer.parseInt(pNum));
//			
//			if(dto.getUserid().equals(pDTO.getUserid())){
//				nextPage = update jsp 로  설정
//				// 성공 메세지 생성
//			} else {
//				// 자신이 post 작성자가 아니므로 에러 메세지 생성
//				nextPage = "main"
//			}
//		}
//   	response.sendRedirect(nextPage);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
