package com.dto;

public class CommentsDTO {
	private int pNum;
	private int cNum;
	private String userid;
	private String cContent;
	private String createDate;
	private String updateDate;
	private int parentNum;
	private int cLevel;
	public CommentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentsDTO(int pNum, int cNum, String userid, String cContent, String createDate, String updateDate,
			int parentNum, int clevel) {
		super();
		this.pNum = pNum;
		this.cNum = cNum;
		this.userid = userid;
		this.cContent = cContent;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.parentNum = parentNum;
		this.cLevel = clevel;
	}
	@Override
	public String toString() {
		return "CommentsDTO [pNum=" + pNum + ", cNum=" + cNum + ", userid=" + userid + ", cContent=" + cContent
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", parentNum=" + parentNum + ", cLevel="
				+ cLevel + "]";
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public int getParentNum() {
		return parentNum;
	}
	public void setParentNum(int parentNum) {
		this.parentNum = parentNum;
	}
	public int getcLevel() {
		return cLevel;
	}
	public void setcLevel(int cLevel) {
		this.cLevel = cLevel;
	}
}
