package com.res;

import java.util.ArrayList;

import com.join.JoinDAO;

public class ResController {
	
	private ResDAO dao = new ResDAO();
	
	public boolean join(ResVO data) {
		// 같은 지역 내에 동일한 이름의 맛집이 등록되어 있다면 등록하지 못하게 함
		ResVO res = dao.get(data.getRes_name(), data.getLocation());
		
		if(res != null) {
			return false;
		}
		
		boolean result = dao.register(data);
		return result;
	}
	
	public ResVO search(String resname, String location) {
		// 수정 또는 삭제 전 검색 제어
		return dao.get(resname, location);
	}
	
	public ArrayList locationLank(String location) {
		// 지역별 랭킹 조회
		return dao.locationLank(location);
	}
	
	public ArrayList typeLank(String type) {
		// 카테고리별 랭킹 조회
		return dao.typeLank(type);
	}
	
	public ArrayList resList(String type, String location) {
		// 조건별 맛집 리스트 검색
		return dao.resList(type, location);
	}
	
	public boolean update(ResVO data) {
		// 맛집 정보 수정
		return dao.update(data);
	}
	
	public boolean delete(ResVO data) {
		// 맛집 정보 삭제
		return dao.delete(data);
	}

}
