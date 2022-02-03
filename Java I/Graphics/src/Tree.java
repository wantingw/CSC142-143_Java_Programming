import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * Create a tree with ornaments in a graphics window
 * 
 * @author wan-ting.wu
 */

public class Tree {

	// Instance fields
	// The graphics window this tree belongs to
	private GWindow window;
	// The location of this tree
	// (precisely (as done in the draw method), (x,y) is
	// the upper left corner of the tree trunk)
	private int x;
	private int y;
	// The scale used to draw this tree
	private double scale;

	/**
	 * Create a tree
	 * 
	 * @param x      the x coordinate of the tree location (upper left corner of the
	 *               tree trunk)
	 * @param y      the y coordinate of the tree location
	 * @param window the graphics window this Tree belongs to
	 * @param scale  the scale of the drawing (all default dimensions are multiplied
	 *               by scale)
	 */
	public Tree(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields (the use of this is required
		// since the instance fields have the same name as the
		// parameters of the constructor)
		this.window = window;
		this.scale = scale;
		this.x = x;
		this.y = y;

		// the details of the drawing are in written in the private method
		// drawTree()
		// drawOrnament()
		this.drawTree();
		this.drawOrnament();
	}

	/**
	 * draw a pine tree
	 */
	private void drawTree() {
		// trunk of the tree: a brown rectangle
		// (int) converts to an int 20*this scale (etc...), which is a double
		// For instance, (int)23.8 is 23
		// This is necessary since the Rectangle constructor takes integers
		Rectangle trunk = new Rectangle(this.x, this.y, (int) (20 * this.scale), (int) (60 * this.scale), Color.BLACK,
				true);
		// Foliage (improve the drawing!)
		// a green triangle
		Triangle foliage1 = new Triangle(this.x - (int) (30 * this.scale), this.y + (int) (30 * this.scale),
				this.x + (int) (10 * this.scale), this.y - (int) (10 * this.scale), this.x + (int) (50 * this.scale),
				this.y + (int) (30 * this.scale), Color.GREEN, true);
		// Draw the second green rectangle as the second foliage
		Triangle foliage2 = new Triangle(this.x + (int) (10 * this.scale), this.y - (int) (25 * this.scale),
				this.x - (int) (25 * this.scale), this.y + (int) (12 * this.scale), this.x + (int) (44 * this.scale),
				this.y + (int) (12 * this.scale), Color.GREEN, true);
		// Draw the third green rectangle as the third foliage
		Triangle foliage3 = new Triangle(this.x + (int) (10 * this.scale), this.y - (int) (35 * this.scale),
				this.x - (int) (10 * this.scale), this.y - (int) (12 * this.scale), this.x + (int) (30 * this.scale),
				this.y - (int) (12 * this.scale), Color.GREEN, true);

		this.window.add(trunk);
		this.window.add(foliage1);
		this.window.add(foliage2);
		this.window.add(foliage3);

	}

	// Improve the drawing of the foliage and add the ornaments...
	// Create the oval as the ornaments
	// Oval ball1= new Oval(this.x-(int)(2*scale),this.y-(int)(2*scale),
	// this.x+(int)(1*scale),this.y+(int)(1*scale),
	// Color.RED,true);
	private void drawOrnament() {
		// Ornaments: red oval, blue oval, and orange oval
		Oval ornament1 = new Oval(this.x - (int) (12 * this.scale), this.y - (int) (10 * this.scale),
				(int) (10 * this.scale), (int) (10 * this.scale), Color.ORANGE, true);
		Oval ornament2 = new Oval(this.x + (int) (25 * this.scale), this.y + (int) (18 * this.scale),
				(int) (10 * this.scale), (int) (10 * this.scale), Color.RED, true);
		Oval ornament3 = new Oval(this.x + (int) (20 * this.scale), this.y - (int) (20 * this.scale),
				(int) (10 * this.scale), (int) (10 * this.scale), Color.BLUE, true);

		this.window.add(ornament1);
		this.window.add(ornament2);
		this.window.add(ornament3);
	}

}