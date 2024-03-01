import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A simple program to read an array of BankAccounts from a CSV
 * file so that they can eventually be sorted.
 * @author me  <change this!>
 * @version now <change this, too!>
 *
 */
public class SortBankAccounts {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fromFile = new Scanner(new File("BankAccounts.csv"));
		BankAccount accts[] = new BankAccount[10];
		int count = 0;
		
		while (fromFile.hasNext()) {
			String acctData = fromFile.nextLine();
			String[] acctPieces = acctData.split(",");
			String name = acctPieces[0];
			String ID = acctPieces[1];
			double bal = Double.parseDouble(acctPieces[2]);
			accts[count] = new BankAccount(name, ID, bal);
			count++;	
		}
		fromFile.close();		
		
//		 for (int i = 0; i < count; i++) {
//	            System.out.println(accts[i]);
//	        }
		Arrays.sort(accts);
		System.out.println(Arrays.toString(accts));
	}

}