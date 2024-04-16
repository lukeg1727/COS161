import java.io.IOException;
import java.util.Scanner;
public class Add {

	public static void main(String[] args) {
		
		int N = Integer.parseInt(args[0]);
		
		Scanner scnr = new Scanner(System.in);
		while(scnr.hasNextLine()) {
			System.out.println(N + Integer.parseInt(scnr.nextLine()));
		}
	}

}
