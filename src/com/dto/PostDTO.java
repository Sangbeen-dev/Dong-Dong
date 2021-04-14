package com.dto;

public class PostDTO {
	private int pNum;
	private String userid;
	private String pCategory;
	private String pTitle;
	private String pContent;
	private int pPrice;
	private String pImage;
	private int pHit;
	private String pDate;
	
	public PostDTO() {
		super();
	}

	public PostDTO(int pNum, String userid, String pCategory, String pTitle, String pContent, int pPrice, String pImage,
			int pHit, String pDate) {
		super();
		this.pNum = pNum;
		this.userid = userid;
		this.pCategory = pCategory;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pPrice = pPrice;
		this.pImage = pImage;
		this.pHit = pHit;
		this.pDate = pDate;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public int getpHit() {
		return pHit;
	}

	public void setpHit(int pHit) {
		this.pHit = pHit;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	@Override
	public String toString() {
		return "PostDTO [pNum=" + pNum + ", userid=" + userid + ", pCategory=" + pCategory + ", pTitle=" + pTitle
				+ ", pContent=" + pContent + ", pPrice=" + pPrice + ", pImage=" + pImage + ", pHit=" + pHit + ", pDate="
				+ pDate + "]";
	}

}
