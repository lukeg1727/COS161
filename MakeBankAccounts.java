import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * A simple program to create a CSV file of BankAccounts
 * @author David Levine
 * @version 23 February 2024
 *
 */
public class MakeBankAccounts {

	public static void main(String[] args) throws FileNotFoundException {
		BankAccount[] accts = {
				new BankAccount("John Smith", "C843", 500),
				new BankAccount("Mackenzie Scott", "AMZ002", 123456.34),
				new BankAccount("Churchmouse", "23450", 0.02),
				new BankAccount("Harry Potter", "9 3/4", 34921.30),
				new BankAccount("James Bond", "007", 1963.45),
				new BankAccount("Donald Duck", "DISNEY007", 43.12),
				new BankAccount("Robin Hood", "34Locksley17", 1712.00),
				new BankAccount("Mt. Katahdin", "04462", 52.69),
				new BankAccount("Isaac Newton", "98521", 9.80),
				new BankAccount("Xyzzy", "83292", 1967)	};

		PrintWriter output = new PrintWriter("BankAccounts.csv");
		
		// Write the data that you want
		for (int i=0; i<accts.length; i++) {
			output.println(accts[i]);
		}
		
		// Close the PrintWriter or the file won't exist on disk
		output.close();
		System.out.println("Bank Accounts file written.");

		
	}

}