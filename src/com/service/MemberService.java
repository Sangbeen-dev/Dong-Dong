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
	
}
