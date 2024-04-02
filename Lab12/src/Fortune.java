import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * A fortune teller - will enable the client user to obtain a "fortune cookie"
 * style fortune.
 * 
 * @author david levine and <your name here>
 * @version 26 November 2022 (although you will need to update this)
 *
 */
public class Fortune {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		Scanner mystic = new Scanner(new File("fortunes.txt"));
		ArrayList<String> fortunes = new ArrayList<>();
		while (mystic.hasNextLine()) {
			fortunes.add(mystic.nextLine());
		}
		mystic.close();

		//System.out.println(getFortune(fortunes));

		System.out.println(keepKey(fortunes, "in"));
	}

	/**
	 * Return a random fortune from a non-empty list of possible fortunes.
	 * @param fortunes the list of possible fortunes
	 * @return the fortune for this invocation of the method
	 */
	public static String getFortune(List<String> fortunes) {
		
		Random rand = new Random();
		
		int index = rand.nextInt(10);
		
		return fortunes.get(index);

	}
	
	public static ArrayList<String> keepKey(List<String> fortunes, String key) {
		
		ArrayList<String> filteredFortunes = new ArrayList<String>();
		
		for(int i = 0; i < fortunes.size(); i++) {
			if(fortunes.get(i).contains(key)) {
				filteredFortunes.add(fortunes.get(i));
			}
		}
		return filteredFortunes;
	}
	

}
