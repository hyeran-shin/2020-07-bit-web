package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bit.util.ConnectionPool;
import com.bit.vo.CommentVO;

public class CommentDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private StringBuilder sql = new StringBuilder();

	// 댓글 조회
	public List<CommentVO> selectAllComment(CommentVO comment) {
		List<CommentVO> commentList = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append("  SELECT * FROM comment  ");
			sql.append("  WHERE board_no = ?  order by  comment_reg_date desc 	 ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, comment.getBoardNo());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentVO c = new CommentVO();
				c.setCommentNo(rs.getInt("comment_no"));
				c.setBoardNo(rs.getInt("board_no"));
				c.setComment_id(rs.getString("comment_id"));
				c.setComment_content(rs.getString("comment_content"));
				c.setComment_reg_date(rs.getString("comment_reg_date"));
				commentList.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}
		return commentList;
	}

	// 댓글 등록
	public int insertComment(CommentVO comment) {
		int result = -1;
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append("  INSERT INTO comment(board_no, comment_id, comment_content)  ");
			sql.append("  VALUES(? , ? , ? ) 	 ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, comment.getBoardNo());
			pstmt.setString(2, comment.getComment_id());
			pstmt.setString(3, comment.getComment_content());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}
		return result;
	}
	

	// 댓글 삭제
	public int deleteComment(CommentVO comment) {
		int result = -1;
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append("  DELETE FROM comment  ");
			sql.append("  WHERE board_no = ? and comment_no = ?");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, comment.getBoardNo());
			pstmt.setInt(2, comment.getCommentNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}
		return result;
	}

	
	
}
