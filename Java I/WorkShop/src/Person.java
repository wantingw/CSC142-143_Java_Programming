
public class Person {
	private int age;
	private String name;
	
	public Person(int age, String name) {
		this.name= name;
		this.age= age;
		
	}
	public void describePerson() {
		System.out.println(name);
	}
}
