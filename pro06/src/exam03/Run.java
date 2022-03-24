package exam03;

public class Run {

	public static void main(String[] args) {
		
		Student s1 = new Student("홍길동", 13);
		s1.nextYear();
		System.out.println(s1.getName());
		System.out.println(s1.getAge());
		System.out.println(s1.getGrade());
		
		System.out.print("\n");
		s1.nextYear();
		System.out.println(s1.getName());
		System.out.println(s1.getAge());
		System.out.println(s1.getGrade());
		
		System.out.print("\n");
		s1.nextYear();
		System.out.println(s1.getName());
		System.out.println(s1.getAge());
		System.out.println(s1.getGrade());
		

	}

}
