package com.controller.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CommentsDTO;
import com.dto.FavoriteDTO;
import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.CommentsService;
import com.service.FavoriteService;
import com.service.MemberService;
import com.service.PostService;

@WebServlet("/PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 기본적인 설정 & 세션 등 생성
    	HttpSession session = request.getSession();
    	MemberDTO uDTO = (MemberDTO)session.getAttribute("login");
    	String pNum = request.getParameter("pNum");
    	
    	PostService pService = new PostService();
    	MemberService mService = new MemberService();
    	FavoriteService fService = new FavoriteService();
    	CommentsService sService = new CommentsService();
    	
    	PostDTO pDTO = pService.getPostByPNum(Integer.parseInt(pNum));
    	MemberDTO mDTO = mService.mypage(pDTO.getUserid());
    	List<CommentsDTO> comments = sService.getCommentsByPNum(Integer.parseInt(pNum)); 
    	String nextPage = "";
    	//게시글 조회수 증가
    	pDTO.setpHit(pDTO.getpHit()+1);
    	int updateResult = pService.updatePHit(pDTO);
    	
    	if(updateResult!=1) { // 조회수 업데이트가 실패했을 경우 
			session.setAttribute("mesg", "게시물 접근 중 오류가 발생하였습니다.");
			nextPage="main";
    	} else { // 조회수 업데이트 성공 후
    		//게시글 정보 전달을 위해 request에 설정
        	request.setAttribute("pNum", String.valueOf(pDTO.getpNum()));
        	request.setAttribute("pCategory", pDTO.getpCategory());
        	request.setAttribute("pHit", String.valueOf(pDTO.getpHit()));
        	request.setAttribute("pImage", pDTO.getpImage());
        	request.setAttribute("pPrice", String.valueOf(pDTO.getpPrice()));
        	request.setAttribute("addr", pDTO.getAddr());
        	request.setAttribute("pContent", pDTO.getpContent());
        	request.setAttribute("pDate", pDTO.getpDate());
        	request.setAttribute("pTitle", pDTO.getpTitle());
        	request.setAttribute("pStatus", pDTO.getpStatus());
        	
        	//게시글을 작성한 유저 정보 전달을 위해 request에 설정
        	request.setAttribute("userid", mDTO.getUserid());
        	request.setAttribute("username", mDTO.getUsername());
        	
        	//확인할라고 잠깐 추가했어요 두줄 
        	request.setAttribute("userImage", mDTO.getUserimage());
        	request.setAttribute("nickName", mDTO.getNickName());
        	
        	// 게시글 내용 전달을 위해 설정
        	request.setAttribute("comments", comments);
        	
        	//게시글의 관심 설정 정보 전달을 위해 request에 설정
        	if(uDTO!=null) { // 로그인 정보가 있을 경우
        		FavoriteDTO temp = new FavoriteDTO();
        		temp.setUserId(uDTO.getUserid());
        		temp.setpNum(Integer.parseInt(pNum));
        		FavoriteDTO fDTO = fService.getFavorite(temp); // 관심 정보 조회
        		if(fDTO!=null) { // 관심 O
        			request.setAttribute("favorite", true);
        		} else { // 관심 X
        			request.setAttribute("favorite", false);
    			}
        	} else { // 로그인 정보가 없을 경우
        		request.setAttribute("favorite", false);
        	}
			nextPage="postDetail.jsp";
    	}
    	// 페이지 이동
    	RequestDispatcher dis = request.getRequestDispatcher(nextPage);
    	dis.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}