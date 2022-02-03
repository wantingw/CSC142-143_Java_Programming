package sierpinski.fills;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;

public class Viewer {

	public static final int WIDTH  = 500;
	public static final int HEIGHT = 500;
	public static final int LEFT_X = 750;
	public static final int TOP_Y  = 100;
	
	public static void main(String[] args) {
		ControlPanel panel = new ControlPanel();
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		panel.subPanel.setBorder(BorderFactory.createTitledBorder("Level"));
		
		JFrame frame  = new JFrame("Sierpinski Triangle Viewer");
		frame.setLayout( new BorderLayout() );
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel.subPanel, BorderLayout.SOUTH);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(LEFT_X, TOP_Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
