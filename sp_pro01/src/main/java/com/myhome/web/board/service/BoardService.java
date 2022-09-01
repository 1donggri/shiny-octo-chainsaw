package com.myhome.web.board.service;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myhome.web.board.controller.BoardController;
import com.myhome.web.board.model.BoardDAO;
import com.myhome.web.board.model.BoardDTO;
import com.myhome.web.board.model.BoardStatisDTO;
import com.myhome.web.board.vo.BoardVO;
import com.myhome.web.common.util.Paging;
import com.myhome.web.emp.model.EmpDTO;

@Service
public class BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardDAO dao;
	
	public List<BoardDTO> getAll() {
		logger.info("getAll()");
		List<BoardDTO> datas = dao.selectAll();
		return datas;
	}
	
	@Transactional
	public Paging getPage(int page, int limit) {
		logger.info("getPage(page={}, limit={})", page, limit);
		int totalRows = dao.getTotalRows();
		
		Paging paging = new Paging(page, limit, totalRows);
		dao.selectPage(paging);
		return paging;
	}
	
	public BoardDTO getData(int id) {
		logger.info("getData(id={})", id);
		BoardDTO data = dao.selectData(id);
		return data;
	}
	
    public int add(EmpDTO empDto, BoardVO data) {
    	logger.info("add(empDto={}, data={})", empDto, data);
    	BoardDTO boardDto = new BoardDTO();
    	boardDto.setTitle(data.getTitle());
    	boardDto.setContent(data.getContent());
    	boardDto.setEmpId(empDto.getEmpId());
    	
    	boolean result = dao.insertData(boardDto);
    	
    	if(result) {
    		return boardDto.getId();
    	}
    	return 0;
    }
    
	public boolean modify(BoardDTO data) {
		boolean result = dao.updateData(data);
		return result;
	}

	/*

	public void incViewCnt(BoardDTO data) {
		
		boolean result = false;
		BoardStatisDTO statisData = dao.selectStatis(data);
		if(statisData == null) {
			result = dao.updateViewCnt(data);
			dao.insertStatis(data);
		} else {
			java.util.Date now = new java.util.Date();
			long timeDiff = now.getTime() - statisData.getLastestView().getTime();
			if(timeDiff / (1000 * 60 * 60 * 24) >= 7) {
				result = dao.updateViewCnt(data);
				dao.updateStatis(statisData);
			}
		}
		if(result) {
			data.setViewCnt(data.getViewCnt() + 1);
			dao.commit();
		} else {
			dao.rollback();
		}
	}

	public void incLike(BoardDTO data) {
		boolean result = dao.updateLike(data);
		if(result) {
			data.setLike(data.getLike() + 1);
			dao.commit();
		} else {
			dao.rollback();
		}
	}
	*/

}