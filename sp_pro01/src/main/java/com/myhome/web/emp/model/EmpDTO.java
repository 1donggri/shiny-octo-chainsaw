package com.myhome.web.emp.model;

public class EmpDTO {
	private int empId;
	private String empName;
	private String email;
	private String jobName;
	private String jobId;
	private String deptName;
	private int deptId;
	private String empFirstName;
	private String empLastName;
	
	public EmpDTO() {}
	
	public EmpDTO(int empId, String empName) {
		this.empId = empId;
		this.setEmpName(empName);
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	public void setDeptId(String deptId) {
		this.deptId = Integer.parseInt(deptId);
	}

	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = Integer.parseInt(empId);
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		String fullName[] = empName.split(" ", 2);
		if(fullName.length == 2) {
			this.empFirstName = fullName[0];
			this.empLastName = fullName[1];
		}
		this.empName = empName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getJobName() {
		return jobName;
	}
	
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "EmpDTO [empId=" + empId + ", empName=" + empName + ", email=" + email + ", jobName=" + jobName
				+ ", jobId=" + jobId + ", deptName=" + deptName + ", deptId=" + deptId + ", empFirstName="
				+ empFirstName + ", empLastName=" + empLastName + "]";
	}

	
	
	
}
