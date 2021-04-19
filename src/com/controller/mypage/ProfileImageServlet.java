package com.controller.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ProfileImageServlet
 */
@WebServlet("/ProfileImageServlet")
public class ProfileImageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "c://images/profile"; // 업로드할 위치
		int maxSize = 1024*1024*10; //업로드 받을 최대 크기 -> 10mb
		String enc = "UTF-8";
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy(); // 덮어씌우기 방지(같은이름방지)
		MultipartRequest multi = new MultipartRequest(request,path,maxSize,enc,policy);
		String fileName = multi.getFilesystemName("photo");
		String originFileName = multi.getOriginalFileName("photo");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
