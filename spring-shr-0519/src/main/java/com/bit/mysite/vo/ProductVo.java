package com.bit.mysite.vo;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductVo {
	private int productNo;
	
	@NotEmpty
	private String productName;
	
	@NotNull
	@Min(1)
	private int productPrice;
	 
	 
	@NotNull
	@Min(1)
	private int productCount;
	
	private String productComment;
	private String regDate;
	
	private List<GalleryVo> imageList;
	
	
	
	public List<GalleryVo> getImageList() {
		return imageList;
	}
	public void setImageList(List<GalleryVo> imageList) {
		this.imageList = imageList;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public String getProductComment() {
		return productComment;
	}
	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "ProductVo [productNo=" + productNo + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCount=" + productCount + ", productComment=" + productComment + ", regDate=" + regDate
				+ "]";
	}
	
	
}
