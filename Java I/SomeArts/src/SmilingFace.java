import uwcse.graphics.*;
import java.awt.Color;

/**
 * A smiling face in a graphics window
 */

public class SmilingFace {

	// The graphics window
	private GWindow window;

	// Location of the face
	private int x, y;

	// Scale used to draw the face
	private double scale;

	/**
	 * Draw a smiling face in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the center of the face
	 * @param y
	 *            the y coordinate of the center of the face
	 * @param scale
	 *            the multiplication factor for all default sizes
	 * @param window
	 *            the graphics window where to draw
	 */
	public SmilingFace(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields
		// inside the () is the arguments, when you call the constructors, you need to agree the data type of the arguments(agree in number,type and order).
		
		this.x= x;
		this.y= y;
		this.scale= scale;
		this.window= window;

		// Draw the face in the graphics window
		this.drawFace(); // using this.is optional, i.e. writing drawFace(); is also OK;
	}

	/**
	 * Draws a face in the graphics window
	 */
	private void drawFace() {
		// The face (a circle)
		// int r= scale*50, error: cannot convert from double to int
		// use type casting to chaning the type.
		// The head (a circle: default radius = 50)
		// (int)1.7=1, (int)0.6=0, (int)-2.6is -2

		int r= (int) (scale* 50);
		Oval head= new Oval(x-r, y-r, 2*r, 2*r, Color.YELLOW,true);
		window.add(head);


		// The mouth
		drawMouth(x,(int)(y+0.5*r));

		// The eyes
		// left
		drawEye((int)(x-0.5*r),y);
		// right
		drawEye((int)(x+0.5*r),y);

		// The nose


		// Show the face

	}

	/**
	 * Draw an eye
	 * 
	 * @param eyex
	 *            the x coordinate of the center of the eye
	 * @param eyey
	 *            the y coordinate of the center of the eye
	 */
	private void drawEye(int eyex, int eyey) {
		// A black circle in a white oval
		int r= (int)(5*scale);
		Oval eye= new Oval(eyex-r, eyey-r, 2*r, 2*r, Color.BLACK,true);
		window.add(eye);
		
	}

	/**
	 * Draw a nose
	 * 
	 * @param nosex
	 *            the x coordinate of the top point of the nose
	 * @param nosey
	 *            the y coordinate of the top point of the nose
	 */
	private void drawNose(int nosex, int nosey) {
		// A nose is a triangle
		int noseHeight = (int) (20 * this.scale);
		int noseWidth = (int) (20 * this.scale);
		Triangle nose = new Triangle(nosex, nosey, nosex + noseWidth / 2, nosey
				+ noseHeight, nosex - noseWidth / 2, nosey + noseHeight,
				Color.black, true);
		this.window.add(nose);
	}

	/**
	 * Draw a mouth
	 * 
	 * @param mouthx
	 *            the x coordinate of the middle bottom point of the mouth
	 * @param mouthy
	 *            the y coordinate of the middle bottom point of the mouth
	 */
	private void drawMouth(int mouthx, int mouthy) {
		// Draw two circles (one black and one yellow)
		// The yellow circle is on top of the black circle and slightly shifted
		// up
		int r= (int)(40*scale);
		Oval blackCircle= new Oval(mouthx -r, mouthy-2*r, 2*r, 2*r, Color.BLACK,true);
		Oval yellowCircle= new Oval(mouthx -r, mouthy-2*r, 2*r, 2*r, Color.YELLOW,true);		
		yellowCircle.moveBy(0, (int)(-0.15 * r));
		window.add(blackCircle);
		window.add(yellowCircle);
	}
}
