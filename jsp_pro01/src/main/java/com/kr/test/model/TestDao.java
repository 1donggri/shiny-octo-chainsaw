package com.kr.test.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import conn.db.DBConn;

public class TestDao {
	
	SqlSession session = null;
	
	public TestDao() {
		session = DBConn.getSqlSession();
	}
	
	public List<Test> selectList() {
		List<Test> datas = session.selectList("testMapper.selectAll");
		return datas;
	}
}
