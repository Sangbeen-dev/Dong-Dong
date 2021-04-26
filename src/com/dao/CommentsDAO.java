package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.CommentsDTO;


public class CommentsDAO {
	public int insertComments(SqlSession session, CommentsDTO dto) {
		return session.insert("CommentsMapper.insertComments",dto);
	}
}
