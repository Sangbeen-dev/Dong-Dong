package com.controller.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
import com.service.MemberService;
import com.service.PostService;

@WebServlet("/PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	MemberDTO loginInfo = (MemberDTO)session.getAttribute("login");
    	String pNum = request.getParameter("pNum");
    	
    	PostService pService = new PostService();
    	MemberService mService = new MemberService();
    	FavoriteService fService = new FavoriteService();
    	
    	
    	PostDTO pDTO = pService.getPostByPNum(Integer.parseInt(pNum));
    	MemberDTO mDTO = mService.mypage(pDTO.getUserid());
    	
    	//post data setting
    	request.setAttribute("pNum", String.valueOf(pDTO.getpNum()));
    	request.setAttribute("pCategory", pDTO.getpCategory());
    	request.setAttribute("pHit", String.valueOf(pDTO.getpHit()));
    	request.setAttribute("pImage", pDTO.getpImage());
    	request.setAttribute("pPrice", String.valueOf(pDTO.getpPrice()));
    	request.setAttribute("addr", pDTO.getAddr());
    	request.setAttribute("pContent", pDTO.getpContent());
    	request.setAttribute("pDate", pDTO.getpDate());
    	request.setAttribute("pTitle", pDTO.getpTitle());

    	//user data setting
    	request.setAttribute("userid", mDTO.getUserid());
    	request.setAttribute("username", mDTO.getUsername());
    	
    	//favorite data setting(check login info)
    	if(loginInfo!=null) {
    		FavoriteDTO temp = new FavoriteDTO();
    		temp.setUserId(loginInfo.getUserid());
    		temp.setpNum(Integer.parseInt(pNum));
    		FavoriteDTO fDTO = fService.getFavorite(temp);
    		if(fDTO!=null) {
    			request.setAttribute("favorite", "y");
    		} else {
    			request.setAttribute("favorite", "n");
			}
    	} else {
    		request.setAttribute("favorite", "n");
    	}
    	
    	RequestDispatcher dis = request.getRequestDispatcher("postDetail.jsp");
    	dis.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}