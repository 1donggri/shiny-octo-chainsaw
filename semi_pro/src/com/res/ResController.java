package com.res;

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

}
