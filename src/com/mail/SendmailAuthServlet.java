package com.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SendmailAuthServlet")
public class SendmailAuthServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mailTo = (String) request.getAttribute("mailTo");

		String host = "smtp.naver.com"; // 호스트 네이버 메일
		String subject = ""; // 메일제목
		String from = "***@naver.com"; // 보내는 사람 메일 주소 //이부분 채워주셔야 합니다.
		String fromName = "DongDong"; // 송신자명
		String to = mailTo; // 받는 사람 메일 주소
		String content = "";
		String mesg = "";
		String 메일인증 = "";

		// 암호화 x -> 메일 인증 서블렛 에 인증값 하나를 걸어놔서 클릭하면 인증하는 서블릿을 키,벨류값으로
		// 서블릿은 그 값을 파싱하면 -> 인증될수 있게

		if (mailTo != null) {
			content = /* "<a href='http://localhost:8077/emailAuth'>인증링크</a>" */" 인증 번호 : 'p1s45asd8zxc' 입니다. 이메일 한번 더 입력해주세요.  ";// localhost 포트번호 확인하기//?=
			subject = "동동 이메일 인증 입니다.";
		}
		try {
			// 프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
			Properties props = new Properties();
			// 네이버 SMTP 사용시
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);

			props.put("mail.smtp.port", "465"); // 보내는 메일 포트 설정
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			Authenticator auth = new SendMail(); // 인증받을 자료 입력->
			Session mailSession = Session.getDefaultInstance(props, auth); // 인증받기

			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName, "UTF-8", "B"))); // 보내는 사람 설정
			InternetAddress[] address = { new InternetAddress(to) };

			msg.setRecipients(Message.RecipientType.TO, address); // 받는 사람설정

			msg.setSubject(subject); // 제목설정
			msg.setSentDate(new java.util.Date()); // 보내는 날짜 설정
			msg.setContent(content, "text/html; charset=UTF-8"); // 내용 설정(MIME 지정-HTML 형식)

			Transport.send(msg); // 메일 보내기

			/*
			 * HttpSession session = request.getSession();
			 * session.setAttribute("mesg",mesg);
			 */

		} catch (MessagingException ex) {
			System.out.println("mail send error : " + ex.getMessage());
			ex.printStackTrace();

		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
			e.printStackTrace();
		}

		response.sendRedirect("CheckmailAuth.jsp");

	}// end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
