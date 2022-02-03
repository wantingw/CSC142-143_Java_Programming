import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * A MountainScene displays snow men, trees (with ornaments), a cable car, and
 * houses in a graphics window
 * 
 * @author wanting.wu
 */

public class MountainScene {

	/** The graphics window that displays the picture */
	private GWindow window;

	/**
	 * Create an image of a mountain scene
	 */
	public MountainScene() {

		// The graphics window
		// The window is by default 500 wide and 400 high
		// Here create a 1000 wide and 1000 wide and 850 high window
		this.window = new GWindow("Mountain scene", 1000, 850);

		this.window.setExitOnClose(); // so that a click on the close box of the
		// window terminates the application

		// Background (cyan here)
		Rectangle bgnd = new Rectangle(0, 0, window.getWindowWidth(), window.getWindowHeight(), Color.CYAN, true);
		this.window.add(bgnd);

		// Create the scene elements
		// e.g. a tree in the lower left area 1.5 times the normal size
		// Display 5 tress elements in different sizes and positions
		new Tree(50, 40, 1, this.window);
		new Tree(800, 600, 3, this.window);
		new Tree(100, 700, 1.5, this.window);
		new Tree(100, 200, 0.8, this.window);
		new Tree(800, 100, 2.3, this.window);

		// The snowman elements
		// Display 3 snowman elements in different sizes and positions
		new SnowMan(350, 620, 2, this.window);
		new SnowMan(150, 80, 1, this.window);
		new SnowMan(580, 112, 1.3, this.window);

		// Display 1 cable car in the window
		new CableCar(200, 350, 1.5, this.window);

		// Display 3 house elements in different sizes and positions
		new House(700, 355, 1.5, this.window);
		new House(250, 80, 2.2, this.window);
		new House(520, 600, 2, this.window);

	}

	/**
	 * Entry point of the program
	 */
	public static void main(String[] args) {
		new MountainScene();
	}

}
