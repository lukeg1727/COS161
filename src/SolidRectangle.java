import java.awt.Color;
import java.awt.Graphics;

/**
 * RectangleShape - A rectangle that can be drawn on a panel
 * @author david levine
 * @version 5 November 2022
 *
 */
public class SolidRectangle extends Shape {
	
	private int left;
	private int upper;
	private int right;
	private int lower;
	
	/**
	 * Constructor 
	 * @param c the base color of this rectangle
	 * @param le left edge of this rectangle
	 * @param u top edge of this rectangle
	 * @param r right edge of this rectangle
	 * @param lo bottom edge of this rectangle;
	 */
	public SolidRectangle(Color c, int le, int u, int r, int lo) {
		super(c);
		left = le;
		upper = u;
		right = r;
		lower = lo;
	}
	
	/**
	 * Draw this shape in a panel's Graphics object
	 * @param g the Graphics object upon which to draw the shape
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getMyBaseColor());
		g.fillRect(left, upper, right-left, lower-upper);				
	}
	
	/**
	 * Return a "String-ified" version of this shape
	 * @return this shape expressed as a comma separated String
	 */
	public String toString() {
		return super.toString() + "," +
	           left + "," +
			   upper + "," +
	           right + "," +
			   lower;
	}

}
