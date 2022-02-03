import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;
import uwcse.graphics.Polygon;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Triangle;

/**
 * Creates a simple graphics window using the uw library
 * 
 * @author wanting
 *
 */
public class FirstGraphicsApp {
	public static void main(String[] args) {
		GWindow w = new GWindow(800, 600);
		Rectangle r = new Rectangle(300, 100, 180, 75, Color.BLUE, true);
		// use the add method to place the rectangle in the window
		w.add(r);
		// Check the uw library to add
		// an oval
		Oval o = new Oval(100, 150, 60, 120, Color.RED, true);
		w.add(o);
		// a triangle
		Triangle t = new Triangle(600, 500, 500, 400, 300, 450, Color.GREEN, true);
		w.add(t);
		// a polygon
		Polygon p = new Polygon(Color.YELLOW, true);
		p.addPoint(200, 10);
		p.addPoint(300, 70);
		p.addPoint(200, 70);
		p.addPoint(300, 10);
		w.add(p);
	}
}