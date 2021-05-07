package com.controller.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dto.CommentsDTO;
import com.dto.MemberDTO;
import com.service.CommentsService;

@WebServlet("/CommentsDeleteServlet")
public class CommentsDeleteServlet extends HttpServlet {
	private static final Logger logr  = LoggerFactory.getLogger(CommentsDeleteServlet.class);
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String pNum = request.getParameter("pNum");
		String cNum = request.getParameter("cNum");
		String nextPage = "PostDetailServlet?pNum="+pNum;
		if(dto==null) { // 로그인 정보가 없는 경우
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
			nextPage = "main";
		} else { // 로그인 정보가 있는 경우
			CommentsService cService = new CommentsService();
			CommentsDTO cDTO = cService.getCommentByCNum(Integer.parseInt(cNum));
			
			if(dto.getUserid().equals(cDTO.getUserid())){ // 삭제할 댓글과 로그인 유저 정보가 일치하는 경우
				int deleteResult = cService.deleteCommentByCNum(Integer.parseInt(cNum));
				
				if(deleteResult==0) { // 댓글 삭제가 실패했을 경우 
					session.setAttribute("mesg", "댓글 삭제 중 오류가 발생하였습니다.");
					nextPage="PostDetailServlet?pNum="+pNum;
		    	} else {
					logr.info("Delete Comment : cNum - {} , loginUser - {}", cNum, dto.getUserid());
					//session.setAttribute("mesg", "댓글이 삭제되었습니다.");
		    	}
			} else {
				session.setAttribute("mesg", "자신이 쓴 댓글만 삭제가 가능합니다.");
			}
		}
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
