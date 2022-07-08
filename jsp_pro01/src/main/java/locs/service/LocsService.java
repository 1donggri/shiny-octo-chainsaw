package locs.service;

import java.util.List;

import javax.websocket.DeploymentException;

import locs.model.LocsDAO;
import locs.model.LocsDTO;

public class LocsService {
	
	private LocsDAO dao;
	
	public List<LocsDTO> getAll() {
		dao = new LocsDAO();
		
		List<LocsDTO> datas = dao.searchAll();
		
		dao.close();
		return datas;
	}
	
	public LocsDTO getId(String id) {
		return _getId(Integer.parseInt(id));
	}
	
	public LocsDTO getId(int id) {
		return _getId(id);
	}
	
	public LocsDTO getId(LocsDTO locsDto) {
		return _getId(locsDto.getLocsId());
	}
	
	private LocsDTO _getId(int id) {
		dao = new LocsDAO();
		
		LocsDTO data = dao.searchId(id);
		
		dao.close();
		return data;
	}

	public LocsDTO addLocs(String locsId, String streetAddress, String postalCode, String city, String stateProvince,
			String countryId) {
		dao = new LocsDAO();
		
		LocsDTO locsDto = null;
		if(locsId.matches("\\d+") && countryId.matches("\\d+")) {
			locsDto = new LocsDTO();
			locsDto.setLocsId(Integer.parseInt(locsId));
			locsDto.setStreetAddress(streetAddress);
			locsDto.setPostalCode(postalCode);
			locsDto.setStateProvince(stateProvince);
			locsDto.setCity(city);
			locsDto.setCountryId(countryId);
			
			if(dao.searchId(locsDto.getLocsId()) != null) {
				locsDto.setLocsId(-1);
				dao.rollback();
				dao.close();
				return locsDto;
			}
			
			if(dao.exisCountryId(locsDto.getCountryId())) {
				locsDto.setCountryId("-1");
				dao.rollback();
				dao.close();
				return locsDto;
			}
			
			boolean isSaved = dao.insertLocs(locsDto);
			
			if(!isSaved) {
				dao.close();
				return null;
			}
		}
		dao.commit();
		dao.close();
		return locsDto;
	}

	public int modifyLocs(LocsDTO data) {
		dao = new LocsDAO();
		
		if(!dao.exisCountryId(data.getCountryId())) {
			dao.rollback();
			dao.close();
			return -1;
		}
		
		boolean isSaved = dao.updateLocs(data);
		
		if(isSaved) {
			dao.commit();
			dao.close();
			return 1;
		}
		
		dao.rollback();
		dao.close();
		return 0;
	}

}
