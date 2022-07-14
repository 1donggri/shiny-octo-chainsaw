package emps.model;

import java.sql.Date;

public class EmpDetailDTO {
	private int empId;
	private String phone;
	private Date hirDate;
	private int salary;
	private double commission;
	private int mngId;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Date getHirDate() {
		return hirDate;
	}
	
	public void setHirDate(Date hirDate) {
		this.hirDate = hirDate;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public double getCommission() {
		return commission;
	}
	
	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	public int getMngId() {
		return mngId;
	}
	
	public void setMngId(int mngId) {
		this.mngId = mngId;
	}
	
	

}
