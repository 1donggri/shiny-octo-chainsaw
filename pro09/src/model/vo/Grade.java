package model.vo;

import exception.GradeLevelException;
import exception.GradeScoreException;

// 과목에 대한 성적 정보를 가지는 클래스
public class Grade extends Subject {
	/*
	 * 점수와(score)와 등급(level)을 정의
	 * getter/setter 도 작성
	 */
	private double score;
	private char level = 'F';
	
	public Grade(String name) {
		super(name);
	}
	
	public double getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "Grade [Name()=" + getName() + ", score=" + score + ", level=" + level + "]";
	}

	public void setScore(double score) {
		if(!(score >= 0 && score <= 100)) {
			throw new GradeScoreException("성적 점수의 범위는 0 ~ 100 사이의 값으로 설정하세요");
		}
		this.score = score;
		
		if(score <= 100 && score >= 90) {
			setLevel('A');
		} else if(score < 90 && score >= 80) {
			setLevel('B');
		} else if(score < 80 && score >= 70) {
			setLevel('C');
		} else if(score < 70 && score >= 60) {
			setLevel('D');
		} else if(score < 60 && score >= 40) {
			setLevel('E');
		} else if(score < 40) {
			setLevel('F');
		}
	}
	
	public char getLevel() {
		return level;
	}
	
	public void setLevel(char level) {
		if(!(level >= 'A' && level <= 'F')) {
			throw new GradeLevelException("등급은 'A' ~ 'F' 까지만 설정할 수 있습니다.");
		}
		this.level = level;
	}
	
	
	

}
