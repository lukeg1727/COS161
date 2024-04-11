import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * SimonPanel presents a version of the Simon game to the user.  
 * It displays the board and responds to button presses to allow
 * the game referee to monitor the player's progress.
 * 
 * Note: Button presses are managed through a MouseListener attached
 * to the base DrawingPanel (see course materials) used to present the board
 * 
 * @author david levine
 * @version 23 March 2023
 *
 */
public class SimonPanel {
	private DrawingPanel canvas;
	private SimonButton[] buttons;
	private SimonButton currentButton;
	private long buttonClickTime;
	private int xFactor;
	private int yFactor;
	private Graphics2D gameBoard;

	/**
	 * Create a new SimonPanel
	 */
	public SimonPanel() {
		buttons = new SimonButton[4];
		buttons[0] = new SimonButton(this, Color.BLUE, 32, 12, 36, 16, "Blue", "beep-blue.wav");
		buttons[1] = new SimonButton(this, Color.RED, 72, 32, 16, 36, "Red", "beep-red.wav");
		buttons[2] = new SimonButton(this, Color.GREEN, 32, 72, 36, 16, "Green", "beep-green.wav");
		buttons[3] = new SimonButton(this, Color.YELLOW, 12, 32, 16, 36, "Yellow", "beep-yellow.wav");
		currentButton = null;

		canvas = new DrawingPanel(400, 400);
		gameBoard = canvas.getGraphics();
		xFactor = canvas.getWidth() / 100;
		yFactor = canvas.getHeight() / 100;

		// This code uses an anonymous inner class to monitor
		// mouse clicks, logging which button (of the four) was
		// clicked and when that happened; students do NOT need
		// to understand how it works.
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (SimonButton b : buttons) {
					if (inButton(e.getX(), e.getY(), b)) {
						setCurrentButton(b);
						setButtonClickTime(System.nanoTime());
					}
				}
			}
		});
		draw();
	}

	/**
	 * Returns the (system) time (in nanoseconds) of the last Simon button clicked
	 * @return the (system) time (in nanoseconds) of the last Simon button clicked
	 */
	public long getButtonClickTime() {
		return buttonClickTime;
	}

	/**
	 * Sets the (system) time (in nanoseconds) of the last Simon button clicked
	 * @param buttonClickTime the (system) time (in nanoseconds) of the last Simon button clicked
	 */
	public void setButtonClickTime(long buttonClickTime) {
		this.buttonClickTime = buttonClickTime;
	}

	/**
	 * Returns the SimonButton that was most recently clicked
	 * @return the SimonButton that was most recently clicked
	 */
	public SimonButton getCurrentButton() {
		return currentButton;
	}

	/**
	 * Sets the SimonButton that was most recently clicked
	 * @param currentButton the SimonButton that was most recently clicked
	 */
	public void setCurrentButton(SimonButton currentButton) {
		this.currentButton = currentButton;
	}

	/**
	 * Returns an array of all (four of the) SimonButtons in the game
	 * @return an array of all (four of the) SimonButtons in the game
	 */
	public SimonButton[] getButtons() {
		return buttons;
	}

	/**
	 * Returns the drawing surface for this SimonPanel
	 * @return the drawing surface for this SimonPanel
	 */
	public DrawingPanel getCanvas() {
		return canvas;
	}

	/**
	 * Draws all the components for the game
	 */
	private void draw() {
		gameBoard.setColor(Color.BLACK);
		gameBoard.fillOval(0, 0, canvas.getWidth(), canvas.getHeight());

		for (SimonButton b : buttons) {
			dimButton(b);
		}
	}

	/**
	 * Draws the given SimonButton in its unhighlighted state
	 * @param b the SimonButton to draw 
	 */
	public void dimButton(SimonButton b) {
		gameBoard.setColor(b.getNormal());
		paintButton(b);
	}

	/**
	 * Draws the given SimonButton in its highlighted state
	 * @param b the SimonButton to draw 
	 */
	public void highlightButton(SimonButton b) {
		gameBoard.setColor(b.getHighlight());
		paintButton(b);
	}

	/**
	 * Helper method to avoid duplicated code when drawing a SimonButton
	 * @param b the SimonButton to draw
	 */
	private void paintButton(SimonButton b) {
		gameBoard.fillRect(b.getLeft() * xFactor, b.getTop() * yFactor, b.getWidth() * xFactor,
				b.getHeight() * yFactor);
	}

	/**
	 * Determines if one number is between two others (inclusive)
	 * @param a number to be tested
	 * @param b lower end of the range
	 * @param c upper end of the range
	 * @return <code>true</code> if and only if <code>a</code> lies between <code>b</code>
	 *     and <code>c</code> inclusive
	 */
	private boolean between(int a, int b, int c) {
		return a >= b && a <= c;
	}

	/**
	 * Determines if a given point lies within a given SimonButton
	 * @param x x-coordinate of the test point
	 * @param y y-coordinate of the test point
	 * @param b the SimonButton we are checking
	 * @return <code>true</code> if and only if the point <code>(x,y)</code>
	 *     lies within the bounds of <code>b</code>
	 */
	private boolean inButton(int x, int y, SimonButton b) {
		return between(x, b.getLeft() * xFactor, (b.getLeft() + b.getWidth()) * xFactor)
				&& between(y, b.getTop() * yFactor, (b.getTop() + b.getHeight()) * yFactor);
	}

	/**
	 * Returns the first button clicked by the user after this method is invoked.<br><br>
	 * Note: the loop is necessary because of the timing issues created when we use
	 * mouse clicks in a DrawingPanel.
	 * @return the first button clicked by the user after this method is invoked
	 */
	public SimonButton getButtonClicked() {
		long time = System.nanoTime();   // Note the current time
		while (getButtonClickTime() < time) // Ignore any clicks that come before this time
			sleep(1);
		return getCurrentButton();
	}
	
	/** 
	 * Cause the SimonPanel to sleep for a bit
	 * @param duration the number of milliseconds to sleep
	 */
	public void sleep(int duration) {
		canvas.sleep(duration);
	}
	
	/**
	 * Play a sound file<br><br>
	 * 
	 * @param soundFileName name of the .wav file containing the sound to play
	 */
	public void playSound(String soundFileName) {
//		System.out.println("Playing " + getName());
		  try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFileName).getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		        while(clip.getMicrosecondLength() != clip.getMicrosecondPosition());
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }	}


}
