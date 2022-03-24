package exam01;

public class Grade {
	private String name;
	private double score;
	private char rank;
	
	public Grade() {}
	
	public Grade(String name) {
		this.name = name;
	}
	
	public Grade(String name, double score) {
		this.name = name;
		this.setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		if(score <= 100 && score >= 0) {
			this.score = score;
		} else {
			this.score = 0;
		}
		this._setRank();
	}
	
	private void _setRank() {
		/*
		 * 점수가 설정되면 여기에 등급을 분류하기 위한 코드를 작성
		 * A: 100 이하 ~ 90 이상, B: 90 미만 ~ 80 이상, C: 80 미만 ~ 70 이상
		 * D: 70 미만 ~ 60 이상, E: 60 미만 ~ 40 이상, F: 40 미만
		 */
		if(score >= 90 && score <= 100) {
			this.rank = 'A';
		} else if(score >= 80 && score < 90) {
			this.rank = 'B';
		} else if(score >= 70 && score < 80) {
			this.rank = 'C';
		} else if(score >= 60 && score < 70) {
			this.rank = 'D';
		} else if(score >= 40 && score < 60) {
			this.rank = 'E';
		} else if(score < 40) {
			this.rank = 'F';
		}
	}

	public char getRank() {
		return rank;
	}

}
