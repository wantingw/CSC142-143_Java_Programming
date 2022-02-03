import java.util.ArrayList;
import javax.swing.*;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import uwcse.graphics.*;
import uwcse.io.Input;


public class GraphicsElements {

	/** Maximum number of disks in a pile of disks */
	public static final int MAXIMUM_NUMBER_OF_DISKS = 100;

	/** Maximum number of rows (or columns) in a square checkered board */
	public static final int MAXIMUM_NUMBER_OF_ROWS = 50;

	/** Maximum number of points in a Sierpinski triangle */
	public static final int MAXIMUM_NUMBER_OF_POINTS = 10000;

	/** Width of the window (from ViewWindow) */
	public static final int WIDTH = ViewWindow.WINDOW_WIDTH;

	/** Height of the window (from ViewWindow) */
	public static final int HEIGHT = ViewWindow.WINDOW_HEIGHT;

	// Put your other instance fields here (if you need any)
	// range and length of the side of the checkered board
	private int range = HEIGHT;
	private int length = 0;
	
	// defined the radius of points in the Sierpinski triangle
	private static int r = 1;
	
	/**
	 * Create a top view of a pile of disks of decreasing diameters (from bottom
	 * to top). Use filled circles. The color of each disk is random. The pile
	 * should fill the window. <br>
	 * Store the circles in an ArrayList and return that ArrayList (the disk at
	 * the bottom should be the first element of the ArrayList)<br>
	 * The number of disks is given by the user (use a dialog box). If that
	 * number is less than or equal to 0 or greater than
	 * MAXIMUM_NUMBER_OF_DISKS, display an error message (use
	 * JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Oval> createAPileOfDisks() {
		Input input = new Input();
		
		int n = input.readIntDialog("Enter the number of disk (between 1 "
				+ "and " + MAXIMUM_NUMBER_OF_DISKS + ")"); 
		
		if (n <= 0 || n > MAXIMUM_NUMBER_OF_DISKS) {
			JOptionPane.showMessageDialog(null, "Invalid number of DISKS",
									"Input error", JOptionPane.WARNING_MESSAGE);
		}
	
		ArrayList<Oval> list = new ArrayList<Oval>();
		
		int size = HEIGHT;
		for (int i = 1; i <= n; i++) {
 
			int X 	= (int) (WIDTH / 2) - (size / 2);
			int Y 	= (int) (HEIGHT / 2) - (size / 2);
 
			Color c = new Color((int) (Math.random() * 255),
					((int) (Math.random() * 255)),
					((int) (Math.random() * 255)));
			
			Oval disk = new Oval(X, Y, size, size, c, true);
			list.add(disk);
			size -= WIDTH / n;
		}
		return list;

	}

	/**
	 * Create a square checkered board. Create a Rectangle for each square on
	 * the board. Store the Rectangles in an ArrayList and return that
	 * ArrayList. Use two colors only to paint the squares.<br>
	 * The board should cover most of the window. The number of rows (=number of
	 * columns) is given by the user (use a dialog box). If that number is less
	 * than or equal to 0 or greater than MAXIMUM_NUMBER_OF_ROWS, display an
	 * error message (use JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Rectangle> createACheckeredBoard() {
		
		Input in = new Input();
		int n = in.readIntDialog("Enter the number of disk (between 1 "
										+ "and " + MAXIMUM_NUMBER_OF_ROWS + ")");
		
		if (n < 1 || n > MAXIMUM_NUMBER_OF_ROWS) {
			JOptionPane.showMessageDialog(null, "Invalid number of rows",
						"Input error", JOptionPane.WARNING_MESSAGE);
		}
	
		ArrayList<Rectangle> list = new ArrayList<Rectangle>();
		
		//set the size of each rectangle
		int leftx = WIDTH/2 - range/2;
		int lefty = HEIGHT/2 - range/2;
		length = range/n;
		// set 2 color
		Color c1 = Color.BLUE;
		Color c2 = Color.YELLOW;
  
		for(int i = 0; i<n; i++) {
			//if row is in even
			if(i%2 ==0) {
				for(int j=0; j<n; j++) {
					if(j%2 !=0 ) {
						int x = leftx + j*length;
						int y = lefty + i*length;
						Rectangle rectangle = new Rectangle(x,y,length,length,c1,true);
						list.add(rectangle);
					}else{
						int x = leftx + j*length;
						int y = lefty + i*length;
						Rectangle rectangle = new Rectangle(x,y,length,length,c2,true);
						list.add(rectangle);
					}
				}
			}else {
			//or if row in in odd..switch the color setting
				for(int j=0; j<n; j++) {
					if(j%2!=0) {
						int x = leftx + j*length;
						int y = lefty + i*length;
						Rectangle rectangle = new Rectangle(x,y,length,length,c2,true);
						list.add(rectangle);
					}else {
						int x = leftx + j*length;
						int y = lefty + i*length;
						Rectangle rectangle = new Rectangle(x,y,length,length,c1,true);
						list.add(rectangle);
					}
				}
			 
			}
		}
		return list;
	}	
	

	/**
	 * Create a Sierpinski triangle. Create a filled Oval (circle of radius 1)
	 * for each point of the triangle. Store the Ovals in an ArrayList and
	 * return that ArrayList. Use one color only to paint the Ovals.<br>
	 * The triangle should cover most of the window.<br>
	 * The number of points is given by the user (use a dialog box). If that
	 * number is less than or equal to 0 or greater than
	 * MAXIMUM_NUMBER_OF_POINTS, display an error message (use
	 * JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Oval> createASierpinskiTriangle() {
		//get number from the user
		Input in = new Input();
		int n = in.readIntDialog("Enter the number of disk (between 1 "
					+ "and " + MAXIMUM_NUMBER_OF_POINTS + ")");
			// display an error message if the input is invalid
		if (n < 1 || n > MAXIMUM_NUMBER_OF_POINTS) {
				JOptionPane.showMessageDialog(null, "Invalid number of points",
						"Input error", JOptionPane.WARNING_MESSAGE);
		}

		ArrayList<Oval> Points = new ArrayList<Oval>();
	
		//set color random in 3
		Color color = null;
		Random random = new Random();
		 
		switch(random.nextInt(3)){
			case 1:
				color = Color.BLUE;
				break;
			case 2:
				color = Color.RED;
				break;
			case 3:
				color = Color.GREEN;
				break;
		}
			
		if(n>=1){
			Points.add(new Oval (WIDTH/2,0,2*r,2*r,color,true));
		}else if(n>=2){
			Points.add(new Oval(0,HEIGHT,2*r,2*r,color,true));
		}else {
			Points.add(new Oval(WIDTH,HEIGHT,2*r,2*r,color,true));
		}
		
		
		//set a point
		int x = WIDTH/2;
		int y = 0;
		int terms = n-3;
		//create points of the triangle
		for(int i = 0; i<terms; i++){
			int ran = random.nextInt(3)+1;
			if(ran == 1){
				x = (x+WIDTH/2)/2;
				y = (y/2);
				i--;
			}
			if(ran == 2){
				x = (x/2);
				y = (y+HEIGHT)/2;
				i--;
				
			}if(ran == 3){
				x = (x+WIDTH)/2;
				y = (y+HEIGHT)/2;
			}
			Points.add(new Oval(x,y,2*r,2*r,color,true));
		}
		return Points;
	}
	

	/**
	 * Rotate the colors in the pile of disks. Set the color of each disk to the
	 * color of the disk just above it. For the top disk, set its color to the
	 * color of the bottom disk (e.g. with 3 disks, if the colors are from
	 * bottom to top, red, blue, yellow, the new colors of the disks are from
	 * bottom to top, blue, yellow, red).<br>
	 * Precondition: graphicsList describes a pile of disks
	 */
	public ArrayList<Oval> rotateColorsInPileOfDisks(ArrayList<Oval> graphicsList) {
		
		Color bottomColor = graphicsList.get(0).getColor();
		for (int i = 0; i<graphicsList.size(); i++){
			if (i+1 < graphicsList.size()){
				Color newColor = graphicsList.get(i+1).getColor();
				graphicsList.get(i).setColor(newColor);
			}else{ 
				graphicsList.get(i).setColor(bottomColor);
			}
		}
		return graphicsList;
	}

