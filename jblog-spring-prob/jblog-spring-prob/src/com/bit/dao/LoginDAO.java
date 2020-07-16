package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.util.ConnectionPool;
import com.bit.vo.LoginVO;

public class LoginDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private StringBuilder sql = new StringBuilder();

	
	
	public LoginVO login(LoginVO login) {
		LoginVO user = null;
		try {
			sql.delete(0, sql.length());
			con = ConnectionPool.getConnection();
			sql.append(" SELECT id, password, name, type ");
			sql.append(" FROM member  ");
			sql.append(" WHERE id = ? AND password = ? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new LoginVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setType(rs.getString("type"));
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
		return user;
	}
}
