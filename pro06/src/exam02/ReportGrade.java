package exam02;

import java.util.Arrays;

public class ReportGrade {
	
	private String name;
	private String [] subjects;
	private double [] grades;
	
	public ReportGrade() {
	}
	
	public ReportGrade(String name) {
		this.name = name;
	}
	
	public ReportGrade(String name,  String [] subjects) {
		this.name = name;
		this.subjects = subjects;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubject(String[] subjects) {
		this.subjects = subjects;
	}

	public double[] getGrades() {
		return grades;
	}
	
	public void setGrades(double[] grades) {
		this.grades = grades;
	}
	
	public void setGrades(String subject, double grade) {
		int idx = -1;
		for(int i = 0; i < subjects.length; i++) {
			if(this.subjects[i].equals(subject)) {
				idx = i;
				break;
			}
		}
		this.grades[idx] = grade;
	}
	
	public double getGrades(String subject) {
		int idx = -1;
		for(int i = 0; i < this.subjects.length; i++) {
			if(this.subjects[i].equals(subject)) {
				idx = i;
				break;
			}
		}
		return this.grades[idx];
	}
	
	public void addSubject(String subject) {
		// 점수는 0점으로 추가
		this.addSubject(subject, 0);
	}
	
	public void addSubject(String subject, double grade) {
		// 점수는 grade 값으로 추가
		String [] subjects = Arrays.copyOf(this.subjects, this.subjects.length + 1);
		this.subjects[this.subjects.length - 1] = subject;
		
		double [] grades = Arrays.copyOf(this.grades, this.grades.length + 1);
		this.grades[this.grades.length - 1] = grade;
	}
	
	

}
