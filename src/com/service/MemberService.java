package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {
	
	public MemberDTO mypage(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = new MemberDTO();
		try {
			MemberDAO dao = new MemberDAO();
			dto = dao.mypage(session, userid);
		} finally {
			session.close();
		}
		return dto;
	}//end mypage
	
	
	 public int memberAdd(MemberDTO dto) {
		  SqlSession session = MySqlSessionFactory.getSession();
		  int n = 0;
		  try {
			  MemberDAO dao = new MemberDAO();
			  n = dao.memberAdd(session, dto);
			  session.commit();
		  }finally {
			session.close();
		}
		  return n;
	   }//end memberAdd
	
	
	
	
	public MemberDTO login(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		
		try{
			MemberDAO dao = new MemberDAO();
			dto = dao.login(session, map);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			session.close();
		}
		
		return dto;
	}//end login
	
	public String idSearch(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		String userid = null;
		try{
			MemberDAO dao = new MemberDAO();
			userid = dao.idSearch(session, dto);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			session.close();
		}
		return userid;
	}//end idSearch


	public int idCheck(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try {
			 MemberDAO dao = new MemberDAO();
			count = dao.idCheck(session, userid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return count;	
		}


	public int nickNameCheck(String nickName) {
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try {
			 MemberDAO dao = new MemberDAO();
			count = dao.nickNameCheck(session, nickName);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return count;	
		}
	public String pwSearch(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		String passwd = null;
		try{
			MemberDAO dao = new MemberDAO();
			passwd = dao.pwSearch(session, dto);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			session.close();
		}
		return passwd;
	}//end pwSerach


	public int memberUpdate(MemberDTO dto2) {
		SqlSession session = MySqlSessionFactory.getSession();
		int num = 0;
		try {
			MemberDAO dao = new MemberDAO();
			num = dao.memberUpdate(session, dto2);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return num;
	}


	public int nickCheck(String nickName) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n= 0;
		try{
			MemberDAO dao = new MemberDAO();
			n = dao.nickCheck(session, nickName);
		}finally {
			session.close();
		}
		return n;
	}//mypage 닉네임중복검사


	public int nickUpdate(MemberDTO dto2) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			MemberDAO dao = new MemberDAO();
			n = dao.nickUpdate(session, dto2);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return n;
	}//mypage에서 닉네임 중복검사후 변경


	public void withdrawal(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			dao.withdrawal(session, userid);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
	}//end withdrawal


	public int addrAuth1(MemberDTO dto2) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			MemberDAO dao = new MemberDAO();
			n = dao.addrAuth1(session, dto2);
		} finally {
			session.close();
		}
		return n;
	}//동 같은지 체크
	
	public int addrAuth2(MemberDTO dto2) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			MemberDAO dao = new MemberDAO();
			n = dao.addrAuth2(session, dto2);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return n;
	}//동 달라서 현재위치로 addr 수정
	
}
