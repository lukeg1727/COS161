import java.awt.Color;
import java.awt.Graphics;

/**
 * Star - A (hollow) star that can be drawn on a panel
 * @author david levine
 * @version 6 November 2022
 *
 */
public class Star extends Shape {

	private int xTop;
	private int yTop;
	private int starSize;
	
	/**
	 * Constructor 
	 * @param c the base color of this star
	 * @param ul the upper left of the star's bounding box
	 * @param sz the size of the star's bounding box
	 */
	public Star(Color c, int xt, int yt, int ss) {
		super(c);
		xTop = xt;
		yTop = yt;
		starSize = ss;
	}
	
	
	/**
	 * Draw this shape in a panel's Graphics object
	 * @param g the Graphics object upon which to draw the shape
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getMyBaseColor());
		g.drawLine(xTop, yTop, xTop-starSize*3/10, yTop+starSize);
		g.drawLine(xTop-starSize*3/10, yTop+starSize, xTop+starSize/2, yTop+starSize/3);
		g.drawLine(xTop+starSize/2, yTop+starSize/3, xTop-starSize/2, yTop+starSize/3);
		g.drawLine(xTop-starSize/2, yTop+starSize/3, xTop+starSize*3/10, yTop+starSize);
		g.drawLine(xTop+starSize*3/10, yTop+starSize, xTop, yTop);
	}

	/**
	 * Return a "String-ified" version of this shape
	 * @return this shape expressed as a comma separated String
	 */
	public String toString() {
		return super.toString() + "," +
	           xTop + "," +
			   yTop + "," +
			   starSize;
	}
	
}
