package com.bit.vo;

public class CommentVO {
	private int commentNo;
	private int boardNo;
	private String comment_id;
	private String comment_content;
	private String comment_reg_date;
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_reg_date() {
		return comment_reg_date;
	}
	public void setComment_reg_date(String comment_reg_date) {
		this.comment_reg_date = comment_reg_date;
	}
	
	
}