	/**
	 * Flip the 2 colors of the checkboard<br>
	 * Precondition: graphicsList describes a checkered board
	 */
	public ArrayList<Rectangle> flipColorsInCheckeredBoard(ArrayList<Rectangle> graphicsList) {
		for (int i = 0; i < graphicsList.size(); i++){
			// change to another available color
			if(graphicsList.get(i).getColor() == Color.BLUE){
				graphicsList.get(i).setColor(Color.RED);
			}else{
				graphicsList.get(i).setColor(Color.BLUE);
			}
		}
		// return the list with rectangles whose colors are switched.
		return graphicsList;
		
	
	}

	/**
	 * Change the color of the Sierpinski triangle (all circles should change to
	 * the same color). Switch between 3 colors (e.g. blue->red->green, if the
	 * triangle was blue, make it red, if it was red, make it green, if it was
	 * green make it blue).<br>
	 * Precondition: graphicsList describes a Sierpinski triangle
	 */
	public ArrayList<Oval> changeColorsInSierpinskiTriangle(ArrayList<Oval> graphicsList) {
		for(int n=0; n<graphicsList.size(); n++){
			// get color of each point (oval)
			Color c = graphicsList.get(n).getColor();
			
			// change color based on the previous color
			if(c==Color.RED){
				graphicsList.get(n).setColor(Color.GREEN);
			}if(c==Color.BLUE){
				graphicsList.get(n).setColor(Color.RED);
			}if(c==Color.GREEN){
				graphicsList.get(n).setColor(Color.BLUE);
			}
		}
		// return the list
		return graphicsList;
	
	}

