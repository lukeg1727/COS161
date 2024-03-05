import java.awt.Color;
import java.awt.Graphics;

/**
 * Shape - an abstract shape class for use with simple drawing.
 * 
 * Shapes are assumed to exist within a "bounding box" 
 * @author david levine
 * @version 5 November 2022
 *
 */
abstract public class Shape {

	private Color myBaseColor;
	
	/**
	 * Constructor for shape.
	 * Note that we cannot construct a Shape per se, as it
	 * is an abstract class, but this constructor is provided so
	 * that extending classes may initialize appropriate variables.
	 *  
	 * @param c color in which the shape is drawn
	 */
	public Shape(Color c) {
		myBaseColor = c;
	}

	/**
	 * Return the base color of this shape
	 * @return the base color of this shape
	 */
	public Color getMyBaseColor() {
		return myBaseColor;
	}

	/**
	 * Set the base color of this shape
	 * @param newBaseColor the base color of this shape
	 */

	public void setMyBaseColor(Color newBaseColor) {
		myBaseColor = newBaseColor;
	}

	/**
	 * Draw this shape in a panel's Graphics object
	 * @param g the Graphics object upon which to draw the shape
	 */
	abstract public void draw(Graphics g);
	
	/**
	 * Return a "String-ified" version of this shape
	 * @return this shape expressed as a comma separated String
	 */
	public String toString() {
		return this.getClass().getName() + "," +
	           myBaseColor.getRed() + "," +
			   myBaseColor.getGreen() + "," +
	           myBaseColor.getBlue();
	}
}