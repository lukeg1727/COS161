import java.awt.Color;
import java.awt.Graphics;


public class SolidCircle extends Shape {

	private int xCenter;
	private int yCenter;
	private int xRad;
	private int yRad;
	
	public SolidCircle(Color c, int cx, int cy, int xr, int yr) {
		super(c);
		xCenter = cx;
		yCenter = cy;
		xRad = xr;
		yRad = yr;
	}
	
	public void draw(Graphics g) {
		g.setColor(getMyBaseColor());
		g.fillOval(xCenter - xRad, yCenter - yRad, 2 * xRad, 2 * yRad);				
	}
	
}
