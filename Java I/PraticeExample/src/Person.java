/**
 *  Pratice example of Person
 * @author wanting.wu
 *
 */
public class Person {
	// instance field: the state of the object
	// access modifier+ data type+ variable name
	private int age;
	private String name;
	// public: anyone can access to this class and refer to the methods in these class
	// private: only current class are available to access
	
	// Constructor: coding to action
	//: Create the object
	// access modifier+ class name+ (){}
	public Person(String n, int a) {
		name= n;
		age= a;
		//Person p= new Person("Hali",9);
		
	}
	
	// instance method: the behavior of the object
	// access modifier+ return type+ method name(){}
	public void speak() {
		System.out.println("Hi, My name is "+ name + ". My age is "+ age+ ".");
	}
	
	//  Main Method
	public static void main (String[] args) {
	//  To create the method and call the constructor
	//  class name + local variable name= new+ class constructor+ (parameters);
		new Person("Hali",9);
	}
}
