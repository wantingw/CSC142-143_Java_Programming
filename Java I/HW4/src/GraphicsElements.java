import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import uwcse.graphics.Oval;
import uwcse.graphics.Rectangle;

/**
 * A class to create and manipulate graphics elements stored in an ArrayList
 */

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

	/**
	 * Create a top view of a pile of disks of decreasing diameters (from bottom to
	 * top). Use filled circles. The color of each disk is random. The pile should
	 * fill the window. <br>
	 * Store the circles in an ArrayList and return that ArrayList (the disk at the
	 * bottom should be the first element of the ArrayList)<br>
	 * The number of disks is given by the user (use a dialog box). If that number
	 * is less than or equal to 0 or greater than MAXIMUM_NUMBER_OF_DISKS, display
	 * an error message (use JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Oval> createAPileOfDisks() {
		// The number of disks
		int numberOfDisks;
		// Create the random object
		Random rand = new Random();

		// Capture users input
		// return error message and re-capture
		do {
			String s = JOptionPane.showInputDialog(null,
					"Number of disks (between 1 and " + MAXIMUM_NUMBER_OF_DISKS + ")", "Display of disks",
					JOptionPane.QUESTION_MESSAGE);
			// convert to an integer
			numberOfDisks = Integer.parseInt(s);
			if (numberOfDisks < 1 || numberOfDisks > MAXIMUM_NUMBER_OF_DISKS)
				JOptionPane.showMessageDialog(null, "Wrong input", "Display of disks", JOptionPane.WARNING_MESSAGE);
		} while (numberOfDisks < 1 || numberOfDisks > MAXIMUM_NUMBER_OF_DISKS);

		// Create the list of ovals
		ArrayList<Oval> diskLists = new ArrayList<Oval>(numberOfDisks);

		// Set the outer oval radius
		int radius = HEIGHT;
		int halfX = (int) (WIDTH / 2);
		int halfY = (int) (HEIGHT / 2);

		for (int i = 0; i < numberOfDisks; i++) {
			// Set the location of the outer oval
			int xOfOval =  halfX - (radius / 2);
			int yOfOval =  halfY - (radius / 2);
			// Random color choose among 0 to 255
			Color color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
			// Create ovals and add into the list
			Oval disk = new Oval(xOfOval, yOfOval, radius, radius, color, true);
			diskLists.add(disk);
			// Change the radius of the oval according to number of disks
			radius = radius - HEIGHT / numberOfDisks;
		}
		return diskLists;

	}

	/**
	 * Create a square checkered board. Create a Rectangle for each square on the
	 * board. Store the Rectangles in an ArrayList and return that ArrayList. Use
	 * two colors only to paint the squares.<br>
	 * The board should cover most of the window. The number of rows (=number of
	 * columns) is given by the user (use a dialog box). If that number is less than
	 * or equal to 0 or greater than MAXIMUM_NUMBER_OF_ROWS, display an error
	 * message (use JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Rectangle> createACheckeredBoard() {
		// The number of rows
		int numberOfRows;
		// set the left corner point of the first rectangle
		int x0 = WIDTH / 2 - HEIGHT / 2;
		int y0 = HEIGHT / 2 - HEIGHT / 2;

		// Get the user entry The number of rows between 1 and 50. If the user gives an
		// invalid value Display an error message and then entry again
		do {
			String r = JOptionPane.showInputDialog(null,
					"Number of disks (between 1 and " + MAXIMUM_NUMBER_OF_ROWS + ")", "Display of disks",
					JOptionPane.QUESTION_MESSAGE);
			// convert to an integer
			numberOfRows = Integer.parseInt(r);
			if (numberOfRows < 1 || numberOfRows > MAXIMUM_NUMBER_OF_ROWS)
				JOptionPane.showMessageDialog(null, "Wrong input", "Display of disks", JOptionPane.WARNING_MESSAGE);
		} while (numberOfRows < 1 || numberOfRows > MAXIMUM_NUMBER_OF_ROWS);

		ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();
		int length = HEIGHT / numberOfRows;

		for (int i = 0; i < numberOfRows; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < numberOfRows; j++) {
					if (j % 2 != 0) {
						int x = x0 + j * length;
						int y = y0 + i * length;
						rectangleList.add(new Rectangle(x, y, length, length, Color.BLUE, true));
					} else {
						int x = x0 + j * length;
						int y = y0 + i * length;
						rectangleList.add(new Rectangle(x, y, length, length, Color.YELLOW, true));
					}
				}
			} else {
				for (int j = 0; j < numberOfRows; j++) {
					if (j % 2 != 0) {
						int x = x0 + j * length;
						int y = y0 + i * length;
						rectangleList.add(new Rectangle(x, y, length, length, Color.YELLOW, true));
					} else {
						int x = x0 + j * length;
						int y = y0 + i * length;
						rectangleList.add(new Rectangle(x, y, length, length, Color.BLUE, true));
					}
				}

			}
		}
		return rectangleList;

	}

	/**
	 * Create a Sierpinski triangle. Create a filled Oval (circle of radius 1) for
	 * each point of the triangle. Store the Ovals in an ArrayList and return that
	 * ArrayList. Use one color only to paint the Ovals.<br>
	 * The triangle should cover most of the window.<br>
	 * The number of points is given by the user (use a dialog box). If that number
	 * is less than or equal to 0 or greater than MAXIMUM_NUMBER_OF_POINTS, display
	 * an error message (use JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Oval> createASierpinskiTriangle() {
		// The number of points
		int numberOfPoints;
		// Get the user entry The number of rows between 1 and 10000. If the user gives
		// an
		// invalid value Display an error message and then entry again
		do {
			String p = JOptionPane.showInputDialog(null,
					"Number of points (between 1 and " + MAXIMUM_NUMBER_OF_POINTS + ")",
					"Display of SierpinskiTriangle", JOptionPane.QUESTION_MESSAGE);
			// convert to an integer
			numberOfPoints = Integer.parseInt(p);
			if (numberOfPoints < 1 || numberOfPoints > MAXIMUM_NUMBER_OF_POINTS)
				JOptionPane.showMessageDialog(null, "Wrong input", "Display of SierpinskiTriangle",
						JOptionPane.WARNING_MESSAGE);
		} while (numberOfPoints < 1 || numberOfPoints > MAXIMUM_NUMBER_OF_POINTS);
		// Create the array list of oval
		ArrayList<Oval> pointsList = new ArrayList<Oval>();
		// Create the three points locations
		int x1 = WIDTH / 2;
		int y1 = 0;
		int x2 = 0;
		int y2 = HEIGHT;
		int x3 = WIDTH;
		int y3 = HEIGHT;
		
		// Create triangle's points
		Random rand = new Random();
		int x = x1;
		int y = y1;
		for (int i = 0; i < numberOfPoints; i++) {
			int num = rand.nextInt(3) + 1;
			if (num == 1) {
				x = (x + x1) / 2;
				y = (y + y1) / 2;
			} else if (num == 2) {
				x = (x + x2) / 2;
				y = (y + y2) / 2;
			} else if (num == 3) {
				x = (x + x3) / 2;
				y = (y + y3) / 2;
			}
			Oval point = new Oval(x, y, 2, 2, Color.BLUE, true);
			pointsList.add(point);

		}
		return pointsList;

	}

	/**
	 * Rotate the colors in the pile of disks. Set the color of each disk to the
	 * color of the disk just above it. For the top disk, set its color to the color
	 * of the bottom disk (e.g. with 3 disks, if the colors are from bottom to top,
	 * red, blue, yellow, the new colors of the disks are from bottom to top, blue,
	 * yellow, red).<br>
	 * Precondition: graphicsList describes a pile of disks
	 */
	public ArrayList<Oval> rotateColorsInPileOfDisks(ArrayList<Oval> graphicsList) {
		// set the inner most disk color
		Color innerDiskColor = graphicsList.get(0).getColor();
		for (int i = 0; i < graphicsList.size(); i++) {
			Oval disk = graphicsList.get(i);
			if (i+1 < graphicsList.size()){
				// replace the color 
				disk.setColor(graphicsList.get(i + 1).getColor());
			} else {
				disk.setColor(innerDiskColor);
			}		
			graphicsList.set(i, disk);
		}
		return graphicsList;
	}

	/**
	 * Flip the 2 colors of the checkboard<br>
	 * Precondition: graphicsList describes a checkered board
	 */
	public ArrayList<Rectangle> flipColorsInCheckeredBoard(ArrayList<Rectangle> graphicsList) {
		for (int i = 0; i < graphicsList.size(); i++) {
			// flip color yellow and blue
			Rectangle rec = graphicsList.get(i);
			if (rec.getColor() == Color.YELLOW) {
				rec.setColor(Color.BLUE);
			} else {
				rec.setColor(Color.YELLOW);
			}
		}
		return graphicsList;

	}

	/**
	 * Change the color of the Sierpinski triangle (all circles should change to the
	 * same color). Switch between 3 colors (e.g. blue->red->green, if the triangle
	 * was blue, make it red, if it was red, make it green, if it was green make it
	 * blue).<br>
	 * Precondition: graphicsList describes a Sierpinski triangle
	 */
	public ArrayList<Oval> changeColorsInSierpinskiTriangle(ArrayList<Oval> graphicsList) {
		
		for(int n=0; n<graphicsList.size(); n++){
			Oval point = graphicsList.get(n);
			// find each point's color
			Color color = point.getColor();
			// check the previous color
			// then change to other color
			if(color==Color.BLUE){
				point.setColor(Color.RED);
			}if(color==Color.RED){
				point.setColor(Color.YELLOW);
			}if(color==Color.YELLOW){
				point.setColor(Color.BLUE);
			}
		}
		// return the list
		return graphicsList;
	
	}
	
	/**
	 * Return the color at location (x,y) in the pile of disks. If (x,y) is not part
	 * of the pile of disks, return null.<br>
	 * Precondition: graphicsList describes a pile of disks
	 */
	public Color getColorInPileOfDisks(int x, int y, ArrayList<Oval> graphicsList) {

		for (int i = graphicsList.size()-1; i >=0; i--){
			Oval disk = graphicsList.get(i);
			// Calculate the distance to the center
			int distance = (x - disk.getCenterX())* (x - disk.getCenterX()) + (y - disk.getCenterY())* (y - disk.getCenterY());
			// find the radius 
			int radius = (graphicsList.get(i).getWidth()/2);
			// Check whether it is inside or outside the disk
			if (distance < radius){
				return graphicsList.get(i).getColor();
			}
		}
		return null;
	}
		

	/**
	 * Return the color at location (x,y) in the checkered board. If (x,y) is not
	 * part of the board, return null.<br>
	 * Precondition: graphicsList describes a checkered board
	 */
	public Color getColorInCheckeredBoard(int x, int y, ArrayList<Rectangle> graphicsList) {
			for (int i = 0; i<graphicsList.size(); i++){
				// find the location of each rectangle
				int x2 = graphicsList.get(i).getCenterX();
				int y2 = graphicsList.get(i).getCenterX();
			}
		return null;

	}

	/**
	 * Return the color at location (x,y) in the Sierpinski triangle. If (x,y) is
	 * not part of the pile of disks, return null.<br>
	 * Precondition: graphicsList describes a Sierpinski triangle
	 */
	public Color getColorInSierpinskiTriangle(int x, int y, ArrayList<Oval> graphicsList) {
		for (int i = 0; i < graphicsList.size(); i++){
			Oval point = graphicsList.get(i);
			// find the distance to the center
			double distance = (x - point.getCenterX()) * (x - point.getCenterX()) + (y- point.getCenterY()) * (y- point.getCenterY());
			if (distance<= 1.0) {
				return graphicsList.get(i).getColor();
			}
		}
		return null;
	}
}
