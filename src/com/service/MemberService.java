package com.service;

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
	
	
	
	
}
