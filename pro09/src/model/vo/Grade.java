package model.vo;

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
		this.level = level;
	}
	
	
	

}
