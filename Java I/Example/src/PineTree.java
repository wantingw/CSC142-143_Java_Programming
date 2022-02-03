import java.awt.Color;
import uwcse.graphics.*;

/**
 * A class to draw a pine tree
 */

public class PineTree {

	// The graphics window this Tree belongs to
	private GWindow window;

	// Graphics elements making up the tree
	private Rectangle trunk;

	private Triangle foliage1, foliage2, foliage3;

	// current color of the foliage
	private Color currentFoliageColor;

	/**
	 * Creates a PineTree
	 * 
	 * @param window
	 *            the graphics window this Tree belongs to
	 * @param x
	 *            the x coordinate of the tree location (lower left corner of
	 *            the tree trunk)
	 * @param y
	 *            the y coordinate of the tree location
	 */
	public PineTree(int x, int y, GWindow window) {
		this.window = window;
		this.drawPineTree(x, y);
	}

	/**
	 * Draws a pine tree at the location x,y
	 * 
	 * @param x
	 *            the x coordinate of the lower left corner of the tree trunk
	 * @param y
	 *            the y coordinate of the lower left corner of the tree trunk
	 */
	private void drawPineTree(int x, int y) {
		// a pine tree is a brown rectangle (the trunk) and 3 green triangles
		// (the foliage)
		this.trunk = new Rectangle(x, y, 20, 60, Color.black, true);
		// the foliage is green
		this.currentFoliageColor = Color.green;
		this.foliage1 = new Triangle(x - 30, y + 30, x + 10, y - 10, x + 50,
				y + 30, this.currentFoliageColor, true);
		this.foliage2 = new Triangle(x - 25, y + 30, x + 10, y - 10, x + 45,
				y + 30, this.currentFoliageColor, true);
		this.foliage2.moveBy(0, -20);
		this.foliage3 = new Triangle(x - 20, y + 30, x + 10, y - 10, x + 40,
				y + 30, this.currentFoliageColor, true);
		this.foliage3.moveBy(0, -40);
		this.window.add(this.trunk);
		this.window.add(this.foliage1);
		this.window.add(this.foliage2);
		this.window.add(this.foliage3);
	}

	/**
	 * Changes the color of the pine tree
	 */
	public void flipColor() {
		if (this.currentFoliageColor.equals(Color.green)) {
			this.currentFoliageColor = Color.red;
		} else {
			this.currentFoliageColor = Color.green;
		}
		this.foliage1.setColor(currentFoliageColor);
		this.foliage2.setColor(this.currentFoliageColor);
		this.foliage3.setColor(this.currentFoliageColor);
	}
}