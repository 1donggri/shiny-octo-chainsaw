package com.res;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.conn.db.DBConn;

public class ResDAO {
	
	private DBConn db;
	
	public ResDAO() {
		try {
			db = new DBConn(new File(System.getProperty("user.home") + "/semi_db.conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 맛집 등록 처리
	public boolean register(ResVO data) {
		String query = "INSERT INTO restaurant_t VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getRes_name());
			pstat.setString(2, data.getRes_type());
			pstat.setString(3, data.getLocation());
			pstat.setInt(4, data.getRes_likes());
			
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
	
	// res_name 에 해당하는 맛집 정보 반환
	public ResVO get(String res_name) {
		String query = "SELECT * FROM restaurant_t WHERE RES_NAME = ?";
		PreparedStatement pstat;
		try {
			pstat = db.getPstat(query);
			pstat.setString(1, res_name);
			
			ResultSet rs = db.sendSelectQuery();
			if(rs.next()) {
				ResVO data = new ResVO();
				data.setRes_name(rs.getString("res_name"));
				data.setRes_type(rs.getString("res_type"));
				data.setLocation(rs.getString("location"));
				data.setRes_likes(rs.getInt("res_likes"));
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// res_name 과 location 해당하는 맛집 정보 반환
	public ResVO get(String res_name, String location) {
		String query = "SELECT * FROM restaurant_t WHERE RES_NAME = ? AND location = ?";
		PreparedStatement pstat;
		try {
			pstat = db.getPstat(query);
			pstat.setString(1, res_name);
			pstat.setString(2, location);
			
			ResultSet rs = db.sendSelectQuery();
			if(rs.next()) {
				ResVO data = new ResVO();
				data.setRes_name(rs.getString("res_name"));
				data.setRes_type(rs.getString("res_type"));
				data.setLocation(rs.getString("location"));
				data.setRes_likes(rs.getInt("res_likes"));
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
