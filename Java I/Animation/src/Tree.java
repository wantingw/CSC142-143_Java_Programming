
// access the graphics utilities in the uw library
import uwcse.graphics.*;
import java.awt.Color; // access the Color class
import java.util.Random;

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

	// Graphics elements: ornaments
	private Oval ornament1, ornament2, ornament3;

	// current color of the foliages
	private Color color1, color2, color3;

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
		this.drawTree();
		this.drawOrnament();
		this.flashOrnaments();
	}

	/**
	 * draw a pine tree
	 */
	private void drawTree() {
		// trunk of the tree: a saddle brown rectangle
		// (int) converts to an int 20*this scale (etc...), which is a double
		// For instance, (int)23.8 is 23
		// This is necessary since the Rectangle constructor takes integers
		Color saddleBrown = new Color(139, 69, 19);
		Rectangle trunk = new Rectangle(this.x, this.y, (int) (20 * this.scale), (int) (60 * this.scale), saddleBrown,
				true);
		// Foliage (improve the drawing!)
		// a yellow green triangle
		Color yellowGreen = new Color(154, 205, 50);

		Triangle foliage1 = new Triangle(this.x - (int) (30 * this.scale), this.y + (int) (30 * this.scale),
				this.x + (int) (10 * this.scale), this.y - (int) (10 * this.scale), this.x + (int) (50 * this.scale),
				this.y + (int) (30 * this.scale), yellowGreen, true);
		// Draw the second green rectangle as the second foliage
		Triangle foliage2 = new Triangle(this.x + (int) (10 * this.scale), this.y - (int) (25 * this.scale),
				this.x - (int) (25 * this.scale), this.y + (int) (12 * this.scale), this.x + (int) (44 * this.scale),
				this.y + (int) (12 * this.scale), yellowGreen, true);
		// Draw the third green rectangle as the third foliage
		Triangle foliage3 = new Triangle(this.x + (int) (10 * this.scale), this.y - (int) (35 * this.scale),
				this.x - (int) (10 * this.scale), this.y - (int) (12 * this.scale), this.x + (int) (30 * this.scale),
				this.y - (int) (12 * this.scale), yellowGreen, true);

		this.window.add(trunk);
		this.window.add(foliage1);
		this.window.add(foliage2);
		this.window.add(foliage3);

	}

	// Improve the drawing of the foliage and add the ornaments...
	// Create the oval as the ornaments
	private void drawOrnament() {
		// Ornaments: red oval, blue oval, and orange oval
		this.color1 = Color.RED;
		this.color2 = Color.ORANGE;
		this.color3 = Color.BLUE;
		this.ornament1 = new Oval(this.x - (int) (12 * this.scale), this.y - (int) (10 * this.scale),
				(int) (10 * this.scale), (int) (10 * this.scale), this.color1, true);
		this.ornament2 = new Oval(this.x + (int) (25 * this.scale), this.y + (int) (18 * this.scale),
				(int) (10 * this.scale), (int) (10 * this.scale), this.color2, true);
		this.ornament3 = new Oval(this.x + (int) (20 * this.scale), this.y - (int) (20 * this.scale),
				(int) (10 * this.scale), (int) (10 * this.scale), this.color3, true);

		this.window.add(ornament1);
		this.window.add(ornament2);
		this.window.add(ornament3);
	}

	// This method will change randomly the colors of the tree ornaments
	public void flashOrnaments() {
		Random random = new Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		
		if (color1 == Color.RED) {
			Color color = new Color(r, g, b);
			ornament1.setColor(color);
		}
		if (color2 == Color.ORANGE) {
			Color color = new Color(g, b, r);
			ornament2.setColor(color);
		}
		if (color3 == Color.BLUE) {
			Color color = new Color(b, r, g);
			ornament3.setColor(color);
		}
	}
}
