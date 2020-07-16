package com.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class ConnectionPool {
	private static final int INIT_COUNT = 5;
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jblog?serverTimezone=UTC";
	private static ArrayList<Connection> freeList = new ArrayList<>();
	private static ArrayList<Connection> usedList = new ArrayList<>();

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			for (int i = 0; i < INIT_COUNT; i++) {
				freeList.add(DriverManager.getConnection(URL, "root", "root"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Connection getConnection() throws Exception{
		if(freeList.isEmpty()) {
			throw new Exception("사용 가능한 Connection 없음.");
		}
		Connection con = freeList.remove(0);
		usedList.add(con);
		return con;
	}
	
	public static void close(Connection con) {
		usedList.remove(usedList.indexOf(con));
		freeList.add(con);
	}

}
