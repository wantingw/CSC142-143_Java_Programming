// Definition of the Buffalo class

public class Buffalo extends Bovine {
	// Constructor
	public Buffalo() {
		super("A buffalo is a bovine that finds work in westerns");
	}

	// We need to override speak if we want to be able to
	// instantiate a Buffalo
	public void speak() {
		System.out.println("Wake me wu when we get to the stampede scene");
	}
}