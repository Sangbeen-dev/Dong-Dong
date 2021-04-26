package com.controller.post;

import java.io.File;
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
import com.dto.PostDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.service.PostService;

@WebServlet("/PostUpdateServlet")
public class PostUpdateServlet extends HttpServlet {
	private static final Logger logr  = LoggerFactory.getLogger(PostUpdateServlet.class);
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이미지 관련 설정
		String path = "c://images"; // 업로드할 위치
		int maxSize = 1024*1024*10; //업로드 받을 최대 크기 -> 10mb
		String enc = "UTF-8";
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy(); // 덮어씌우기 방지(같은이름방지)
		MultipartRequest multi = new MultipartRequest(request,path,maxSize,enc,policy);
		
		String fileName = multi.getFilesystemName("photo");
		String originFileName = multi.getOriginalFileName("photo");
		
		// 기본적인 설정 & 세션 등 생성
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String pNum = multi.getParameter("pNum");
		String nextPage = "PostDetailServlet?pNum="+pNum;
		
		if(dto==null) { // 로그인 정보가 없는 경우
			session.setAttribute("mesg", "로그인 정보가 없습니다.");
			nextPage="main";
		} else { // 로그인 정보가 있는 경우
			PostService pService = new PostService();
			PostDTO pDTO = pService.getPostByPNum(Integer.parseInt(pNum)); // 수정할 게시글 정보 획득
			if(dto.getUserid().equals(pDTO.getUserid())){ // 수정할 게시글과 로그인 유저 정보가 일치하는 경우
				PostDTO uDTO = pService.getPostByPNum(Integer.parseInt(pNum));
				
				// 수정할 정보 설정
				uDTO.setpNum(Integer.parseInt(pNum));
				uDTO.setpCategory(multi.getParameter("pCategory"));
				uDTO.setpContent(multi.getParameter("pContent"));
				uDTO.setpPrice(Integer.parseInt(multi.getParameter("pPrice")));
				uDTO.setpImage(fileName!=null?fileName:pDTO.getpImage()); // 이미지 변경 여부에 따라 3항 선택
				
				int updateResult = pService.updatePost(uDTO);
				
				if(updateResult!=1) { // 게시글 업데이트가 실패했을 경우 
					session.setAttribute("mesg", "게시물 수정 중 오류가 발생하였습니다.");
		    	} else {
		    		if(fileName!=null && !(fileName.equals(pDTO.getpImage()))) { // 이미지 파일이 변경되었을 경우
						// 게시글 수정 전 이미지 삭제
						File deleteImage = new File(path+"//"+pDTO.getpImage());
						deleteImage.delete();
					}//if
					logr.info("Update Post : pNum - {}, loginUser - {}", pNum, dto.getUserid());
		    	}
			} else { // 수정할 게시글과 로그인 유저정보가 일치하지 않는 경우
				session.setAttribute("mesg", "자신이 쓴 글만 수정이 가능합니다.");
				nextPage="main";
			}//if_else
		}//if_else
		response.sendRedirect(nextPage);
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
