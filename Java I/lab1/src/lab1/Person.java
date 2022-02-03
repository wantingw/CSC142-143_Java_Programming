/**
 * A simple model of a person
 * A person has name and age and can speak
 * @author wanting.wu
 * 
 */

package lab1;

public class Person {
	// instance fields that describe the state of the object
	// All variables must be declared before being used
	// declaration:
	// access modifier (public/private)+ type + name

	// --naming a integer which in call age.
	private int age;
	
	// --naming a string which is call name.
	private String name;
	
	// constructor: a special method called to create an object = instantiate the class 
	
	// --Constructor: give values instantly by create a object.
	// --n is the naming of the parameters, a also.
	public Person(String n, int a) {
		//this.name=name;
		//this.age=age;
		name= n;
		age= a;
		
	}
	// 	
	public void speak() {
			System.out.println("My name is "+ name +". My age is "+ age + ".");
	}

	public static void main (String[]args) {
		
		Person wanting = new Person ("wu",5);
		wanting.speak();
		
	}
	
}
	