	/**
	 * Return the color at location (x,y) in the pile of disks. If (x,y) is not
	 * part of the pile of disks, return null.<br>
	 * Precondition: graphicsList describes a pile of disks
	 */
	public Color getColorInPileOfDisks(int x, int y, ArrayList<Oval> graphicsList) {
		// calculate the distance from the mouth to the center
		double d = Math.sqrt((x-WIDTH/2)*(x-WIDTH/2) + (y-HEIGHT/2)*(y-HEIGHT/2));
		for (int i = graphicsList.size()-1; i >= 0; i--){
			// get the radius of each disk
			double r = (graphicsList.get(i).getWidth() )/ 2;
			
			// check if the mouse inside the disk
			if(d <= r){
				return graphicsList.get(i).getColor();
			}
			
		}
		//when out of the disk 
		return null;
	}

	/**
	 * Return the color at location (x,y) in the checkered board. If (x,y) is
	 * not part of the board, return null.<br>
	 * Precondition: graphicsList describes a checkered board
	 */
	public Color getColorInCheckeredBoard(int x, int y, ArrayList<Rectangle> graphicsList) {
		for (int i = 0; i<graphicsList.size(); i++){
			// get the location of the upper left corner of each rectangle
			int X = graphicsList.get(i).getX();
			int Y = graphicsList.get(i).getY();
			
			// check if the x y are inside the rectangle
			if(x>=X && x<=X+length && y>=Y && y<=Y+length){
				return graphicsList.get(i).getColor();
			}
		}
		return null;
	}

	/**
	 * Return the color at location (x,y) in the Sierpinski triangle. If (x,y)
	 * is not part of the pile of disks, return null.<br>
	 * Precondition: graphicsList describes a Sierpinski triangle
	 */
	public Color getColorInSierpinskiTriangle(int x, int y,ArrayList<Oval> graphicsList) {
		for (int n = 0; n < graphicsList.size(); n++){
			
			// get the distance from the mouse click to the center of the point
			double d = Math.sqrt((x-graphicsList.get(n).getCenterX()*(x-graphicsList.get(n).getCenterX()) 
					+ (y-graphicsList.get(n).getCenterY())*(y-graphicsList.get(n).getCenterY())));
			
			if(d <= r){
				return graphicsList.get(n).getColor();
			}
		}
		// return null 
		return null;
}
	}


}

