package com.controller.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.controller.member.LoginServlet;
import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.service.PostService;

@WebServlet("/PostWriteServlet")
public class PostWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logr  = LoggerFactory.getLogger(PostWriteServlet.class);
    
	public PostWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "c://images"; // 업로드할 위치
		int maxSize = 1024*1024*10; //업로드 받을 최대 크기 -> 10mb
		String enc = "UTF-8";
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy(); // 덮어씌우기 방지(같은이름방지)
		MultipartRequest multi = new MultipartRequest(request,path,maxSize,enc,policy);
		
		String fileName = multi.getFilesystemName("photo");
		String originFileName = multi.getOriginalFileName("photo");
	
		// 나머지 데이터 파싱
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("login");
		String userid = member.getUserid();
		String addr = member.getAddr();
		String pTitle = multi.getParameter("title");
		String pContent = multi.getParameter("content");
		int pPrice = Integer.parseInt(multi.getParameter("price"));
		System.out.println(pPrice);
		String pImage = fileName; // 경로는 다 똑같아서 설정된 파일이름으로만 지정
		String pCategory = multi.getParameter("category");
		
		PostDTO post = new PostDTO(0,userid,addr,pCategory,pTitle,pContent,pPrice,pImage,0,null, null);

		PostService service = new PostService();
		int n = service.newPost(post);

		logr.info("PostingUser : {}-{}", userid,pTitle);
		response.sendRedirect("main");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);			
	}

}
