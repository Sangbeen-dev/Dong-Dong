package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.OrderSheetDAO;
import com.dto.OrderSheetDTO;

public class OrderSheetService {
	public int OrderSheetAdd(OrderSheetDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int num = 0;
		try {
			OrderSheetDAO dao = new OrderSheetDAO(); 
			num = dao.OrderSheetAdd(session, dto);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return num;
	}
}
