package com.controller.member;

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
import com.service.MemberService;

@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
	private static final Logger logr  = LoggerFactory.getLogger(MemberAddServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String username = request.getParameter("username");
		String nickName = request.getParameter("nickName");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String userimage = "default_userImg.PNG";


		MemberDTO dto = new MemberDTO
		(userid,passwd,username,nickName,addr,phone,email1,email2,userimage);

		MemberService service = new MemberService();
		int n = service.memberAdd(dto);

		HttpSession session = request.getSession();
		session.setAttribute("mesg", "회원가입성공");

		logr.info("memberAdd : {}", userid);
		response.sendRedirect("main");




	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
