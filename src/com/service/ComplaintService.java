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
}
