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

	// Graphics elements of the face
	private Oval head;

	private Oval leftEye, rightEye, leftPupil, rightPupil;

	private Triangle nose;

	private Oval mouthBlackCircle;

	private Oval mouthYellowCircle;

	/**
	 * Draws a smiling face in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the center of the face
	 * @param y
	 *            the y coordinate of the center of the face
	 * @param scale
	 *            the multiplication factor for all default dimensions
	 * @param window
	 *            the graphics window where to draw
	 */
	public SmilingFace(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;

		// Draw the face in the graphics window
		this.drawFace();
	}

	/**
	 * Moves the face by (dx,dy)
	 * 
	 * @param dx
	 *            the displacement along the x axis
	 * @param dy
	 *            the displacement along the y axis
	 */
	public void moveBy(int dx, int dy) {
		this.rightEye.moveBy(dx, dy);
		this.leftEye.moveBy(dx, dy);
		this.leftPupil.moveBy(dx, dy);
		this.rightPupil.moveBy(dx, dy);
		this.nose.moveBy(dx, dy);
		this.mouthBlackCircle.moveBy(dx, dy);
		this.mouthYellowCircle.moveBy(dx, dy);
		this.head.moveBy(dx, dy);

		// Update the position of the face (not needed to move the face, but
		// let's be complete)
		this.x += dx;
		this.y += dy;
	}

	/**
	 * Draws a face in the graphics window
	 */
	private void drawFace() {
		// The face (a circle)
		int faceRadius = (int) (50 * this.scale);
		this.head = new Oval(this.x - faceRadius, this.y - faceRadius, 2 * faceRadius, 2 * faceRadius, Color.YELLOW,
				true);
		this.window.add(head);

		// The mouth
		this.drawMouth(this.x, this.y + 9 * faceRadius / 10);

		// The eyes
		// left
		this.drawEye(this.x - faceRadius / 2, this.y);
		// right
		this.drawEye(this.x + faceRadius / 2, this.y);

		// The nose
		this.drawNose(this.x, this.y);

		// Show the face
		this.window.doRepaint();
	}

	/**
	 * Draws an eye
	 * 
	 * @param eyex
	 *            the x coordinate of the center of the eye
	 * @param eyey
	 *            the y coordinate of the center of the eye
	 */
	private void drawEye(int eyex, int eyey) {
		// A black circle in a white oval
		int eyeHalfWidth = (int) (15 * this.scale);
		int eyeHalfHeight = (int) (8 * this.scale);
		Oval eye = new Oval(eyex - eyeHalfWidth, eyey - eyeHalfHeight, 2 * eyeHalfWidth, 2 * eyeHalfHeight, Color.WHITE,
				true);
		this.window.add(eye);
		int pupilRadius = eyeHalfHeight;
		Oval pupil = new Oval(eyex - pupilRadius, eyey - pupilRadius, 2 * pupilRadius, 2 * pupilRadius, Color.BLACK,
				true);
		this.window.add(pupil);

		// Keep a handle on the graphics objects to be able
		// to erase them later
		if (eyex <= this.x) {
			this.leftEye = eye;
			this.leftPupil = pupil;
		} else {
			this.rightEye = eye;
			this.rightPupil = pupil;
		}
	}

	/**
	 * Draws a nose
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
		this.nose = new Triangle(nosex, nosey, nosex + noseWidth / 2, nosey + noseHeight, nosex - noseWidth / 2,
				nosey + noseHeight, Color.BLACK, true);
		this.window.add(nose);
	}

	/**
	 * Draws a mouth
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
		int mouthRadius = (int) (30 * this.scale);
		int mouthThickness = (int) (6 * this.scale);
		this.mouthBlackCircle = new Oval(mouthx - mouthRadius, mouthy - 2 * mouthRadius, 2 * mouthRadius,
				2 * mouthRadius, Color.BLACK, true);
		this.window.add(this.mouthBlackCircle);
		this.mouthYellowCircle = new Oval(mouthx - mouthRadius, mouthy - 2 * mouthRadius - mouthThickness,
				2 * mouthRadius, 2 * mouthRadius, Color.YELLOW, true);
		this.window.add(this.mouthYellowCircle);
	}

}
