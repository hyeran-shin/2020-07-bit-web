package com.bit.board;


/*
	 CREATE TABLE m_board(
	  no	 INT AUTO_INCREMENT,
	  title  VARCHAR(200) NOT NULL,
	  content VARCHAR(4000),
	  PRIMARY KEY(no)
	 );
 */

public class BoardVo {
	private int no;
	private String title;
	private String content;
	private int[] nos; // 모든 번호 들
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
	public int[] getNos() {
		return nos;
	}
	public void setNos(int[] nos) {
		this.nos = nos;
	}
	@Override
	public String toString() {
		return "BoardVo [no = " + no + ", title = " + title + ", content = " + content + "]";
	}
	
	
}
