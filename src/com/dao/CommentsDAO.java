package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CommentsDTO;


public class CommentsDAO {
	public int insertComments(SqlSession session, CommentsDTO dto) {
		return session.insert("CommentsMapper.insertComments",dto);
	}

	public List<CommentsDTO> getCommentsByPNum(SqlSession session, int pNum) {
		List<CommentsDTO> list = session.selectList("CommentsMapper.getCommentsByPNum", pNum);
		return list;
	}
}
