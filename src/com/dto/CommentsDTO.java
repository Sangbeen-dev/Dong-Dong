package com.dto;

public class CommentsDTO {
	private int pNum;
	private int cNum;
	private int parentnum;
	private String userid;
	private String cContent;
	private String cDate;
	
	public CommentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CommentsDTO(int pNum, int cNum, int parentnum, String userid, String cContent, String cDate) {
		super();
		this.pNum = pNum;
		this.cNum = cNum;
		this.parentnum = parentnum;
		this.userid = userid;
		this.cContent = cContent;
		this.cDate = cDate;
	}
	
	@Override
	public String toString() {
		return "CommentsDTO [pNum=" + pNum + ", cNum=" + cNum + ", parentnum=" + parentnum + ", userid=" + userid
				+ ", cContent=" + cContent + ", cDate=" + cDate + "]";
	}
	
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public int getParentnum() {
		return parentnum;
	}
	public void setParentnum(int parentnum) {
		this.parentnum = parentnum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
}
