package com.myhome.web.board.model;

import java.sql.Date;

public class BoardStatisDTO {
	private int id;
	private int empId;
	private int bId;
	private boolean view;
	private Date lastestView;
	private boolean like;
	private Date lastestLike;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public int getbId() {
		return bId;
	}
	
	public void setbId(int bId) {
		this.bId = bId;
	}
	
	public boolean isView() {
		return view;
	}
	
	public void setView(boolean view) {
		this.view = view;
	}
	
	public boolean isLike() {
		return like;
	}
	
	public void setLike(boolean like) {
		this.like = like;
	}

	public Date getLastestView() {
		return lastestView;
	}

	public void setLastestView(Date lastestView) {
		this.lastestView = lastestView;
	}

	public Date getLastestLike() {
		return lastestLike;
	}

	public void setLastestLike(Date lastestLike) {
		this.lastestLike = lastestLike;
	}

	@Override
	public String toString() {
		return "EmpBoardStatisDTO [id=" + id + ", empId=" + empId + ", bId=" + bId + ", view=" + view + ", lastestView="
				+ lastestView + ", like=" + like + ", lastestLike=" + lastestLike + "]";
	}
	
	
}
