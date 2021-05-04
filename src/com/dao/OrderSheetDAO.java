package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.OrderSheetDTO;

public class OrderSheetDAO {

	public int OrderSheetAdd(SqlSession session, OrderSheetDTO dto) {
		
		int num = session.insert("OrderSheetAdd", dto);
		
		return num;
	}

}
