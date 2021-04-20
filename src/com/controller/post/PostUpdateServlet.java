package com.controller.post;

import java.io.File;
import java.io.IOException;
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
import com.service.FavoriteService;
import com.service.PostService;

@WebServlet("/PostUpdateServlet")
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "c://images"; // 업로드할 위치
		int maxSize = 1024*1024*10; //업로드 받을 최대 크기 -> 10mb
		String enc = "UTF-8";
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy(); // 덮어씌우기 방지(같은이름방지)
		MultipartRequest multi = new MultipartRequest(request,path,maxSize,enc,policy);
		
		String fileName = multi.getFilesystemName("photo");
		String originFileName = multi.getOriginalFileName("photo");
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String pNum = multi.getParameter("pNum");
		
		if(dto==null) {
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
		} else {
			PostService pService = new PostService();
			FavoriteService fService = new FavoriteService();
			
			PostDTO pDTO = pService.getPostByPNum(Integer.parseInt(pNum));
			if(dto.getUserid().equals(pDTO.getUserid())){
				PostDTO uDTO = new PostDTO();
			
				uDTO.setpNum(Integer.parseInt(pNum));
				uDTO.setpTitle(multi.getParameter("pTitle"));
				uDTO.setpContent(multi.getParameter("pContent"));
				uDTO.setpPrice(Integer.parseInt(multi.getParameter("pPrice")));
				uDTO.setpImage(fileName!=null?fileName:pDTO.getpImage());
				int updateResult = pService.updatePost(uDTO);
				
				if(updateResult==1) {
					int fUpdateResult = fService.updateFavoriteByPost(uDTO);
				}
				if(fileName!=null && !(fileName.equals(pDTO.getpImage()))) {
					File deleteImage = new File(path+"//"+pDTO.getpImage());
					deleteImage.delete();
				}
			} else {
				session.setAttribute("mesg", "자신이 쓴 글만 수정이 가능합니다.");
			}
		}
		// session or request에 결과 입력
		response.sendRedirect("PostDetailServlet?pNum="+pNum);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
