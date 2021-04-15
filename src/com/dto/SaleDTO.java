package com.dto;

public class SaleDTO {
	private int pNum;
	private String nickName;
	private String pTitle;
	private String pImage;
	private int pPrice;
	public SaleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaleDTO(int pNum, String nickName, String pTitle, String pImage, int pPrice) {
		super();
		this.pNum = pNum;
		this.nickName = nickName;
		this.pTitle = pTitle;
		this.pImage = pImage;
		this.pPrice = pPrice;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	@Override
	public String toString() {
		return "SaleDTO [pNum=" + pNum + ", nickName=" + nickName + ", pTitle=" + pTitle + ", pImage=" + pImage
				+ ", pPrice=" + pPrice + "]";
	}
	
}
