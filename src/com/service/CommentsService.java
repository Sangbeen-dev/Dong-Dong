package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CommentsDAO;
import com.dao.FavoriteDAO;
import com.dto.CommentsDTO;
import com.dto.PostDTO;

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

	public List<CommentsDTO> getCommentsByPNum(int pNum) {
		
		SqlSession session = MySqlSessionFactory.getSession();
		List<CommentsDTO> list = null;
		try {
			CommentsDAO dao = new CommentsDAO();
			list = dao.getCommentsByPNum(session, pNum);
		} finally {
			session.close();
		}
		return list;
	}
}
