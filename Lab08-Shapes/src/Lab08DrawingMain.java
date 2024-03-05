import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Simple main class to demonstrate the Shapes hierarchy
 * 
 * @author david levine
 * @version 6 November 2022
 *
 */
public class Lab08DrawingMain {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(800,500);
		Graphics2D g2 = panel.getGraphics();
		
		Shape s1 = new SolidRectangle(Color.green, 30, 30, 100, 100);
		s1.draw(g2);
		System.out.println(s1);
		
		s1 = new OpenOval(Color.red, 165, 50, 15, 50);
		s1.draw(g2);
		System.out.println(s1);

		s1 = new Star(Color.blue, 500, 250, 100);				
		s1.draw(g2);
		System.out.println(s1);
		
		s1 = new OpenOval(Color.magenta, 400, 250, 400, 250);
		s1.draw(g2);
		System.out.println(s1);
		
		s1 = new SolidCircle(Color.magenta, 400, 250, 50, 50);
		s1.draw(g2);
		System.out.println(s1);
	}

}
