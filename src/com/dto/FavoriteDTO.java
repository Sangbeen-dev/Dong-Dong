package com.dto;

public class FavoriteDTO {
	private String pNum;
	private String userId;
	private String pCategory;
	private String pTitle;
	private String pContent;
	private int pPrice;
	private String pImage;
	private int pHIt;
	public FavoriteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FavoriteDTO(String pNum, String userId, String pCategory, String pTitle, String pContent, int pPrice,
			String pImage, int pHIt) {
		super();
		this.pNum = pNum;
		this.userId = userId;
		this.pCategory = pCategory;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pPrice = pPrice;
		this.pImage = pImage;
		this.pHIt = pHIt;
	}
	public String getpNum() {
		return pNum;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public int getpHIt() {
		return pHIt;
	}
	public void setpHIt(int pHIt) {
		this.pHIt = pHIt;
	}
	@Override
	public String toString() {
		return "FavoriteDTO [pNum=" + pNum + ", userId=" + userId + ", pCategory=" + pCategory + ", pTitle=" + pTitle
				+ ", pContent=" + pContent + ", pPrice=" + pPrice + ", pImage=" + pImage + ", pHIt=" + pHIt + "]";
	}
	
	
}
