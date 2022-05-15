package com.join;

/*
 * 회원 가입, 로그인 중간 제어용 객체
 */

public class JoinController {
	
	private JoinDAO dao = new JoinDAO();
	
	public boolean join(JoinVO data) {
		
		JoinVO account = dao.get(data.getUserID());
		
		if(account != null) {
			return false;
		}
		
		boolean result = dao.register(data);
		return result;
	}
	
	public JoinVO login(String userid, String userpw) {
		JoinVO data = dao.get(userid);
		
		if(data.getUserPW().equals(userpw)) {
			return data;
		}
		
		return null;
	}

}
