package exam04;

public class Page {
	private int number = 0;
	private int limit;
	
	public Page() {}
	
	public Page(int limit) {
		this.limit = limit;
	}
	
	public int getPage() {
		return number;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void nextPage() {
		nextPage(1);
	}
	
	public void nextPage(int page) {
		if(this.existsNextPage(page)) {
			this.number += page;
		} else {
			System.out.println("더 이상 페이지를 넘길 수 없습니다.");
		}
	}
	
	public void prePage() {
		prePage(1);
	}
	
	public void prePage(int page) {
		if(existsPrePage(page)) {
			this.number -= page;
		} else {
			System.out.println("더 이상 페이지를 넘길 수 없습니다.");
		}
	}
	
	public boolean existsNextPage(int page) {
		if(this.number + page > this.limit) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean existsPrePage(int page) {
		if(this.number - page < 1) {
			return false;
		} else {
			return true;
		}
	}

}
