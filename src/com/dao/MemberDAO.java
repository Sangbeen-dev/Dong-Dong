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
}//end MemberDAO

