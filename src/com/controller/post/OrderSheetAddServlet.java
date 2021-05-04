package com.controller.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.OrderSheetDTO;
import com.service.OrderSheetService;

@WebServlet("/OrderSheetAddServlet")
public class OrderSheetAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderSheetDTO dto = new OrderSheetDTO();
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		String sUserid = (String) request.getParameter("sUserid");
		String bUserid = (String) request.getParameter("bUserid");
		String oAddr = (String) request.getParameter("oAddr");
		int oPrice = Integer.parseInt(request.getParameter("oPrice"));
		String oMessage = (String) request.getParameter("oMessage");
		
		dto.setpNum(pNum);
		dto.setsUserid(sUserid);
		dto.setbUserid(bUserid);
		dto.setoAddr(oAddr);
		dto.setoPrice(oPrice);
		dto.setoMessage(oMessage);
		
		OrderSheetService service = new OrderSheetService();
		int num = service.OrderSheetAdd(dto);
		System.out.println(num);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
