package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.OrderSheetDAO;
import com.dao.PostDAO;
import com.dto.MyOrderSheetDTO;
import com.dto.OrderSheetDTO;
import com.dto.PurchaseDTO;
import com.dto.SaleDTO;

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

	public int sale(String bUserid, String sUserid, int pNum) {
		SqlSession session = MySqlSessionFactory.getSession();
		PurchaseDTO dto1 = new PurchaseDTO();
		SaleDTO dto2 = new SaleDTO();
		int n = 0;
		try {
			OrderSheetDAO dao = new OrderSheetDAO();
			dto1.setUserid(bUserid);
			dto1.setpNum(pNum);
			dto2.setUserid(sUserid);
			dto2.setpNum(pNum);
			n = dao.purchase(session, dto1);
			n = dao.sale(session, dto2);
			n = dao.ordercomplete(session, pNum);
			PostDAO dao2 = new PostDAO();
			n = dao2.poststatus(session, pNum);
			session.commit();
		} catch (Exception e) {
			System.out.println("rollback==");
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return n;
	}//end sale

	public List<MyOrderSheetDTO> myordersheetList(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<MyOrderSheetDTO> list = null;
		try {
			OrderSheetDAO dao = new OrderSheetDAO();
			list = dao.myordersheetList(session, userid);
		} finally {
			session.close();
		}
		return list;
	}
	
}
