import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * Create a snow man in a graphics window
 * 
 * @author wan-ting.wu
 */

public class SnowMan {
	// Instance fields
	// The graphics window this snowman belongs to
	private GWindow window;
	// The location of this tree
	// (precisely (as done in the draw method), (x,y) is
	// the upper left corner of the tree trunk)
	private int x;
	private int y;
	// The scale used to draw this tree
	private double scale;
	// Declaration of graphic elements
	private Rectangle hat, brim;
	private Line arm1, arm2, hand1, hand2;
	// The distance for hat moving in y direction
	private int dy=-5;
	// The degree used to rotate the arms
	private double degree=-10;


	/**
	 * Create a snow man in at location (x,y) in the GWindow window.
	 * 
	 * @param x the x coordinate of the center of the head of the snow man
	 * @param y the y coordinate of the center of the head of the snow man
	 * @scale the factor that multiplies all default dimensions for this snow man
	 *        (e.g. if the default head radius is 20, the head radius of this snow
	 *        man is scale * 20)
	 * @window the graphics window this snow man belongs to
	 */
	public SnowMan(int x, int y, double scale, GWindow window) {
		// initialize the instance fields (the use of this is required
		// since the instance fields have the smae name as the
		// parameters of the constructor)
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;

		// the details of the drawing are in written in the private method
		this.drawBody();
		this.drawHat();
		this.drawFace();
		this.drawDecoration();
		this.drawHand();
		this.moveArmsAndHat();
		
	}

	/** Draw in the graphics window a snow man at location (x,y) */
	// Draw the body parts for the snow man
	private void drawBody() {
		// The head of the snow man: a smaller white oval
		Oval head = new Oval(this.x - (int) (21 * this.scale), this.y - (int) (21 * this.scale),
				(int) (42 * this.scale), (int) (42 * this.scale), Color.WHITE, true);

		// The body for the snow man: a biger white oval
		Oval body = new Oval(this.x - (int) (40 * this.scale), this.y + (int) (15 * this.scale),
				(int) (82 * this.scale), (int) (76 * this.scale), Color.WHITE, true);

		this.window.add(head);
		this.window.add(body);
	}

	// Draw the hat for the snow man in the graphics window
	private void drawHat() {
		// hat of the snow man: a crimson rectangle
		Color crimson= new Color(220,20,60);
		this.hat = new Rectangle(this.x - (int) (13 * this.scale), this.y - (int) (56 * this.scale),
				(int) (25 * this.scale), (int) (33 * this.scale), crimson, true);

		// brim of the hat: a glad Rod rectangle
		Color gladRod= new Color(218,165,32);
		this.brim = new Rectangle(this.x - (int) (25 * this.scale), this.y - (int) (25 * this.scale),
				(int) (50 * this.scale), (int) (10 * this.scale), gladRod, true);

		this.window.add(hat);
		this.window.add(brim);

	}

	// Draw the face for the snow man
	private void drawFace() {
		// The eyes of the snow man: an oval with black
		Oval leftEye = new Oval(this.x - (int) (12 * this.scale), this.y - (int) (10 * scale), (int) (8 * this.scale),
				(int) (8 * this.scale), Color.BLACK, true);

		Oval rightEye = new Oval(this.x + (int) (6 * this.scale), this.y - (int) (10 * scale), (int) (8 * this.scale),
				(int) (8 * this.scale), Color.BLACK, true);

		// The nose of the snow man: a gold triangle
		Color gold= new Color(255,215,0);
		Triangle nose = new Triangle(this.x + (int) (1 * this.scale), this.y - (int) (3 * this.scale),
				this.x - (int) (4 * this.scale), this.y + (int) (6 * this.scale), this.x + (int) (6 * this.scale),
				this.y + (int) (6 * this.scale), gold, true);

		// The mouth of the snow man: a black rectangle
		Rectangle mouth = new Rectangle(this.x - (int) (8 * this.scale), this.y + (int) (9 * this.scale),
				(int) (18 * this.scale), (int) (5 * this.scale), Color.BLACK, true);

		this.window.add(leftEye);
		this.window.add(rightEye);
		this.window.add(nose);
		this.window.add(mouth);

	}

	// Draw the decoration for the snow man
	private void drawDecoration() {
		// The decoration of snow man: black ovals
		Oval button1 = new Oval(this.x - (int) (3 * this.scale), this.y + (int) (25 * this.scale),
				(int) (8 * this.scale), (int) (8 * this.scale), Color.BLACK, true);

		Oval button2 = new Oval(this.x - (int) (3 * this.scale), this.y + (int) (45 * this.scale),
				(int) (8 * this.scale), (int) (8 * this.scale), Color.BLACK, true);

		Oval button3 = new Oval(this.x - (int) (3 * this.scale), this.y + (int) (65 * this.scale),
				(int) (8 * this.scale), (int) (8 * this.scale), Color.BLACK, true);

		this.window.add(button1);
		this.window.add(button2);
		this.window.add(button3);
	}

	// Draw the hand for the snow man
	private void drawHand() {
		// Draw the lines represent the arms
		this.arm1 = new Line(this.x - (int) (20 * this.scale), this.y + (int) (45 * this.scale),
				this.x - (int) (65 * this.scale), this.y + (int) (45 * this.scale));
		this.arm2 = new Line(this.x + (int) (25 * this.scale), this.y + (int) (45 * this.scale),
				this.x + (int) (70 * this.scale), this.y + (int) (45 * this.scale));

		// Draw other shorter lines represents the hands
		this.hand1 = new Line(this.x - (int) (45 * this.scale), this.y + (int) (45 * this.scale),
				this.x - (int) (60 * this.scale), this.y + (int) (35 * this.scale));
		this.hand2 = new Line(this.x + (int) (45 * this.scale), this.y + (int) (45 * this.scale),
				this.x + (int) (60 * this.scale), this.y + (int) (35 * this.scale));

		this.window.add(arm1);
		this.window.add(arm2);
		this.window.add(hand1);
		this.window.add(hand2);
	}
	
	// This method will move the hat and arms up
	// Also movce the hat and arms down
	public void moveArmsAndHat() {
		this.hat.moveBy(0, dy);
		this.brim.moveBy(0, dy);
		this.arm1.rotateAround(this.x - (int) (20 * this.scale), this.y + (int) (45 * this.scale),degree);
		this.arm2.rotateAround(this.x + (int) (25 * this.scale), this.y + (int) (45 * this.scale) ,-degree);
		this.hand1.rotateAround(this.x - (int) (20 * this.scale), this.y + (int) (45 * this.scale),degree);
		this.hand2.rotateAround(this.x + (int) (25 * this.scale), this.y + (int) (45 * this.scale),-degree);
			dy=-dy;
			degree= -degree;

	
	}
}


