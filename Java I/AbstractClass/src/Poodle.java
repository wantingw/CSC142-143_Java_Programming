// A Poodle is a Critter that makes a noise of a Poodle

public class Poodle extends Critter implements Trainable {
	// constructor
	public Poodle() {
		super("A poodle is a dog with a funny haircut"); 
	}

	// We must override speak if we want Poodle to be instantiated
	public void speak() {
		System.out.println("Arf, arf. I want a new haircut.");
	}
	
	// We must implement fetch and rollOver from the Trainable interface
	@Override
	public void fetch() {
		System.out.println("I love to play fetch");
	}
	
	@Override 
	public void rollOver() {
		System.out.println("Rolling over is so much fun!");
	}
}