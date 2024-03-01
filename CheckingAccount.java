
public class CheckingAccount extends BankAccount {
	
	private int transactionCounter;
	private final double TRANSACTION_FEE = 0.05;
	
	public CheckingAccount(String acctName, String acctID, double acctBalance) {
		super(acctName, acctID, acctBalance);
		transactionCounter = 0;
	}
	public void deposit(double amount) {
        super.deposit(amount);
        transactionCounter++;
    }
	public void withdraw(double amount) {
        super.withdraw(amount);
        transactionCounter++;
    }
	public void payFees() {
		double charges = TRANSACTION_FEE * transactionCounter++;
		super.withdraw(charges);
		transactionCounter = 0;
	}
}
