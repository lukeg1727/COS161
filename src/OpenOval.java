import java.awt.Color;
import java.awt.Graphics;

/**
 * OpenCircle - A (hollow) oval that can be drawn on a panel
 * @author david levine
 * @version 5 November 2022
 *
 */
public class OpenOval extends Shape {

	private int centerX;
	private int centerY;
	private int xRadius;
	private int yRadius;
	
	/**
	 * Constructor 
	 * @param c the base color of this oval
	 * @param cx x-coordinate of the center of the oval
	 * @param cy y-coordinate of the center of the oval
	 * @param xr horizontal radius of the oval
	 * @param yr vertical radius of the oval
	 * 
	 */
	public OpenOval(Color c, int cx, int cy, int xr, int yr) {
		super(c);
		centerX = cx;
		centerY = cy;
		xRadius = xr;
		yRadius = yr;
	}

	/**
	 * Draw this shape in a panel's Graphics object
	 * @param g the Graphics object upon which to draw the shape
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getMyBaseColor());
		g.drawArc(centerX-xRadius, centerY-yRadius, 2*xRadius, 2*yRadius,0,360);				
	}

	/**
	 * Return a "String-ified" version of this shape
	 * @return this shape expressed as a comma separated String
	 */
	public String toString() {
		return super.toString() + "," +
	           centerX + "," +
			   centerY + "," +
	           xRadius + "," +
			   yRadius;
	}

}
