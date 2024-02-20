
public class SavingsAccount extends BankAccount {
	
	double interestRate;
	
	SavingsAccount(String name, String ID, double balance) {
		super(name, ID, balance);
		interestRate = 0.05;
	}
	
	public void payInterest() {
		super.deposit(super.getAcctBalance() * interestRate);
	}
	public String toString() {
		
	}
}
