package controller;

import model.vo.Teacher;

public class TeacherDatabaseManager {
	private Teacher[] datas;
	
	// 테스트용 초기 데이터 : 나중에는 삭제할 것임.
	{
		datas = new Teacher[2];
		datas[0] = new Teacher("고명환", "a1234");
		datas[1] = new Teacher("김수덕", "a1111");
	}
	
	public Teacher login(String name, String password) {
		// Teacher 배열에 존재하는 객체들 중 동일한
		// 이름, 패스워드를 사용하는 객체가 있는지 검사 후
		// 동일한 객체가 있으면 해당하는 Teacher 객체를 반환
		// 동일한 객체가 없으면 null 반환
		
		Teacher t = null;
		for(int i = 0; i < datas.length; i++) {
			if(datas[i].getName().equals(name) && datas[i].getPassword().equals(password)) {
					t = new Teacher(name, password);
			}
		}
		return t;
	}
	
	private int _findIndex(String name) {
		int idx = -1;
		for(int i = 0; i < datas.length; i++) {
			if(datas[i].getName().equals(name)) {
				idx = i;
			}
		}
		return idx;
	}
	
	public Teacher getTeacher(String name) {
		return datas[_findIndex(name)];
	}
	
	public boolean isExisted(String name) {
		return _findIndex(name) != -1 ? true : false;
	}

}
