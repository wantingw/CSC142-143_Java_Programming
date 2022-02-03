import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import uwcse.graphics.Rectangle;

/**
 * A class to create and manipulate graphics elements stored in an ArrayList
 * (the graphics elements are squares)
 */

public class GraphicsElements {

	/** Maximum number of squares */
	public static final int MAXIMUM_NUMBER_OF_SQUARES = 100;

	/** Width of the window (from ViewWindow) */
	public static final int WIDTH = ViewWindow.WINDOW_WIDTH;

	/** Height of the window (from ViewWindow) */
	public static final int HEIGHT = ViewWindow.WINDOW_HEIGHT;

	/**
	 * Generate a list of squares randomly located in the window. Use filled
	 * squares. The color of each square is either yellow, blue or red. <br>
	 * Store the squares in an ArrayList and return that ArrayList <br>
	 * The number of squares is given by the user (use a dialog box). If that number
	 * is less than or equal to 0 or greater than MAXIMUM_NUMBER_OF_SQUARES, display
	 * an error message (use JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Rectangle> getRandomSquares() {
		// Get the number of squares from the user
		int n;
		do {
			String s = JOptionPane.showInputDialog(null,
					"Number of squares (between 1 and " + MAXIMUM_NUMBER_OF_SQUARES + ")", "Display of squares",
					JOptionPane.QUESTION_MESSAGE);
			// convert to an integer
			n = Integer.parseInt(s);
			// If the input is outside of the range, display an error
			// message
			if (n < 1 || n > MAXIMUM_NUMBER_OF_SQUARES) {
				JOptionPane.showMessageDialog(null, "Wrong input", "Display of squares", JOptionPane.WARNING_MESSAGE);
			}
		} while (n < 1 || n > MAXIMUM_NUMBER_OF_SQUARES);

		// Create the list of squares
		Random rand = new Random();
		ArrayList<Rectangle> list = new ArrayList<Rectangle>(n);
		for (int i = 1; i <= n; i++) {
			// Random location within the window
			int x = (int) (Math.random() * (WIDTH - 20));
			int y = (int) (Math.random() * (HEIGHT - 20));
			// Could also use a Random object
			// int x = rand.nextInt(WIDTH - 20);
			// Random color chosen among blue, yellow and red
			int r = (int) (Math.random() * 3) + 1;
			Color c = null;
			switch (r) {
			case 1:
				c = Color.RED;
				break;
			case 2:
				c = Color.BLUE;
				break;
			case 3:
				c = Color.YELLOW;
				break;
			}
			list.add(new Rectangle(x, y, 20, 20, c, true));
		}
		return list;
	}

	/**
	 * Erase the square at location (x,y) if any.
	 */
	public void eraseElementAt(int x, int y, ArrayList<Rectangle> listOfSquares) {
		// Loop through the ArrayList
		// if (x,y) is inside of the square at index i, remove that square
		// (x,y) inside means x >= getX() and x <= getX() + getWidth() and
		// y >= getY() and y <= getY() + getHeight()
		// Loop from last to first to encounter the top squares first
		for (int i = listOfSquares.size() - 1; i >= 0; i--) {
			Rectangle r = listOfSquares.get(i);
			// Is (x,y) inside of r?
			if (x >= r.getX() && x <= r.getX() + r.getWidth() && y >= r.getY() && y <= r.getY() + r.getWidth()) {
				listOfSquares.remove(i);
				break; // remove only one square
			}
		}

	}

	/**
	 * Display the number of red squares, blue squares and yellow squares
	 */
	public void displayStatistics(ArrayList<Rectangle> listOfSquares) {
		int red = 0, yellow = 0, blue = 0; // color counters
		// instead of using a for loop with an index,
		// use a for-each loop (also called an enhanced loop)
		for (Rectangle r : listOfSquares) {
			if (r.getColor().equals(Color.RED)) {
				red++;
			} else if (r.getColor().equals(Color.YELLOW)) {
				yellow++;
			} else {
				blue++;
			}
		}

		// display the tallies in a message box
		String message = "red = " + red + "\nyellow = " + yellow + "\nblue = " + blue + "\ntotal = "
				+ listOfSquares.size();
		JOptionPane.showMessageDialog(null,  message, "Statistics",
				JOptionPane.INFORMATION_MESSAGE);
	}
}







