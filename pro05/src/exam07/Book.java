package exam07;

public class Book {
	
	public String title;		// 책이름
	public String writer;		// 작가
	public int rentDays;		// 대여기간
	public int codeNumber;		// 코드번호
	public int rentPrice;		// 대여금액
	public String publisher;	// 출판사
	public String category;		// 분류
	public String libraryName;	// 책보유도서관
	
	public Book() {
	}
	
	public Book(String title) {
		this.title = title;
	}
	
	public Book(String title, int codeNumber) {
		this(title);
		this.codeNumber = codeNumber;
	}
	
	public Book(String title, int codeNumber, String writer) {
		this(title, codeNumber);
		this.writer = writer;
	}
	
	public Book(String title, int codeNumber, String writer, int rentDays) {
		this(title, codeNumber, writer);
		this.rentDays = rentDays;
	}
	
	public Book(String title, int codeNumber, String writer, int rentDays, int rentprice) {
		this(title, codeNumber, writer, rentDays);
		this.rentPrice = rentPrice;
	}

}
