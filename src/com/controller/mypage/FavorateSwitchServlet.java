package com.controller.mypage;

import java.io.IOException;
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
    	HttpSession session = request.getSession();
		
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		String userid = request.getParameter("userid");
		String pNum = request.getParameter("pNum");
		boolean favorite = (request.getParameter("favorite").equals("true")?true:false);
		String nextPage = null;
		System.out.println("favoriteSwitchServlet in/ favorite : " + favorite);
		if(mDTO==null) {
			System.out.println("로그인 정보 없음");
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
			nextPage = "main";
		} else{
			PostService pService = new PostService();
			PostDTO pDTO = pService.getPostByPNum(Integer.parseInt(pNum));
			FavoriteService fService = new FavoriteService();
			
			FavoriteDTO fDTO = new FavoriteDTO();
			fDTO.setpNum(Integer.parseInt(pNum));
			fDTO.setUserId(userid);
			if(!favorite) {
				System.out.println("좋아요 생성 시작");
				// 좋아요 데이터 생성
				// 데이터 생성을 위해 Post 정보 쿼리
				

				// 데이터 생성
				fDTO.setpCategory(pDTO.getpCategory());
				fDTO.setpTitle(pDTO.getpTitle()); ;
				fDTO.setpContent(pDTO.getpContent());
				fDTO.setpPrice(pDTO.getpPrice());
				fDTO.setpImage(pDTO.getpImage());
				fDTO.setpHIt(pDTO.getpHit());
				
				System.out.println(fDTO);
				int favoriteResult = fService.insertFavoite(fDTO);
				//int hitResult = pService.changeHitByFavorite(1);
				
			}else {
				System.out.println("좋아요 삭제 시작");
				// 좋아요 데이터 삭제
				int favoriteResult = fService.deleteFavoite(fDTO);
				//int hitResult = pService.changeHitByFavorite(-1);
			}
		}

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
