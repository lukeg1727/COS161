/**
 * BankAccount - A class that contains constructors and methods that allow creation of 
 * a unique bank account, and methods that allow the ability to deposit and withdraw
 * 
 * @author Luke_Gagne
 * @version 2/2/24
 * 
 */
public class BankAccount {

	private String acctName;
	private String acctID;
	private double acctBalance;
	
	/**
	 * 'BankAccount' Constructs a new bank account object with specific account details
	 * @param 'acctName' The name associated with the user account
	 * @param 'acctID' The user accounts unique identifier
	 * @param 'acctBalance' The initial balance of the user Account
	 */
	public BankAccount(String acctName, String acctID, double acctBalance) {
		this.acctName = acctName;
		this.acctID = acctID;
		this.acctBalance = acctBalance;
	}
	/**
	 * 'BankAccount' A default constructor that creates a new bank account object with default values
	 */
	public BankAccount() {
		acctName = "NOT A REAL USER";
		acctID = "-1";
		acctBalance = 00.00;
	}
	
	 /**
     * Retrieves the name associated with the bank account.
     *
     * @return The account name.
     */
	public String getAcctName() {
		return acctName;
	}
	
	 /**
     * Retrieves the unique identifier associated with the bank account.
     *
     * @return The accounts identifier.
     */
	public String getAcctID() {
		return acctID;
	}
	
	 /**
     * Retrieves the balance associated with the bank account.
     *
     * @return The accounts balance.
     */
	public double getAcctBalance() {
		return acctBalance;
	}
	
	 /**
     * 'deposit' inserts money into the accounts balance
     *@param 'amount' the amount of money to deposit into the account
     * @return the sum of the accounts balance and the specified amount deposited
     *  precondition: amount > 0
     */
	void deposit(double amount) {
		
		acctBalance += amount;
	}
	
	/**
     * 'withdraw' inserts money into the accounts balance
     *@param 'amount' the amount of money to withdraw from the account
     * @return the difference of the amount withdrawn, and the account balance
     *  precondition: amount <= acctBalance
     */
	void withdraw(double amount) {
		acctBalance -= amount;
	}
	
	/**
     * 'toString' Converts the contents of a bank account object into a string
     * @return A string that lists information about the bank account
     */
	public String toString() {
		
		return ("BankAccount for: " + acctName + ", Account ID: " + acctID + ", Balance: $" + acctBalance);
	}

}
