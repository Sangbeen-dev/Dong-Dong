package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.MyOrderSheetDTO;
import com.dto.OrderSheetDTO;
import com.dto.PurchaseDTO;
import com.dto.SaleDTO;

public class OrderSheetDAO {

	public int OrderSheetAdd(SqlSession session, OrderSheetDTO dto) {
		
		int num = session.insert("OrderSheetMapper.OrderSheetAdd", dto);
		
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

	public int purchase(SqlSession session, PurchaseDTO dto1) {
		  int n = session.insert("OrderSheetMapper.purchase", dto1); 
		  return n; 
	}
	  
	  public int sale(SqlSession session, SaleDTO dto2) { 
		  int n = session.insert("OrderSheetMapper.sale", dto2); 
		  return n; 
	}
	  
	  public int ordercomplete(SqlSession session, int pNum) { 
		  int n = session.delete("OrderSheetMapper.ordercomplete", pNum); 
		  return n; 
	}

	public List<MyOrderSheetDTO> myordersheetList(SqlSession session, String userid) {
		List<MyOrderSheetDTO> list = session.selectList("OrderSheetMapper.myordersheetList", userid);
		return list;
	}

}
