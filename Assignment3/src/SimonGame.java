import java.util.ArrayList;
import java.util.Random;

/**
 * SimonGame - plays the Simon game with the user via a crude
 * graphical user interface
 * @author <your name here>
 * @version <your version here>
 *
 */
public class SimonGame {

	public static final int GAP = 400;
	public static SimonPanel sp;
	public static SimonButton[] buttons;
	
	public static void main(String[] args) throws InterruptedException {
//		sp = new SimonPanel();
//		buttons = sp.getButtons();
//		SimonButton[] buttons = sp.getButtons();
//		ArrayList<SimonButton> list = new ArrayList<>();
//		list.add(buttons[1]);
//		list.add(buttons[3]);
//		list.add(buttons[1]);
//		list.add(buttons[2]);
//		
//		playAll(list);	
		
		ArrayList<Integer> randList = new ArrayList<Integer>();
		Random rand = new Random();
		
		for(int i = 0; i < 10; i++) {
			
			int num = rand.nextInt(100);
			randList.add(num);
		}
		System.out.println(randList);
	}

	public static void playAll(ArrayList<SimonButton> sequence) {
		for (SimonButton b : sequence) {
			sp.sleep(GAP);
			b.play();
		}
	}
	
}
