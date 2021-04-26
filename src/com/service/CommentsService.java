package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CommentsDAO;
import com.dto.CommentsDTO;

public class CommentsService {

	public int insertComments(CommentsDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
	    int insertResult = 0;
	    try {
	    	CommentsDAO dao = new CommentsDAO();
	    	insertResult = dao.insertComments(session, dto);
	    	session.commit();
	    } catch (Exception e) {
	    	session.rollback();
	    	e.printStackTrace();
	    } finally {
	    	session.close();
	    }
	    return insertResult;
	}
}
