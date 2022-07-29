package dept.service;

import java.util.ArrayList;
import java.util.List;

import dept.model.DeptDAO;
import dept.model.DeptDTO;

public class DeptService {
	
	private DeptDAO dao;
	
	public List<DeptDTO> getAll() {
		dao =  new DeptDAO();
		
		List<DeptDTO> datas = dao.searchAll();
		
		dao.close();
		return datas;
	}
	
	public DeptDTO getId(String id) {
		return _getId(Integer.parseInt(id));
	}
	
	public DeptDTO getId(int id) {
		return _getId(id);
	}
	
	public DeptDTO getId(DeptDTO deptDto) {
		return _getId(deptDto.getDeptId());
	}
	
	private DeptDTO _getId(int id) {
		dao = new DeptDAO();
		
		DeptDTO data = dao.searchId(id);
		
		dao.close();
		return data;
	}

	public DeptDTO addDept(String deptId, String deptName, String mngId, String locId) {
		dao = new DeptDAO();
		
		DeptDTO deptDto = null;
		if(deptId.matches("\\d+") && mngId.matches("\\d+") && locId.matches("\\d+")) {
			boolean isValid = true;
			deptDto = new DeptDTO();
			deptDto.setDeptId(Integer.parseInt(deptId));
			deptDto.setDeptName(deptName);
			deptDto.setMngId(Integer.parseInt(mngId));
			deptDto.setLocId(Integer.parseInt(locId));
			
			if(dao.searchId(deptDto.getDeptId()) != null) {
				deptDto.setDeptId(-1);
				isValid = false;
			}
			
			if(!dao.existManager(deptDto.getMngId())) {
				deptDto.setMngId(-1);
				isValid = false;
			}
			
			if(!dao.existLocation(deptDto.getLocId())) {
				deptDto.setLocId(-1);
				isValid = false;
			}
			
			if(isValid) {
				boolean isSaved = dao.insertDept(deptDto);
				if(isSaved) {
					dao.commit();
					dao.close();
					return deptDto;
				} else {
					dao.rollback();
					dao.close();
					return null;
				}
			}	
		}
		
		dao.commit();
		dao.close();
		return deptDto;
	}

	public int modifyDept(DeptDTO data) {
		dao = new DeptDAO();
		
		if(!dao.existManager(data.getMngId())) {
			dao.close();
			return -1;
		}
		
		if(!dao.existLocation(data.getLocId())) {
			dao.close();
			return -2;
		}
		
		boolean isSaved = dao.updateDept(data);
		dao.close();
		
		if(isSaved) {
			return 1;
		}
		
		return 0;
	}

	public int deleteDept(String id) {
		dao = new DeptDAO();

		if(dao.searchId(Integer.parseInt(id)) == null) {
			dao.close();
			return -1;	// 삭제 대상이 없음을 알림
		}
		
		boolean result = dao.deletDept(Integer.parseInt(id));
		
		if(result) {
			dao.commit();
			dao.close();
			return 1;
		}
		dao.rollback();
		dao.close();
		return 0;
	}

	public List<DeptDTO> getPage(int page, int pageCount) {
		int pageNumber = page;
		int start, end;
		start = (pageNumber - 1) * pageCount;
		end = pageCount;
		dao = new DeptDAO();
		List<DeptDTO> datas = dao.searchPage(start, end);
		dao.close();
		return datas;
	}

	public List<Integer> getPageList(int pageCount) {
		dao = new DeptDAO();
		
		List<Integer> pageList = new ArrayList<Integer>();
		int total = dao.totalRow();
		
		for(int num = 0; num <= (total - 1) / pageCount; num++) {
			pageList.add(num + 1);
		}
		
		return pageList;
	}

	public boolean existsManager(String value) {
		dao = new DeptDAO();
		boolean result = dao.selectManager(Integer.parseInt(value));
		dao.close();
		return result;
	}

	public boolean existsLocation(String value) {
		dao = new DeptDAO();
		boolean result = dao.selectLocation(Integer.parseInt(value));
		dao.close();
		return result;
	}
}
