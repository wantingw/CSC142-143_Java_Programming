import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.Rectangle;

/**
 * To display a smiling face in a graphic window
 * @author wanting.wu
 *
 */
public class FaceScene {
	public FaceScene() {
	// The graphic window
	// The window is 1000 * 600
	GWindow w= new GWindow("FaceScene",1000,600);
	
	// Exit when closing the window
	w.setExitOnClose();
	
	// Background (white)
	Rectangle bg= new Rectangle(0,0,w.getWindowWidth(), w.getWindowHeight(), Color.WHITE, true);
	w.add(bg);
	
	// Create the scene elements
	// calling the constructor form the SimilingFace
    new SmilingFace(800, 300, 0.3, w);
	// e.g. a face in the lower area 1.5 times the normal size
    new SmilingFace(200, 450, 1.5, w);
}

/**
 * Starts the application
 */
public static void main(String[] args) {
	new FaceScene();
	}
}