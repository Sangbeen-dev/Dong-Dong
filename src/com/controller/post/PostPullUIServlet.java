package com.controller.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.PostDTO;
import com.service.PostService;


@WebServlet("/PostPullUIServlet")
public class PostPullUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PostPullUIServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNum = request.getParameter("pNum");
		// 넘어온 pNum으로 Post테이블을 조회해서 끌올횟수가 몇번 남아있는지 확인한다.
		PostService service = new PostService();
		PostDTO pDto = service.getPostByPNum(Integer.parseInt(pNum));
		String pPull = pDto.getpPull();
		System.out.println("pNum으로 조회한 pPull횟수 : " + pPull);
		request.setAttribute("pPull", pPull);
		
		// 끌올 가능 여부를 계산해서 pullPost로 넘겨준다.
		String pDate = pDto.getpDate();
		System.out.println("현재 작성된 글의 작성 시간 : " + pDate);
		
		RequestDispatcher dis = request.getRequestDispatcher("pullPost.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
