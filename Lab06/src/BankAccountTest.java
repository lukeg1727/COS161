import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTest {

	@Test
	void GetBalanceTest() {
	BankAccount ba = new BankAccount("Jaylen Brown", "Bos7", 1000000);
	BankAccount ba2 = new BankAccount("Jayson Tatum", "Bos0", 1000000);
	
	assertEquals(1000000, ba.getAcctBalance());
	assertEquals(1000000, ba2.getAcctBalance());

	}
	@Test
	void TestDeposit() {
		BankAccount ba = new BankAccount("Jaylen Brown", "Bos7", 1000000);
		BankAccount ba2 = new BankAccount("Jayson Tatum", "Bos0", 1000000);
		
		ba.deposit(10);
		ba2.deposit(10);
		
		assertEquals(1000010, ba.getAcctBalance());
		assertEquals(1000010, ba2.getAcctBalance());
	}
	@Test
	void TestWithdraw() {
		BankAccount ba = new BankAccount("Jaylen Brown", "Bos7", 1000000);
		BankAccount ba2 = new BankAccount("Jayson Tatum", "Bos0", 1000000);
		
		ba.withdraw(10);
		ba2.withdraw(10);
		
		assertEquals(999990, ba.getAcctBalance());
		assertEquals(999990, ba2.getAcctBalance());
	}
	@Test 
	void TestToString() {
		BankAccount ba = new BankAccount("Jaylen Brown", "Bos7", 1000000);
		BankAccount ba2 = new BankAccount("Jayson Tatum", "Bos0", 1000000);
		
		assertEquals("BankAccount for: Jaylen Brown, Account ID: Bos7, Balance: $1000000.0", ba.toString());
		assertEquals("BankAccount for: Jayson Tatum, Account ID: Bos0, Balance: $1000000.0", ba2.toString());

	}
	@Test
	void TestPayInterest() {
        SavingsAccount sa = new SavingsAccount("Jaylen Brown", "Bos7", 1000000);
        sa.payInterest();
        assertEquals(1050000, sa.getAcctBalance());
	}
	@Test
	void TestToStringSavings() {
        SavingsAccount sa = new SavingsAccount("Jaylen Brown", "Bos7", 1000000);
		SavingsAccount sa2 = new SavingsAccount("Jayson Tatum", "Bos0", 1000000);
		
		assertEquals("BankAccount for: Jaylen Brown, Account ID: Bos7, Balance: $1000000.0, Interest Rate: 0.05", sa.toString());
		assertEquals("BankAccount for: Jayson Tatum, Account ID: Bos0, Balance: $1000000.0, Interest Rate: 0.05", sa2.toString());
	}
	@Test
	void TestPayFees() {
		CheckingAccount ca = new CheckingAccount("Jaylen Brown", "Bos7", 1000000);
		ca.deposit(20);
		ca.withdraw(10);
		ca.payFees();
		assertEquals(1000009.90, ca.getAcctBalance() );
	
	}
	
	
}
