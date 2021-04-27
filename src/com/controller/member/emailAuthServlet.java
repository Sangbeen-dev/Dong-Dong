package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emailAuthServlet")
public class emailAuthServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 파싱
				request.setCharacterEncoding("utf-8");

				String email1 = request.getParameter("email1").trim();
				String email2 = request.getParameter("email2").trim();

				String nextPage = null;
				nextPage = "SendmailAuthServlet";
				request.setAttribute("mailTo", email1 + "@" + email2);

				RequestDispatcher dis = request.getRequestDispatcher(nextPage);
				dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
