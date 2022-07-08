package locs.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import conn.db.DBConn;

public class LocsDAO {
	
	SqlSession session = null;
	
	public LocsDAO() {
		session = DBConn.getSqlSession();
	}
	
	public List<LocsDTO> searchAll() {
		List<LocsDTO> datas = session.selectList("locsMapper.locsSelectAll");
		return datas;
	}
	
	public LocsDTO searchId(int id) {
		LocsDTO data = session.selectOne("locsMapper.locsSelectId", id);
		return data;
	}

	public void close() {
		session.close();
	}

	public boolean exisCountryId(String id) {
		int result = session.selectOne("locsMapper.exitCountryId", id);
		if(result == 1) {
			return true;
		}
		return false;
	}

	public boolean insertLocs(LocsDTO locsDto) {
		int result = session.insert("locsMapper.locsInsert", locsDto);
		if(result == 1) {
			session.commit();
			return true;
		}
		session.rollback();
		return false;
	}

	public void commit() {
		session.commit();
	}

	public void rollback() {
		session.rollback();
	}

	public boolean updateLocs(LocsDTO locsDto) {
		int result = session.update("locsMapper.locsUpdate", locsDto);
		if(result == 1) {
			return true;
		}
		return false;
	}
}
