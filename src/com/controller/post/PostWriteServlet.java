package com.controller.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.PostDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.service.PostService;

@WebServlet("/PostWriteServlet")
public class PostWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		System.out.println("-----------확인용--------------");
		System.out.println("저장된 파일이름 : " + fileName);
		System.out.println("원래 파일 이름 : " + originFileName);
		System.out.println("----------------------------");
	
		// 나머지 데이터 파싱
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("login");
		String userid = member.getUserid();
		String addr = member.getAddr();
		System.out.println(userid+"//////"+addr);
		String pTitle = multi.getParameter("title");
		System.out.println(pTitle);
		String pContent = multi.getParameter("content");
		int pPrice = Integer.parseInt(multi.getParameter("price"));
		System.out.println(pPrice);
		String pImage = fileName; // 경로는 다 똑같아서 설정된 파일이름으로만 지정
		
		PostDTO post = new PostDTO(0,userid,addr,"F",pTitle,pContent,pPrice,pImage,0,null);
		System.out.println(post);
		PostService service = new PostService();
		int n = service.newPost(post);
		System.out.println("insert 행 수 :" + n);
		
		
		response.sendRedirect("main");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);			
	}

}
