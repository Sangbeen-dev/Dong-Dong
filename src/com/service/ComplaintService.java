package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.ComplaintDAO;
import com.dto.ComplaintDTO;

public class ComplaintService {

	public int insertComplaint(ComplaintDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
	    int insertResult = 0;
	    try {
	    	ComplaintDAO dao = new ComplaintDAO();
	    	insertResult = dao.insertComplaint(session, dto);
	    	session.commit();
	    } catch (Exception e) {
	    	session.rollback();
	    	e.printStackTrace();
	    } finally {
	    	session.close();
	    }
	    return insertResult;
	}
	
	public boolean checkDuplication(ComplaintDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		ComplaintDTO queryDTO = null;
		boolean result = false;
	    try {
	    	ComplaintDAO dao = new ComplaintDAO();
	    	queryDTO = dao.checkDuplication(session, dto);
	    	if(queryDTO!=null) { 	result = true;	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	session.close();
	    }
	    return result;
	}
}
