package com.controller.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dto.FavoriteDTO;
import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.FavoriteService;
import com.service.PostService;

@WebServlet("/FavorateSwitchServlet")
public class FavorateSwitchServlet extends HttpServlet {
	private static final Logger logr  = LoggerFactory.getLogger(FavorateSwitchServlet.class);
	static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 기본적인 설정 & 세션 등 생성
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
    	
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login"); // 로그인 정보 조회
		String pNum = request.getParameter("pNum"); // 관심 목록 설정을 위해 게시글 번호 파싱
		boolean favorite = (request.getParameter("favorite").equals("true")?true:false); // 현재 상태 저장 T: 관심O / F: 관심X
		
		if(mDTO==null) {
			//로그인 정보가 없는 경우
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
			response.sendRedirect("main");
		} else{
			// 로그인 정보가 있는 경우, 기본 데이터 생성 
			PostService pService = new PostService();
			FavoriteService fService = new FavoriteService();
			PostDTO pDTO = pService.getPostByPNum(Integer.parseInt(pNum)); // 게시글 번호로 게시글 정보 획득
			
			FavoriteDTO fDTO = new FavoriteDTO();
			fDTO.setpNum(Integer.parseInt(pNum));
			fDTO.setUserId(mDTO.getUserid());
			
			// 현재 상태에 따라 if_else
			if(!favorite) { // 관심 X 일때 -> 관심목록에 추가하기
				// 관심목록 저장을 위한 추가적인 데이터 설정
				fDTO.setpCategory(pDTO.getpCategory());
				fDTO.setpTitle(pDTO.getpTitle()); ;
				fDTO.setpContent(pDTO.getpContent());
				fDTO.setpPrice(pDTO.getpPrice());
				fDTO.setpImage(pDTO.getpImage());
				fDTO.setpHIt(pDTO.getpHit());
				
				int insertResult = fService.insertFavoite(fDTO); // 관심목록에 저장
				if(insertResult==1) { // 성공여부 확인
					logr.info("Create Favorite : postNumber - {}, loginUser - {}", fDTO.getpNum(), fDTO.getUserId());
					out.print(true); // 관심목록 저장이 완료된 것을 페이지에 표시하기 위해 비동기 전달
				} else {
					session.setAttribute("mesg", "관심목록 저장에 실패하였습니다.");
					out.print(false);
				}
				
			}else { // 관심 O 일때 -> 관심목록에서 삭제하기
				int deleteResult = fService.deleteFavoite(fDTO); // 관심목록에서 삭제
				if(deleteResult==1) { // 성공여부 확인
					logr.info("Delete Favorite : postNumber - {}, loginUser - {}", fDTO.getpNum(), fDTO.getUserId());
					out.print(false); // 관심목록 삭제가 완료된 것을 페이지에 표시하기 위해 비동기 전달
				} else {
					session.setAttribute("mesg", "관심목록 삭제에 실패하였습니다.");
					out.print(true);
				}
			}
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
