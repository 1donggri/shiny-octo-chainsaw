package com.myhome.web.board.model;
import java.util.*;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.web.board.controller.BoardController;
import com.myhome.web.common.util.Paging;

@Repository
public class BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private SqlSession session;
	 
	public List<BoardDTO> selectAll() {
		List<BoardDTO> result = session.selectList("boardMapper.selectAll");
		return result;
	}
	
	public int getTotalRows() {
		logger.info("getTotalRows()");
		int result = session.selectOne("boardMapper.getTotalRows");
		return result;
	}
	
	public void selectPage(Paging paging) {
		logger.info("selectPage(paging={})", paging);
		RowBounds rb = new RowBounds(paging.getOffset(), paging.getLimit());
		Cursor<Object> cursor = session.selectCursor("boardMapper.selectPage", null, rb);
		paging.setPageDatas(cursor.iterator());
	}
	
    
	public BoardDTO selectData(int id) {
		BoardDTO result = session.selectOne("boardMapper.selectData", id);
		return result;
	}
	
    public boolean insertData(BoardDTO data) {
    	logger.info("insertData(data={})", data);
    	int result = 0;
    	if(data.getId() == 0) {
    		result = session.insert("boardMapper.insertDataAutoSeq", data);
    	} else {
    		result = session.insert("boardMapper.insertData", data);
    	}
    	return result == 1 ? true : false;
    }
    
	public boolean updateData(BoardDTO data) {
		int result = session.update("boardMapper.updateData", data);
		return result == 1 ? true : false;
	}

	/*
	
	public boolean updateViewCnt(BoardDTO data) {
		int result = session.update("boardMapper.updateViewCnt", data);
		return result == 1 ? true : false;
	}
	
	public boolean updateLike(BoardDTO data) {
		int result = session.update("boardMapper.updateLike", data);
		return result == 1 ? true : false;
	}
	
	public BoardStatisDTO selectStatis(BoardDTO data) {
		BoardStatisDTO result = session.selectOne("boardMapper.selectStatis", data);
		return result;
	}
	
	public boolean insertStatis(BoardDTO data) {
		int result = session.insert("boardMapper.insertStatis", data);
		return result == 1 ? true : false;
	}
	
	public boolean updateStatis(BoardStatisDTO data) {
		int result = session.insert("boardMapper.updateStatis", data);
		return result == 1 ? true : false;
	}

	public void commit() {
		this.session.commit();
	}

	public void rollback() {
		this.session.rollback();
	}

	public void close() {
		this.session.close();
	}

	public int getNextSeq() {
		int result = session.selectOne("boardsMapper.getNextSeq");
		return result;
	}
	*/

}