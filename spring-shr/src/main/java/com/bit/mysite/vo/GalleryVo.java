package com.bit.mysite.vo;

public class GalleryVo {
	private Long no;
	private String orgFileName;
	private String saveFileName;
	private String comments;
	private Long fileSize;
	private String fileExtName;
	private String regDate;
	private int productNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileExtName() {
		return fileExtName;
	}

	public void setFileExtName(String fileExtName) {
		this.fileExtName = fileExtName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", orgFileName=" + orgFileName + ", saveFileName=" + saveFileName + ", comments="
				+ comments + ", fileSize=" + fileSize + ", fileExtName=" + fileExtName + ", regDate=" + regDate
				+ ", productNo=" + productNo + "]";
	}

}
