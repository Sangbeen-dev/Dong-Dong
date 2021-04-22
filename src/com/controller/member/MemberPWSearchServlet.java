package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/MemberPWSearchServlet")
public class MemberPWSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberPWSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 파싱
				request.setCharacterEncoding("utf-8");
				String username = request.getParameter("username").trim(); //양쪽 공백제거
				String userid = request.getParameter("userid").trim();
				String phone = request.getParameter("phone").trim();
				String email =  request.getParameter("email").trim();
				
				String email1 = email.split("@")[0];
				String email2 = email.split("@")[1];
				
				//service.idSearch(MemberDTO)이용
				MemberDTO dto = new MemberDTO();
				dto.setUsername(username);
				dto.setUserid(userid);
				dto.setPhone(phone);
				dto.setEmail1(email1);
				dto.setEmail2(email2);
				
				MemberService service = new MemberService();
				String passwd= service.pwSearch(dto);
				String nextPage = null;
				
				//전화번호, 사용자 이름 일치 여부검사 (mapperid = "pwSearch") 
				if(userid == null) {
					nextPage = "pwSearch.jsp";
					request.setAttribute("mesg", "사용자를 찾을 수 없습니다.");
				}else { //일치하는 경우 메일발송
					nextPage="SendMailServlet";
					request.setAttribute("mailTo", email1 + "@" + email2);
					request.setAttribute("passwd", passwd);
					
				}
				RequestDispatcher dis = request.getRequestDispatcher(nextPage);
				dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
