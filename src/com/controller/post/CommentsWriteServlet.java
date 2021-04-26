package com.controller.post;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CommentsDTO;
import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.CommentsService;
import com.service.PostService;

@WebServlet("/CommentsWriteServlet")
public class CommentsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 기본적인 설정 & 세션 등 생성
    			HttpSession session = request.getSession();
    			MemberDTO dto = (MemberDTO)session.getAttribute("login");
    			String pNum = request.getParameter("pNum");
    			String nextPage = "main";
    			if(dto==null) { // 로그인 정보가 없는 경우
    				session.setAttribute("mesg", "로그인 정보가 없습니다.");
    			} else { // 로그인 정보가 있는 경우
    				CommentsService service = new CommentsService();
    				CommentsDTO cDTO = new CommentsDTO();
    				cDTO.setpNum(Integer.parseInt(pNum));
    				//cDTO.setParentnum(Integer.parseInt("parentnum"));
    				cDTO.setcContent(request.getParameter("cContent"));
    				cDTO.setUserid(dto.getUserid());
    				
    				int insertResult = service.insertComments(cDTO);
    				
    				if(insertResult!=1) { // 게시글 업데이트가 실패했을 경우 
    					session.setAttribute("mesg", "게시물 수정 중 오류가 발생하였습니다.");
    		    	} else {
    		    		session.setAttribute("mesg", "댓글 쓰기 성공");
    		    		nextPage="PostDetailServlet?pNum="+pNum;
    		    	}
    			}
    			response.sendRedirect(nextPage);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
