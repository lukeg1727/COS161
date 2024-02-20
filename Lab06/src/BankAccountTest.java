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
}
