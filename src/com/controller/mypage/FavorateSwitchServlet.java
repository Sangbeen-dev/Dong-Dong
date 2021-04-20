package com.controller.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.FavoriteDTO;
import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.service.FavoriteService;
import com.service.PostService;

@WebServlet("/FavorateSwitchServlet")
public class FavorateSwitchServlet extends HttpServlet {
	 static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
    	
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		String userid = request.getParameter("userid");
		String pNum = request.getParameter("pNum");
		boolean favorite = (request.getParameter("favorite").equals("true")?true:false);
		String nextPage = null;
		
		if(mDTO==null) {
			//로그인 정보가 없는 경우
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
			nextPage = "main";
		} else{
			// 로그인 정보가 있는 경우, 기본적인 데이터 생성 
			PostService pService = new PostService();
			PostDTO pDTO = pService.getPostByPNum(Integer.parseInt(pNum));
			FavoriteService fService = new FavoriteService();
			
			FavoriteDTO fDTO = new FavoriteDTO();
			fDTO.setpNum(Integer.parseInt(pNum));
			fDTO.setUserId(userid);
			if(!favorite) {
				// 데이터 생성
				fDTO.setpCategory(pDTO.getpCategory());
				fDTO.setpTitle(pDTO.getpTitle()); ;
				fDTO.setpContent(pDTO.getpContent());
				fDTO.setpPrice(pDTO.getpPrice());
				fDTO.setpImage(pDTO.getpImage());
				fDTO.setpHIt(pDTO.getpHit());
				
				int insertResult = fService.insertFavoite(fDTO);
				//int hitResult = pService.changeHitByFavorite(1);
				
				out.print(true);
			}else {
				// 좋아요 데이터 삭제
				int deleteResult = fService.deleteFavoite(fDTO);
				//int hitResult = pService.changeHitByFavorite(-1);
				out.print(false);
			}
		}

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
