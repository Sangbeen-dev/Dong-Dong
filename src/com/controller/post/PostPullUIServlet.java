package com.controller.post;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		request.setAttribute("pNum", pNum);
		// 넘어온 pNum으로 Post테이블을 조회해서 끌올횟수가 몇번 남아있는지 확인한다.
		PostService service = new PostService();
		PostDTO pDto = service.getPostByPNum(Integer.parseInt(pNum));
		String pPull = pDto.getpPull();
		request.setAttribute("pPull", pPull); // 끌올 횟수를 자식창에게 넘겨준다.
		
		// 끌올 가능 여부를 계산해서 pullPost로 넘겨준다.
		String pDate = pDto.getpDate();
		request.setAttribute("pDate", pDate); // 글 작성 시간을 자식창에게 넘겨준다.
		
		// String타입인 pDate를 Date형식으로 바꿔주는 SimpleDateFormat
		SimpleDateFormat fDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date now = new Date();// 현재시간
		Date write = null;// 글 작성된 시간
		long calDateDay = 0;// 글 작성된 시간과 현재시간의 차이
		try {
			write = fDate.parse(pDate);
			
			long calDate = now.getTime()-write.getTime();
			
			calDateDay = calDate/(24*60*60*1000);
			calDateDay = Math.abs(calDateDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("calDateDay", Long.toString(calDateDay));
		if(calDateDay < 3 || Integer.parseInt(pPull) == 0) { // 글작성시간과 현재시간의 차이가 3일 이내라면 끌올불가능
			System.out.println("끌올불가능");
			request.setAttribute("pullAvailable", "F");
			
		} else { // 3일 이상이라면 끌올 가능
			System.out.println("끌올가능");
			request.setAttribute("pullAvailable", "T");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("pullPost.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
