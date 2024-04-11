import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Quick demo of JOptionPanes as they apply to simple game dialogs.
 * Note: the messages are obscured so that you concentrate on the dialogs.
 * 
 * @author david levine
 * @version 4 April 2023
 *
 */
public class OptionPaneDemo {

	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Click OK to begin the game");
		
		// Yeah, garbage - not your worry
		String[] messages = { "Hd_ao, B n_c.", "T`gio, rgl acfW." };
		
		Random rg = new Random();
		
		do {
				String msg = messages[rg.nextInt(2)];
				JOptionPane.showMessageDialog(null, demangle(msg));
		} while (JOptionPane.showConfirmDialog(null, "Do you wish to play again?", "Play again?", JOptionPane.YES_NO_OPTION) 
				   == JOptionPane.YES_OPTION);
	}
	
	/**
	 * Turn the given message from garbage into something more readable
	 * @param s the garbage version of the message
	 * @return the more readable version of the message
	 */
	public static String demangle(String s) {
		String ans = "";
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			ans += (Character.isLetter(c+i)) ? (char) (c + i) : c;		
		}
		return ans;
	}
	

}
