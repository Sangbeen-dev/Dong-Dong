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

import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.PostService;

@WebServlet("/PostPullServlet")
public class PostPullServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logr  = LoggerFactory.getLogger(PostDeleteServlet.class);
    public PostPullServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기본적인 설정 & 세션 등 생성
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String pNum = request.getParameter("pNum"); // form에서 넘어오는 pNum값
		String nextPage = "main";
		
		if(dto==null) { // 로그인 정보가 없는 경우
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
		} else { // 로그인 정보가 있는 경우
			PostService service = new PostService();
			
			PostDTO pDTO = service.getPostByPNum(Integer.parseInt(pNum)); // 끌올 할 글을 작성한 회원정보
			
			if(dto.getUserid().equals(pDTO.getUserid())){ // 끌올할 게시글과 로그인 유저 정보가 일치하는 경우
				int pullResult = service.pullPost(Integer.parseInt(pNum));
				System.out.println("끌올했냐? " + pullResult);
				if(pullResult!=1) { // 게시글 삭제가 실패했을 경우 
					session.setAttribute("mesg", "게시물 끌올 중 오류가 발생하였습니다. 다시시도하세요.");
					nextPage="PostDetailServlet?pNum="+pNum; // 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		    	} else {
		    		// 끌올했음!
					logr.info("Pull Post : pNum - {} , loginUser - {}", pNum, dto.getUserid());
					session.setAttribute("mesg", "게시글이 끌올되었습니다.");
		    	}
			} else { // 삭제할 게시글과 로그인 유저 정보가 일치하지 않는 경우
				session.setAttribute("mesg", "자신이 쓴 글만 끌올이 가능합니다.");
			}
		}
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
