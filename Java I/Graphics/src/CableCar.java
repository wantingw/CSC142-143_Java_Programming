import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * Create a cable car in a graphics window
 * 
 * @author wan-ting.wu
 */

public class CableCar {

	// instance fields
	// the graphics window this cable car belongs to
	private GWindow window;
	// the location of this cable is
	// the upper left corner
	private int x;
	private int y;
	// the scale use to draw this tree
	private double scale;

	/**
	 * Create a cable car at location (x,y) in the GWindow window.
	 * 
	 * @param x the x coordinate of the center of the cable car
	 * @param y the y coordinate of the center of the cable car
	 * @scale the factor that multiplies all default dimensions for this cable car
	 *        (e.g. if the default size is 80, the size of this cable car is scale *
	 *        80)
	 * @window the graphics window this cable car belongs to
	 */
	public CableCar(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields (the use of this is required
		// since the instance fields have the same name as the
		// parameters of the constructor)
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;

		// The details of the drawing are in a private method
		// drawCar()
		// drawWindow()
		// drawCable()
		this.drawCar();
		this.drawWindow();
		this.drawCable();
	}

	/** Draw a cable car at location (x,y) */
	private void drawCar() {
		// Draw the structure of cable car: a blue rectangle
		Rectangle car = new Rectangle(this.x - (int)(40 * this.scale), this.y - (int) (20 * this.scale),
				(int) (260 * this.scale), (int) (120 * this.scale), 
				Color.BLUE, true);

		this.window.add(car);
	}

	// Draw the windows of the cable car(improve drawing)
	// the windows of the cable car: three white square
	private void drawWindow() {
		Rectangle window1 = new Rectangle(this.x - (int) (20 * this.scale), this.y + (int) (10 * this.scale),
				(int) (60 * this.scale), (int) (60 * this.scale), 
				Color.WHITE, true);

		Rectangle window2 = new Rectangle(this.x + (int) (60 * this.scale), this.y + (int) (10 * this.scale),
				(int) (60 * this.scale), (int) (60 * this.scale), 
				Color.WHITE, true);

		Rectangle window3 = new Rectangle(this.x + (int) (140 * this.scale), this.y + (int) (10 * this.scale),
				(int) (60 * this.scale), (int) (60 * this.scale),
				Color.WHITE, true);

		this.window.add(window1);
		this.window.add(window2);
		this.window.add(window3);
	}

	// Draw the cables of the cable car
	// cables of the cable car: three black lines
	private void drawCable() {
		Line cable1 = new Line(0, 250, 999, 250);
		Line cable2 = new Line(250, 320, 350, 250);
		Line cable3 = new Line(450, 320, 350, 250);

		this.window.add(cable1);
		this.window.add(cable2);
		this.window.add(cable3);
	}
}
