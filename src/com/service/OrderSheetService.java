package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.FavoriteDAO;
import com.dao.OrderSheetDAO;
import com.dto.MyOrderSheetDTO;
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

	public List<MyOrderSheetDTO> ordersheetList(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<MyOrderSheetDTO> list = null;
		try {
			OrderSheetDAO dao = new OrderSheetDAO();
			list = dao.ordersheetList(session, userid);
		} finally {
			session.close();
		}
		return list;
	}//ordersheetList
	
	public int orderDel(int num) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			OrderSheetDAO dao = new OrderSheetDAO();
			n = dao.orderDel(session, num);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int orderAllDel(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n =0;
		try {
			OrderSheetDAO dao = new OrderSheetDAO();
			n = dao.orderAllDel(session, list);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return n;
	}

	public List<MyOrderSheetDTO> message(String oNum) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<MyOrderSheetDTO> list = null;
		try {
			OrderSheetDAO dao = new OrderSheetDAO();
			list = dao.message(session, oNum);
		} finally {
			session.close();
		}
		return list;
	}
	
}
