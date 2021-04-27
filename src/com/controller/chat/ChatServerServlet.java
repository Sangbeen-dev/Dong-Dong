package com.controller.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;

@WebServlet("/ChatServerServlet")
public class ChatServerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 현재 접속되어 있는 클라이언트 정보
		ArrayList<ServerChatter> chatters = new ArrayList<ServerChatter>();
		
		HttpSession session = request.getSession();
		MemberDTO dto =(MemberDTO) session.getAttribute("login");
		String nickName = dto.getNickName();
		

		ServerSocket serverSocket = null;
		Socket socket = null;

		// 접속된 순서 번호
		int no = 0;
		ServerChatter chatter = null;
		try {
			// 서버소켓 생성
			serverSocket = new ServerSocket(9002);
			while (true) {
				System.out.println("***********클라이언트 접속 대기중*************");
				socket = serverSocket.accept();

				// 채팅 객체 생성
				chatter = new ServerChatter(socket, chatters, no);
				chatter.login(); // 대화명 입력 처리

				// 채팅 객체를 ArrayList에 저장한다.
				chatters.add(chatter);
				no++;

				// 접속된 순서에 따라 1대1 채팅을 시키기 위함
				if (no % 2 == 0) { // 두명의 채터가 들어오면 쓰레드를 시작시킴
					chatters.get(no - 2).start();
					chatters.get(no - 1).start();
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
			}
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
