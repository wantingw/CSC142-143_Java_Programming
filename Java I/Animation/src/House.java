
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
	// Declaration of graphics elements
	private Oval smoke1, smoke2, smoke3;
	// The distance smoke of the chimney will move in x and y direction
	private int dx=5,dy=-5;



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
		this.drawSmoke();
		
	}

	/**
	 * draw a house
	 */
	// Draw the house stucture
	private void drawHouseStructure() {
		// The house structure is made by a house body and a house top
		// House body: a moccasin color rectangle
		// House roof: a peru color rectangle
		Color peru= new Color(205,133,63);
		Color moccasin= new Color(255,228,181);
		Rectangle houseBody1 = new Rectangle(this.x, this.y, (int) (80 * this.scale), (int) (60 * this.scale),
				moccasin, true);
		Triangle houseRoof = new Triangle(this.x-(int)(10*this.scale) , this.y, 
				this.x + (int) (90 * this.scale),this.y, 
				this.x + (int) (40 * this.scale), this.y - (int) (35 * this.scale), 
			peru, true);
		this.window.add(houseRoof);
		this.window.add(houseBody1);
	}

	// Draw the chimney of the house
	private void drawChimney() {
		// Chimney: a slate gray rectangle
		Color slateGray= new Color (112,128,144);
		Rectangle chimney1 = new Rectangle(this.x + (int) (65 * this.scale), this.y - (int) (30 * this.scale),
				(int) (10 * this.scale), (int) (20 * this.scale), slateGray, true);

		this.window.add(chimney1);
	}

	// Draw the windows
	private void drawWindow() {
		// Windows: two linen color rectangles
		Color linen= new Color (250,240,230);
		Rectangle window1 = new Rectangle(this.x + (int) (5 * this.scale), this.y + (int) (5 * this.scale),
				(int) (25 * this.scale), (int) (20 * this.scale), linen, true);
		Rectangle window2 = new Rectangle(this.x + (int) (48 * this.scale), this.y + (int) (5 * this.scale),
				(int) (25 * this.scale), (int) (20 * this.scale), linen, true);
		this.window.add(window1);
		this.window.add(window2);
		
	}
	
	// Draw the door 
	private void drawDoor() {
		// The door: a tan color rectangle
		// The stairs: Rosy brown color rectangle
		// The door knob: a chocolate color oval
		Color tan= new Color(210,180,140);
		Color RosyBrown= new Color(188,143,143);
		Color chocolate= new Color(210,105,30);
		Rectangle door = new Rectangle(this.x + (int) (28 * this.scale), this.y + (int) (30 * this.scale),
				(int) (20 * this.scale), (int) (25 * this.scale), tan, true);

		Rectangle stair1 = new Rectangle(this.x + (int) (20 * this.scale), y + (int) (56 * this.scale),
				(int) (35 * this.scale), (int) (5 * this.scale), RosyBrown, true);
		
		Rectangle stair2 = new Rectangle(this.x + (int) (25* this.scale), y + (int) (53 * this.scale),
				(int) (26 * this.scale), (int) (5 * this.scale), RosyBrown, true);
		Oval doorKnob = new Oval(this.x+(int)(28*this.scale),this.y+(int)(40*this.scale),
				(int)(5*this.scale),(int)(5*this.scale),
				chocolate,true);
		this.window.add(door);
		this.window.add(stair1);
		this.window.add(stair2);
		this.window.add(doorKnob);
		
	}
	
	// Draw the smoke of the house's chimney
	private void drawSmoke() {
		this.smoke1= new Oval (this.x + (int) (70 * this.scale), this.y - (int) (40 * this.scale),
				(int)(12*this.scale),(int)(9*this.scale),
				Color.gray,true);
		this.smoke2= new Oval (this.x + (int) (80 * this.scale), this.y - (int) (50 * this.scale),
				(int)(12*this.scale),(int)(9*this.scale),
				Color.gray,true);
		this.smoke3= new Oval (this.x + (int) (90 * this.scale), this.y - (int) (60 * this.scale),
				(int)(12*this.scale),(int)(9*this.scale),
				Color.gray,true);
		this.window.add(smoke1);
		this.window.add(smoke2);
		this.window.add(smoke3);
	}
	
	// This method will moving the smoke from the chimney
	// As the smoke reach certain height,the smoke will become snow
	// It will snowing, the snow will cover the stairs of the house
	public void HouesSmokeBecomeSnow() {
		this.smoke1.moveBy(dx, dy);
		this.smoke2.moveBy(dx, dy);
		this.smoke3.moveBy(dx, dy);
		this.y+=dy;
		if (this.y - (int) (100 * this.scale)<=0) {
			this.smoke1.setColor(Color.white);
			this.smoke2.setColor(Color.white);
			this.smoke3.setColor(Color.white);
			dx=-dx;
			dy=-dy;
			this.smoke1.resize(40, 40);
			this.smoke2.resize(40, 40);
			this.smoke3.resize(40, 40);	
			
			Oval snowfield1= new Oval (this.x + (int) (5* this.scale), this.y + (int) (140 * this.scale),
					(int)(30*this.scale),(int)(30*this.scale),
					Color.WHITE,true);
			Oval snowfield2= new Oval (this.x-(int)(5*this.scale), this.y + (int) (135 * this.scale),
					(int)(30*this.scale),(int)(30*this.scale),
					Color.WHITE,true);
			Oval snowfield3= new Oval (this.x+ (int)(20*this.scale), this.y + (int) (138 * this.scale),
					(int)(30*this.scale),(int)(30*this.scale),
					Color.WHITE,true);
			Oval snowfield4= new Oval (this.x- (int)(10*this.scale), this.y + (int) (132 * this.scale),
					(int)(30*this.scale),(int)(30*this.scale),
					Color.WHITE,true);
			Oval snowfield5= new Oval (this.x+ (int)(30*this.scale), this.y + (int) (142 * this.scale),
					(int)(30*this.scale),(int)(30*this.scale),
					Color.WHITE,true);
			Oval snowfield6= new Oval (this.x+ (int)(40*this.scale), this.y + (int) (139 * this.scale),
					(int)(30*this.scale),(int)(30*this.scale),
					Color.WHITE,true);
			Oval snowfield7= new Oval (this.x+ (int)(53*this.scale), this.y + (int) (132 * this.scale),
					(int)(30*this.scale),(int)(30*this.scale),
					Color.WHITE,true);
			this.window.add(snowfield1);
			this.window.add(snowfield2);
			this.window.add(snowfield3);
			this.window.add(snowfield4);
			this.window.add(snowfield5);
			this.window.add(snowfield6);
			this.window.add(snowfield7);
			
		}

	}
}
