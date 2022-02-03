import java.util.ArrayList;

import javax.swing.*;

public class TestCritter {
	// Write description of and sound produced by Critter c.
	public static void write_info(Critter c) {
		System.out.println("Dynamic type " + c.getClass());
		c.describe();
		c.speak();
		// When c points to a Poodle, let's make it fetch and roll over
		// to check an is- a relationship between the dynamic of a variable anda type (defined by a class, an abstract class or an interface)
		// use the keyword instanceof
		if (c instanceof Trainable) {
			//c.fetch();// why does't it compile?
			// c has static type = Critter and Critter doesn't contain fetch
			Trainable t = (Trainable) c;
			t.fetch();
			t.rollOver();
		}
	}

	// Test critter classes
	public static void main(String[] args) {
		// An abstract class CANNOT be instantiated
		// Create a poodle, a buffalo, a cow and a bird
		// what data structure would store a buffalo, a cow and a poodle?
		// an arraylist or an array
		
		// with an arraylist
		ArrayList<Critter> list = new ArrayList<Critter>();
		list.add(new Poodle());
		list.add(new Buffalo());
		list.add(new Cow());
		
		// with an array
		Critter[] a= {new Poodle(), new Buffalo(), new Cow()};
	

		// Call write_info for each critter
		for (Critter c : list) {
			write_info(c);
			System.out.println();
		}
		//for (Critter c: a) {
		//	writeInfor(c);
		//}
		
		// Can we write the following?
		// Bovine b = new Buffalo(); // -> Yes
		// Critter c= b; // -> Yes
		// c= new Poodle();// OK
		// b = c; No
		// Buffalo bu = b; // No
		// Buffalo bu = (Buffalo) b;
		// Cow cow = (Cow) b; No
	}
}