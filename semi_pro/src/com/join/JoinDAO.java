package com.join;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.conn.db.DBConn;

/*
 * 데이터베이스에 직접 엑세스 하기 위한 객체
 */

public class JoinDAO {
	
	private DBConn db;
	
	public JoinDAO() {
		try {
			db = new DBConn(new File(System.getProperty("user.home") + "/semi_db.conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원 가입 처리
	public boolean register(JoinVO data) {
		String query = "INSERT INTO account_t VALUES(?, ?, ?, SYSDATE)";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getUserID());
			pstat.setString(2, data.getUserPW());
			pstat.setString(3, data.getUsername());
			
			int rs = db.sendInsertQuery();
			if(rs == 1) {
				db.commit();
				return true;
			}
			db.rollback();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// userID 에 해당하는 회원 정보 반환
	public JoinVO get(String userid) {
		String query = "SELECT * FROM account_t WHERE USERID = ?";
		PreparedStatement pstat;
		try {
			pstat = db.getPstat(query);
			pstat.setString(1, userid);
			
			ResultSet rs = db.sendSelectQuery();
			if(rs.next()) {
				JoinVO data = new JoinVO();
				data.setUserID(rs.getString("userid"));
				data.setUserPW(rs.getString("userpw"));
				data.setUsername(rs.getString("username"));
				data.setCreateDate(rs.getDate("createdate"));
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
