package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.TransactionDAO;
import com.dto.PurchaseDTO;
import com.dto.SaleDTO;

public class TransactionService {

	public List<PurchaseDTO> purchaseList(String nickName) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<PurchaseDTO> plist = null;
		try {
			TransactionDAO dao = new TransactionDAO();
			plist = dao.purchaseList(session, nickName);
		} catch (Exception e) {
			session.close();
		}
		return plist;
	}

	public List<SaleDTO> saleList(String nickName) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<SaleDTO> slist = null;
		try {
			TransactionDAO dao = new TransactionDAO();
			slist = dao.saleList(session, nickName);
		} catch (Exception e) {
			session.close();
		}
		return slist;
	}

}
