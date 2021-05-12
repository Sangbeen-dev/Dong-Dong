package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.TransactionDAO;
import com.dto.PostDTO;
import com.dto.PurchaseDTO;
import com.dto.SaleDTO;

public class TransactionService {

	public List<PostDTO> purchaseList(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<PostDTO> plist = null;
		try {
			TransactionDAO dao = new TransactionDAO();
			plist = dao.purchaseList(session, userid);
		} catch (Exception e) {
			session.close();
		}
		return plist;
	}

	public List<PostDTO> saleList(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<PostDTO> slist = null;
		try {
			TransactionDAO dao = new TransactionDAO();
			slist = dao.saleList(session, userid);
		} catch (Exception e) {
			session.close();
		}
		return slist;
	}
	
	public int saleCount(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try {
			TransactionDAO dao = new TransactionDAO();
			count = dao.saleCount(session, userid);
		} catch (Exception e) {
			session.close();
		}
		return count;
	}
}
