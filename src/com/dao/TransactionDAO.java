package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.PostDTO;
import com.dto.PurchaseDTO;
import com.dto.SaleDTO;

public class TransactionDAO {

	public List<PostDTO> purchaseList(SqlSession session, String userid) {
		List<PostDTO> plist = session.selectList("TransactionMapper.purchaseList", userid);
		return plist;
	}

	public List<PostDTO> saleList(SqlSession session, String userid) {
		List<PostDTO> slist = session.selectList("TransactionMapper.saleList", userid);
		return slist;
	}

}
