package exam07;

public class Initialize {
	public int num1;
	public static String name1;
	
	public int num2 = 10;
	public static String name2 = "java";
	
	public int num3 = 20;
	public static String name3 = "Programming";
	
	{ num3 = num3 + 10; }
	
	static { name3 = name2 + " " + name3; }

}
