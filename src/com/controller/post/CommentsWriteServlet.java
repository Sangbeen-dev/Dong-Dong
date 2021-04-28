package com.controller.post;

import java.io.File;
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
import com.dto.PostDTO;
import com.service.CommentsService;
import com.service.PostService;

@WebServlet("/CommentsWriteServlet")
public class CommentsWriteServlet extends HttpServlet {
	private static final Logger logr  = LoggerFactory.getLogger(CommentsWriteServlet.class);
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 기본적인 설정 & 세션 등 생성
    			HttpSession session = request.getSession();
    			request.setCharacterEncoding("UTF-8");
    			MemberDTO dto = (MemberDTO)session.getAttribute("login");
    			String pNum = request.getParameter("pNum");
    			String parentNum = request.getParameter("parentNum");
    			String nextPage = "main";
    			if(dto==null) { // 로그인 정보가 없는 경우
    				session.setAttribute("mesg", "로그인 정보가 없습니다.");
    			} else { // 로그인 정보가 있는 경우
    				CommentsService service = new CommentsService();
    				CommentsDTO cDTO = new CommentsDTO();
    				
    				if(parentNum!=null) {
    					CommentsDTO parentDTO = service.getCommentByCNum(Integer.parseInt(parentNum));
    					cDTO.setParentNum(Integer.parseInt(parentNum));
    					cDTO.setcLevel(parentDTO.getcLevel()+1);
    				} else {
    					cDTO.setParentNum(0);
    					cDTO.setcLevel(1);
    				}
    				cDTO.setpNum(Integer.parseInt(pNum));
    				cDTO.setcContent(request.getParameter("cContent"));
    				cDTO.setUserid(dto.getUserid());
    				
    				int insertResult = service.insertComments(cDTO);
    				
    				if(insertResult!=1) { // 게시글 업데이트가 실패했을 경우 
    					session.setAttribute("mesg", "게시물 수정 중 오류가 발생하였습니다.");
    		    	} else {
    		    		session.setAttribute("mesg", "댓글 쓰기 성공");
    		    		logr.info("write Comment : pNum - {} , loginUser - {}", pNum, dto.getUserid());
    		    		nextPage="PostDetailServlet?pNum="+pNum;
    		    	}
    			}
    			response.sendRedirect(nextPage);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
