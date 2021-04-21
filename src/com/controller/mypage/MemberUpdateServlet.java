package com.controller.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.service.MemberService;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		
		String nextPage= null;
		if(dto != null) {
			request.setCharacterEncoding("UTF-8");
			String path = "c://images/profile"; // 업로드할 위치
			int maxSize = 1024*1024*10; //업로드 받을 최대 크기 -> 10mb
			String enc = "UTF-8";
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy(); // 덮어씌우기 방지(같은이름방지)
			MultipartRequest multi = new MultipartRequest(request,path,maxSize,enc,policy);
			
			// user가 프로필사진을 변경한 경우 새로운 이미지파일 이름을받아온다.
			String fileName = multi.getFilesystemName("photo");
			String originFileName = multi.getOriginalFileName("photo");
			
			// 기존 이미지파일을 받아온다.
			String basicFile = multi.getParameter("basic_photo");
			
			String userid = multi.getParameter("userid");
			String passwd = dto.getPasswd(); // mypage.jsp에서 넘겨주는 값이 없어서 dto에서 뽑아왔어요!(어차피 수정되는부분이아니라 null들어가도 상관없긴함)
			String username = multi.getParameter("username");
			
			String nickName = multi.getParameter("nickName");
			String addr = multi.getParameter("addr");
			String phone = multi.getParameter("phone");
			String email1 = multi.getParameter("email1");
			String email2 = multi.getParameter("email2");
			String userImage = "";
			if(fileName == null) {
				// 새로들어온 파일이 없는경우 --> user가 프로필사진은 변경하지 않은경우
				userImage = basicFile;
			} else {
				// 새로들어온 파일이 있는경우 --> user가 프로필사진을 변경한 경우
				userImage = fileName;
			}
			
			MemberDTO dto2 =
					new MemberDTO(userid,passwd,username,nickName,
							addr,phone,email1,email2,userImage);
			
			//update실행
			MemberService service = new MemberService();
			int num = service.memberUpdate(dto2);
			//세션에 mesg '회원정보가 수정되었습니다.' 저장
			session.setAttribute("mesg", "회원정보가 수정되었습니다.");
			nextPage="main"; //MainServlet => db => top => main.jsp goodsList.jsp에서 출력
		} else {
			nextPage = "LoginUIServlet";
			request.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		RequestDispatcher dis = 
				request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
