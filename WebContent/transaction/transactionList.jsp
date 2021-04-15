<%@page import="com.dto.SaleDTO"%>
<%@page import="com.dto.PurchaseDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    List<PurchaseDTO> plist = (List<PurchaseDTO>)request.getAttribute("purchaseList");
    System.out.println("transaction.jsp"+plist);
    
    List<SaleDTO> slist = (List<SaleDTO>)request.getAttribute("saleList");
    System.out.println("transaction.jsp"+slist);
    %>