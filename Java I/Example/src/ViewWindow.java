import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import uwcse.graphics.*;

/**
 * Construct a window to display the graphics elements received from
 * GraphicsElements. This class is complete. Don't modify it. It is also not
 * necessary for you to understand this code.<br>
 * To test your program, either select main by right clicking on the class icon,
 * or instantiate a ViewWindow object.
 */

public class ViewWindow extends JPanel implements MouseListener, ActionListener {

	/** Width of the inner panel of this ViewWindow */
	public static final int WINDOW_WIDTH = 400;

	/** Height of the inner panel of this ViewWindow */
	public static final int WINDOW_HEIGHT = 300;

	// The frame this ViewWindow is in
	private JFrame frame;

	// A button to draw squares in the window
	private JButton drawSquaresButton;

	// The list of the graphics elements to display
	ArrayList graphicsList;

	// The object that generates the graphics elements to display
	GraphicsElements graphicsElements = new GraphicsElements();

	/** Construct a ViewWindow */
	public ViewWindow() {
		// Use a windows look and feel (if available)
		try {
			UIManager.LookAndFeelInfo[] lfinfo = UIManager
					.getInstalledLookAndFeels();
			UIManager.setLookAndFeel(lfinfo[2].getClassName());
		} catch (Exception e) {/* ignore any problem */
		}

		// The components making up the window

		// Button to rotate the colors
		this.drawSquaresButton = new JButton("Draw squares");
		this.drawSquaresButton.addActionListener(this);

		// Place the components in this WindowView
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		// at the bottom (SOUTH)
		JPanel southPanel = new JPanel();
		southPanel.add(drawSquaresButton);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		// Background color of this WindowView
		this.setBackground(Color.white);
		contentPane.add(this, BorderLayout.CENTER);
		// Send all mouse events to this WindowView
		this.addMouseListener(this);
		// Put everything in a frame
		this.frame = new JFrame("Doing graphics with loops");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setContentPane(contentPane);
		// Show it
		this.frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.frame.setLocation(100, 100);
		this.frame.setVisible(true);
		// Resize it with the actual size
		Insets insets = this.frame.getInsets();
		int width = WINDOW_WIDTH + insets.left + insets.right;
		int height = WINDOW_HEIGHT + insets.top + insets.bottom
				+ (int) (southPanel.getPreferredSize().getHeight());
		this.frame.setSize(width, height);
		this.frame.setResizable(false);
		this.frame.setVisible(true);
	}

	/** Handle the button click */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.drawSquaresButton) {
			// Get the list of squares
			this.graphicsList = this.graphicsElements.getRandomSquares();
		} else
			// unknown source
			return;

		// display the new drawing
		this.repaint();
	}

	/** Display this WindowView */
	public void paintComponent(Graphics gfx) {
		super.paintComponent(gfx);
		// If there is nothing to display, stop here
		if (this.graphicsList == null)
			return;

		// Use some graphics2D features (smooth edges)
		Graphics2D g = (Graphics2D) gfx;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		// Display the squares
		// Checkered board
		Iterator it = this.graphicsList.iterator();
		while (it.hasNext()) {
			Rectangle square = (Rectangle) (it.next());
			g.setColor(square.getColor());
			g.fillRect(square.getX(), square.getY(), square.getWidth(), square
					.getHeight());
		}
	}

	// Implement MouseListener
	/** Erase the graphics element at the location of the mouse click */
	public void mousePressed(MouseEvent e) {
		// if right click, display information about the graphics elements
		if (e.isMetaDown())
			this.graphicsElements.displayStatistics(this.graphicsList);
		else
			// erase the graphics element at the location of the click
			this.graphicsElements.eraseElementAt(e.getX(), e.getY(),
					this.graphicsList);
		this.repaint();
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	/** Starts the application */
	public static void main(String[] args) {
		ViewWindow viewWindow = new ViewWindow();
	}
}
