
public class SavingsAccount extends BankAccount {
	
	private double interestRate;
	
	SavingsAccount(String acctName, String acctID, double acctBalance) {
		super(acctName, acctID, acctBalance);
		interestRate = 0.05;
	}
	
	public void payInterest() {
		super.deposit(super.getAcctBalance() * interestRate);
	}
	public String toString() {
		return super.toString() + ", Interest Rate: " + interestRate;
	}
}
