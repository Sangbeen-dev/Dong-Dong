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

	public int idCheck(SqlSession session, String userid) {
		int count = session.selectOne("MemberMapper.idCheck", userid);
		return count;
	}//end idCheck

	public int nickNameCheck(SqlSession session, String nickName) {
		int count = session.selectOne("MemberMapper.nickNameCheck", nickName);
		System.out.println(nickName);
		return count;
	}//end nickNameCheck
	
}//end MemberDAO

