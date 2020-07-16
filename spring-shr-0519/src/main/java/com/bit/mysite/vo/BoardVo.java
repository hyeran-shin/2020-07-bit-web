package com.bit.mysite.vo;

public class BoardVo {
	private int no;
	private String title;
	private String content;
	private String regDate;
	private Integer hit;
	private Integer groupNo;
	private Integer orderNo;
	private Integer depth;
	private int usersNo;
	private String userName;
	private int boardPublic;
	private String usersType;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	public Integer getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Integer groupNo) {
		this.groupNo = groupNo;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public int getUsersNo() {
		return usersNo;
	}
	public void setUsersNo(int usersNo) {
		this.usersNo = usersNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getBoardPublic() {
		return boardPublic;
	}
	public void setBoardPublic(int boardPublic) {
		this.boardPublic = boardPublic;
	}
	public String getUsersType() {
		return usersType;
	}
	public void setUsersType(String usersType) {
		this.usersType = usersType;
	}
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", hit="
				+ hit + ", groupNo=" + groupNo + ", orderNo=" + orderNo + ", depth=" + depth + ", usersNo=" + usersNo
				+ ", userName=" + userName + ", boardPublic=" + boardPublic + ", usersType=" + usersType + "]";
	}
	
	
	
}
