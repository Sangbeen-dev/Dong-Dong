package com.complaint;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.ComplaintDTO;
import com.dto.MemberDTO;
import com.service.ComplaintService;

@WebServlet("/ComplaintAcceptServlet")
public class ComplaintAcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private String[] ComplaintName = {"회원","게시글","댓글"};
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 기본적인 설정 & 세션 등 생성
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
    	HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
    	
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String coTarget = request.getParameter("coTarget");
		String userid = request.getParameter("userid");
		String coContent = request.getParameter("coContent");
		int coType = Integer.parseInt(request.getParameter("coType"));
		String nextPage = "main";
		if(dto==null) { // 로그인 정보가 없는 경우
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
		} else { // 로그인 정보가 있는 경우
			ComplaintService coService = new ComplaintService();
			
			ComplaintDTO coDTO = new ComplaintDTO();
			coDTO.setCoTarget(coTarget);
			coDTO.setUserid(userid);
			coDTO.setCoContent(coContent);
			coDTO.setCoType(coType);
			
			int insertResult = coService.insertComplaint(coDTO);
			
			if(insertResult!=1) { // 게시글 업데이트가 실패했을 경우 
				session.setAttribute("mesg", ComplaintName[coType]+" 신고 중 오류가 발생하였습니다.");
				out.print(false); 
	    	} else {
	    		//session.setAttribute("mesg", "댓글 쓰기 성공");
	    		//logr.info("write Comment : pNum - {} , loginUser - {}", pNum, dto.getUserid());
	    		out.print(true); 
	    	}	
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
