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
	
	public CommentsDTO getCommentByCNum(int cNum) {
		SqlSession session = MySqlSessionFactory.getSession();
		CommentsDTO dto = null;
		try {
			CommentsDAO dao = new CommentsDAO();
			dto = dao.getCommentByCNum(session, cNum);
		} finally {
			session.close();
		}
		return dto;
	}

	public int deleteCommentByCNum(int cNum) {
		SqlSession session = MySqlSessionFactory.getSession();
	    int deleteResult = 0;
	    try {
	    	CommentsDAO dao = new CommentsDAO();
	    	deleteResult = dao.deleteCommentByCNum(session, cNum);
	    	session.commit();
	    } catch (Exception e) {
	    	session.rollback();
	    	e.printStackTrace();
	    } finally {
	    	session.close();
	    }
	    return deleteResult;
	}

	public int updateComment(CommentsDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
	    int updateResult = 0;
	    try {
	    	CommentsDAO dao = new CommentsDAO();
	    	updateResult = dao.updateComment(session, dto);
	    	session.commit();
	    } catch (Exception e) {
	    	session.rollback();
	    	e.printStackTrace();
	    } finally {
	    	session.close();
	    }
	    return updateResult;
	}
}
