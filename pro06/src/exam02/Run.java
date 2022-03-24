package exam02;

import java.util.Arrays;

public class Run {

	public static void main(String[] args) {
		
		ReportGrade report = new ReportGrade();
		
		double[] grades = new double[] {78.5, 79.3, 87.2, 93.8, 93.4};
		String [] subjecs = new String[] {"국어", "영어", "수학", "사회", "체육"};
		
		report.setGrades(grades);
		report.setSubject(subjecs);
		
		report.setGrades("수학", 92.5);
		System.out.println(Arrays.toString(report.getGrades()));
		
		System.out.println(report.getGrades("사회"));
		
		report.addSubject("과학", 86.9);
		System.out.println(Arrays.toString(report.getSubjects()));
		System.out.println(Arrays.toString(report.getGrades()));
		
		

	}

}
