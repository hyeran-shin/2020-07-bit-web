package com.bit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConfig {
	private static SqlSession session = null;
	private String resource ="mybatis-config.xml";
	
	public MyConfig() {
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			session = sqlSessionFactory.openSession();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getInstance() {
		return session;
	}
}
