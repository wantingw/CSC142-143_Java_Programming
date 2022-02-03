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

	// Declarations
	// the elements will do animation
	private Rectangle car, window1, window2, window3;
	private Line cable1, cable2;
	private Line cable3;
	// the dx for moving distance in x-coordinate
	private int dx = 20;

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
		// move()
		this.drawCar();
		this.drawWindow();
		this.drawCable();
		this.move();
	}

	/** Draw a cable car at location (x,y) */
	private void drawCar() {
		Color salmon = new Color(250, 128, 114);
		// Draw the structure of cable car: a salmon color rectangle
		this.car = new Rectangle(this.x - (int) (40 * this.scale), this.y - (int) (20 * this.scale),
				(int) (260 * this.scale), (int) (120 * this.scale), salmon, true);

		this.window.add(car);
	}

	// Draw the windows of the cable car(improve drawing)
	// the windows of the cable car: three pale turquoise color squares
	private void drawWindow() {
		Color paleTurquoise = new Color(175, 238, 238);
		this.window1 = new Rectangle(this.x - (int) (20 * this.scale), this.y + (int) (10 * this.scale),
				(int) (60 * this.scale), (int) (60 * this.scale), paleTurquoise, true);

		this.window2 = new Rectangle(this.x + (int) (60 * this.scale), this.y + (int) (10 * this.scale),
				(int) (60 * this.scale), (int) (60 * this.scale), paleTurquoise, true);

		this.window3 = new Rectangle(this.x + (int) (140 * this.scale), this.y + (int) (10 * this.scale),
				(int) (60 * this.scale), (int) (60 * this.scale), paleTurquoise, true);

		this.window.add(window1);
		this.window.add(window2);
		this.window.add(window3);
	}

	// Draw the cables of the cable car
	// cables of the cable car: three dark slate gray lines
	private void drawCable() {
		Color darkSlateGray = new Color(47, 79, 79);
		this.cable1 = new Line(0, 30, 500, 30);
		this.cable2 = new Line(50, 40, 75, 30, darkSlateGray);
		this.cable3 = new Line(75, 30, 100, 40, darkSlateGray);

		this.window.add(cable1);
		this.window.add(cable2);
		this.window.add(cable3);
	}

	// This method will move the cable car left and right
	// by a certain distance
	public void move() {
		this.car.moveBy(this.dx, 0);
		this.window1.moveBy(this.dx, 0);
		this.window2.moveBy(this.dx, 0);
		this.window3.moveBy(this.dx, 0);
		this.cable2.moveBy(this.dx, 0);
		this.cable3.moveBy(this.dx, 0);
		this.x += dx;
		
		if (this.x + (int) (30 * this.scale) >= window.getWindowWidth()) {
			this.dx = -dx;
		}
		if (this.x + (int) (30 * this.scale) <= 0) {
			this.dx = -dx;
		}

	}
}
