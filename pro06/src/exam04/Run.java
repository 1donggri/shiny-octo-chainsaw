package exam04;

public class Run {

	public static void main(String[] args) {
		Page book = new Page(100);
		System.out.println(book.getPage() + " page");
		
		book.nextPage();
		System.out.println(book.getPage() + " page");
		
		book.nextPage(60);
		System.out.println(book.getPage() + " page");
		
		book.nextPage(50);	// 한계를 넘는 요청
		
		book.prePage();
		System.out.println(book.getPage() + " page");
		
		book.prePage(70);	// 한계를 넘는 요청

	}

}
