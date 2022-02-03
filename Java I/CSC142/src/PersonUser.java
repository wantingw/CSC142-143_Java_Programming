/**
 * A client of the Person class
 * 
 * @author CSC 142
 *
 */
public class PersonUser {

	public static void main(String[] args) {
		// to create a Person object, call the Person constructor
		// Syntax: new + class constructor (argument list)
		Person p = new Person("Sara",27);
		p.speak();
	}
}
