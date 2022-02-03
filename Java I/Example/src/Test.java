public class Test {
	public static void main(String[] args) {
		Object a1 = new A();
		Object a2 = new Object();
		System.out.print((a1 == a2) + " " + (a1.equals(a2)));
	}
}

class A {
	int x;
	
	public boolean equals(Object obj) {
		Object a = obj;
		if(a==obj)
			return true;
		else
			return false;
	}

	public String toString() {
		return "A's x is " + x;
	}
}


