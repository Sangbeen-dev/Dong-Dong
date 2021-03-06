package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.ComplaintDTO;

public class ComplaintDAO {

	public int insertComplaint(SqlSession session, ComplaintDTO dto) {
		return session.insert("ComplaintMapper.insertComplaint",dto);
	}

	public ComplaintDTO checkDuplication(SqlSession session, ComplaintDTO dto) {
		return session.selectOne("ComplaintMapper.checkDuplication",dto);
	}
	
}
