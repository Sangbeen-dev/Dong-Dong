package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {

	public MemberDTO mypage(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("MemberMapper.mypage", userid);
		return dto;
	}// end myPage

	public MemberDTO login(SqlSession session, HashMap<String, String> map) {
		MemberDTO dto = session.selectOne("MemberMapper.login", map);
		return dto;
	} //end login

	public int memberAdd(SqlSession session,MemberDTO dto) {
		   int n = session.insert("MemberMapper.memberAdd", dto);
		   return n;
	   
	
	}//end memberAdd
	
	public String idSearch(SqlSession session, MemberDTO dto) {
		
		String userid = session.selectOne("MemberMapper.idSearch",dto);
		
		return userid;
	}//end idSearch

	public String pwSearch(SqlSession session, MemberDTO dto) {
		String passwd = session.selectOne("MemberMapper.pwSearch",dto);
		return passwd;
	}//end pwSearch
	
}//end MemberDAO

