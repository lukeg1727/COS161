import java.awt.Color;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * SimonButton holds all of the data for a given button of the Simon Game.
 * SimonButtons are part of the "playing field" of the game for the purposes
 * of Assignment #3 for COS 161.
 * 
 * @author david levine
 * @version 23 March 2023
 *
 */
public class SimonButton {

	private SimonPanel board;
	private Color normal;
	private Color highlight;
	
	private int left;		// All valued as percentages of full width board
	private int top;
	private int width;
	private int height;
	
	private String name;
	private String soundFileName;
	
	/**
	 * Create a new SimonButton
	 * @param myBoard the board upon which this button lives.
	 * @param off the base color of this SimonButton 
	 * @param leftPct percentage of the SimonPanel to the left of this SimonButton
	 * @param topPct percentage of the SimonPanel above of this SimonButton
	 * @param widthPct percentage of the SimonPanel taken up by the width of this SimonButton
	 * @param heightPct percentage of the SimonPanel taken up by the width of this SimonButton
	 * @param nm name of this SimonButton, e.g. "Blue"
	 * @param sfn name of the .wav file containing the sound of this SimonButton
	 */
	public SimonButton(SimonPanel myBoard, Color off, int leftPct, int topPct, int widthPct, int heightPct, String nm, String sfn) {
		board = myBoard;
		normal = off.darker();
		highlight = off.brighter();
		left = leftPct;
		top = topPct;
		width = widthPct;
		height = heightPct;
		name = nm;
		soundFileName = sfn;
	}
	
	/** 
	 * Returns the name of this SimonButton.<br><br>
	 * Used primarily for debugging purposes
	 * @return the name of this SimonButton
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the unhighlighted color of this SimonButton
	 * @return the unhighlighted color of this SimonButton
	 */
	public Color getNormal() {
		return normal;
	}

	/**
	 * Returns the highlighted color of this SimonButton
	 * @return the highlighted color of this SimonButton
	 */
	public Color getHighlight() {
		return highlight;
	}

	/**
	 * Returns the left edge of this SimonButton (as a percentage of its SimonPanel size)
	 * @return the left edge of this SimonButton (as a percentage of its SimonPanel size)
	 */
	public int getLeft() {
		return left;
	}

	/**
	 * Returns the top edge of this SimonButton (as a percentage of its SimonPanel size)
	 * @return the top edge of this SimonButton (as a percentage of its SimonPanel size)
	 */
	public int getTop() {
		return top;
	}

	/**
	 * Returns the width of this SimonButton (as a percentage of its SimonPanel size)
	 * @return the width of this SimonButton (as a percentage of its SimonPanel size)
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the height of this SimonButton (as a percentage of its SimonPanel size)
	 * @return the height of this SimonButton (as a percentage of its SimonPanel size)
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * "Play" this SimonButton by highlighting it, playing its sound, and then unhighlighting it.
	 * 
	 */
	public void play() {
		board.highlightButton(this);
		board.playSound(soundFileName);
		board.dimButton(this);
	}
	
}
