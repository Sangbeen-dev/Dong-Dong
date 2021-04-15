package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.PurchaseDTO;
import com.dto.SaleDTO;

public class TransactionDAO {

	public List<PurchaseDTO> purchaseList(SqlSession session, String nickName) {
		List<PurchaseDTO> plist = session.selectList("TransactionMapper.purchaseList", nickName);
		return plist;
	}

	public List<SaleDTO> saleList(SqlSession session, String nickName) {
		List<SaleDTO> slist = session.selectList("TransactionMapper.saleList", nickName);
		return slist;
	}

}
