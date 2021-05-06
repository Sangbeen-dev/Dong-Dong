package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.MyOrderSheetDTO;
import com.dto.OrderSheetDTO;

public class OrderSheetDAO {

	public int OrderSheetAdd(SqlSession session, OrderSheetDTO dto) {
		
		int num = session.insert("OrderSheetAdd", dto);
		
		return num;
	}

	public List<MyOrderSheetDTO> ordersheetList(SqlSession session, String userid) {
		List<MyOrderSheetDTO> list = session.selectList("OrderSheetMapper.ordersheetList", userid);
		return list;
	}

	public int orderDel(SqlSession session, int num) {
		int n = session.delete("OrderSheetMapper.orderDel", num);
		return n;
	}

	public int orderAllDel(SqlSession session, List<String> list) {
		int n = session.delete("OrderSheetMapper.orderAllDel", list);
		return n;
	}

	public List<MyOrderSheetDTO> message(SqlSession session, String oNum) {
		List<MyOrderSheetDTO> list = session.selectList("OrderSheetMapper.message", oNum);
		return list;
	}

}
