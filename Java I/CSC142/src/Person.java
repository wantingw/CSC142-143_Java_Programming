/**
 * A simple model of a person
 * @author wanting.wu
 *
 */

public class Person {
	// instance fields:
	// declaration format:
	// access modifier+ data type+ name;
	// a person is defined by name and age;
	private String name;
	private int age;	
	// the instance field are able to use anywhere within the class
	// if is public, it possibly use outside the class
	// if is private, it is available in the class only;
	
	// Constructor: code that creates an object (=instantiates the class)
	// name of the constructor= name of the class
	// format: access modifier + class name + ()+{}	
	public Person(String n, int a) {
		name=n;
		age=a;
		// this.name= name;
		// this.age= age;
	}
	
	// instance methods:
	// access modifier+ return type+ method name
	//+ parameter list
	
	public void speak() {
		System.out.println("My name is "+ name+". My age is "+ age+ ".");
	}
}
	

