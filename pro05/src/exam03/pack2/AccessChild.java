package exam03.pack2;

import exam03.pack1.AccessParent;

public class AccessChild extends AccessParent {
	public void method() {
		// 다른 클래스, 다른 패키지 하지만 후손임.
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
	}

}
