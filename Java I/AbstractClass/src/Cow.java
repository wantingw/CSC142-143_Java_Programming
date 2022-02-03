// Definition of the Cow class
// A Cow is a Bovine that makes specific noises

public class Cow extends Bovine {
	// Constructor
	public Cow() {
		super("A cow is a bovine that has four staomachs");
	}

	// We need to override speak if we want to be able to
	// instantiate a Buffalo
	public void speak() {
		System.out.println("Help me! Some kid just tipped me.");
	}
}
