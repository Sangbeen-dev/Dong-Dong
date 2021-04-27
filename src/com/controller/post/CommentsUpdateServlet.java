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

@WebServlet("/CommentsUpdateServlet")
public class CommentsUpdateServlet extends HttpServlet {
	private static final Logger logr  = LoggerFactory.getLogger(CommentsUpdateServlet.class);
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String pNum = request.getParameter("pNum");
		String cNum = request.getParameter("cNum");
		String cContent = request.getParameter("cContent");
		String nextPage = "PostDetailServlet?pNum="+pNum;
		System.out.println(pNum+" "+cNum+" "+cContent);
		if(dto==null) { // 로그인 정보가 없는 경우
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
			nextPage = "main";
		} else { // 로그인 정보가 있는 경우
			CommentsService cService = new CommentsService();
			CommentsDTO cDTO = cService.getCommentByCNum(Integer.parseInt(cNum));
			cDTO.setcContent(cContent);
			
			if(dto.getUserid().equals(cDTO.getUserid())){ // 수정할 댓글과 로그인 유저 정보가 일치하는 경우
				int updateResult = cService.updateComment(cDTO);
				
				if(updateResult!=1) { // 댓글 수정이 실패했을 경우 
					session.setAttribute("mesg", "댓글 수정 중 오류가 발생하였습니다.");
					nextPage="PostDetailServlet?pNum="+pNum;
		    	} else {
					logr.info("update Comment : cNum - {} , loginUser - {}", cNum, dto.getUserid());
					session.setAttribute("mesg", "댓글이 수정되었습니다.");
		    	}
			} else {
				session.setAttribute("mesg", "자신이 쓴 댓글만 수정이 가능합니다.");
			}
		}
		response.sendRedirect(nextPage);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
