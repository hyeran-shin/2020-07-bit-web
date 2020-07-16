package com.bit.mysite.vo;

public class GuestVo {

	private int no;
	private String writer;
	private String content;
	private String regDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	@Override
	public String toString() {
		return "GuestVo [no=" + no + ", writer=" + writer + ", content=" + content + ", regDate=" + regDate + "]";
	}

	
	
}
