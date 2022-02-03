
import java.awt.Color;
import uwcse.graphics.*; // access the graphics utilities in the uw library

/**
 * Create a house with windows and door
 * 
 * @author wanting.wu
 */

public class House {
	// Instance fields
	// The graphics window this house belongs to
	private GWindow window;
	// The location of this house
	// (x,y) is the upper left of the house
	private int x;
	private int y;
	// The scale used to draw this house
	private double scale;
	
	private Rectangle window1,window2;

	/**
	 * Create a house
	 * 
	 * @param x      the x coordinate of the house location (upper left corner)
	 * @param y      the y coordinate of the house location
	 * @param scale  the sclae of the drawing (all default dimensions are multiplied
	 *               by scale)
	 * @param window the graphics window this House belongs to
	 */
	public House(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields (the use of this is required
		// since the instance fields have the same name as the
		// parameters of the constructor)
		this.window = window;
		this.scale = scale;
		this.x = x;
		this.y = y;

		// the details of the drawing are in written in the private method
		this.drawChimney();
		this.drawHouseStructure();
		this.drawWindow();
		this.drawDoor();
	}

	/**
	 * draw a house
	 */
	// Draw the house stucture
	private void drawHouseStructure() {
		// The house structure is made by a house body and a house top
		// House body: a yellow rectangle
		// House top: grey rectangle
		Rectangle houseBody = new Rectangle(this.x, this.y, (int) (80 * this.scale), (int) (60 * this.scale),
				Color.YELLOW, true);

		Triangle houseTop = new Triangle(this.x - (int) (20 * this.scale), this.y, this.x + (int) (95 * this.scale),
				this.y, this.x + (int) (40 * this.scale), this.y - (int) (35 * this.scale), Color.GRAY, true);

		this.window.add(houseBody);
		this.window.add(houseTop);
	}

	// Draw the chimney of the house
	private void drawChimney() {
		// Chimney: a blue rectangle
		Rectangle chimney1 = new Rectangle(this.x + (int) (65 * this.scale), this.y - (int) (30 * this.scale),
				(int) (10 * this.scale), (int) (20 * this.scale), Color.BLUE, true);

		this.window.add(chimney1);
	}

	// Draw the windows
	private void drawWindow() {
		// Windows: white rectangles
		this.window1 = new Rectangle(this.x + (int) (5 * this.scale), this.y + (int) (8 * this.scale),
				(int) (25 * this.scale), (int) (20 * this.scale), 
				Color.BLACK, true);
		this.window2 = new Rectangle(this.x + (int) (50 * this.scale), this.y + (int) (8 * this.scale),
				(int) (25 * this.scale), (int) (20 * this.scale), 
				Color.BLACK, true);

		this.window.add(window1);
		this.window.add(window2);
	}
	
	// Draw the door 
	private void drawDoor() {
		// The door: a black rectangle
		Rectangle door = new Rectangle(this.x + (int) (30 * this.scale), this.y + (int) (33 * this.scale),
				(int) (20 * this.scale), (int) (28 * this.scale), Color.RED, true);

		Oval doorknob = new Oval(this.x + (int) (30 * this.scale), this.y + (int) (45 * this.scale),
				(int) (5 * this.scale), (int) (5 * this.scale), Color.BLACK, true);

		Rectangle stair = new Rectangle(this.x + (int) (26 * this.scale), y + (int) (56 * this.scale),
				(int) (28 * this.scale), (int) (5 * this.scale), Color.GRAY, true);

		this.window.add(door);
		this.window.add(doorknob);
		this.window.add(stair);
	}
	
	public void openLights() {
		
	}
}
