package example;

public class A extends C implements D{

	public void a() {}
	
	public void c() {}
	
	public void d() {}
	
	
	
	
	public static void main(String[] args) {
		
		// A abstract class doesn't allow you crate object c
		// C cVar = new C();
		
		// D dVar = new D();
		//  D have no details
		
		D dVar = new A();
		C cVar = new A();
		cVar = new B();
		
		A aVar = new A();
		aVar.a();
		
		B bVar = new B();
		bVar.a();
		bVar.b();	
		bVar.c();
	}

}

interface D {
	// the key word abstract can be deleted 
	// abstract void d();
	void d();
}

abstract class C {
	abstract void c();
}

class B extends A{
	
	public void b () {
		
	}
}
