import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * A test case for the BankAccount class.
 * This test case tests the "Lab 3" version of the class,
 * but includes a "commented out" version of a test for 
 * preconditions.
 *  
 * @author david levine 
 * @version 30 September 2022 
 * 
 *  Note: some of this test data is a BAD idea; ask me why in class on Wednesday!
 */
public class BankAccountJUnit {

	private BankAccount typical;
	private BankAccount rich;
	private BankAccount poor;
	
	// Use of this method guarantees that the starting values of
	// each BankAccount are reset before each test
	@BeforeEach
	void setUp() throws Exception {
		typical = new BankAccount("John Smith", "C843", 500.01);
		rich = new BankAccount("Mackenzie Scott", "AMZ002", 123456.34);
		poor = new BankAccount("Churchmouse", "23450", 0.02);
	}

	@Test
	void testGetters() {
		assertEquals("John Smith", typical.getAcctName());
		assertEquals("C843", typical.getAcctID());
		assertEquals(500.01, typical.getAcctBalance(), 0.01);
		
		// Note the use of the third parameter for the assertEquals on balance
		//    doubles (and floats) are only stored in the system as approximations
		//    of the correct number.  Sometimes, if a given mathematical quantity
		//    is computed two different ways, then the system may have very slightly
		//    different representations of it.  Think of dividing one by three on
		//    a calculator and then multiplying by three.  Mathematically, the
		//    result should be 1, but you might get 0.999999999999.  assertEquals 
		//    uses the third parameter as the granularity of the comparison.  
		//    In this case, if the two values are within 0.01, the assertion will work.
		//    And, of course, banks only work to the nearest penny anyway!
		
		assertEquals("Mackenzie Scott", rich.getAcctName());
		assertEquals("AMZ002", rich.getAcctID());
		assertEquals(123456.34, rich.getAcctBalance(), 0.01);
		assertEquals("Churchmouse", poor.getAcctName());
		assertEquals("23450", poor.getAcctID());
		assertEquals(0.02, poor.getAcctBalance(), 0.01);
	}
	
	@Test
	void testToString() {
		assertEquals("John Smith,C843,500.01", typical.toString());
		assertEquals("Mackenzie Scott,AMZ002,123456.34", rich.toString());
		assertEquals("Churchmouse,23450,0.02", poor.toString());
	}
	
	@Test
	void testDeposit() {
		assertEquals(500, typical.getAcctBalance(), 0.01);
		typical.deposit(43.21);
		assertEquals(543.22, typical.getAcctBalance(), 0.01);
		assertEquals(0.02, poor.getAcctBalance(), 0.01);
		poor.deposit(1);
		assertEquals(543.22, typical.getAcctBalance(), 0.01);
		assertEquals(1.02, poor.getAcctBalance(), 0.01);
	}
	
	@Test
	void testWithdraw() {
		assertEquals(123456.34, rich.getAcctBalance(), 0.01);
		rich.withdraw(120000.04);
		assertEquals(3456.3, rich.getAcctBalance(), 0.01);
		assertEquals(500, typical.getAcctBalance(), 0.01);
		typical.withdraw(499.99);
		assertEquals(0.02, typical.getAcctBalance(), 0.01);
		assertEquals(0.02, poor.getAcctBalance(), 0.01);
		poor.withdraw(0.02);
		assertEquals(0, poor.getAcctBalance(), 0.01);
		assertEquals(3456.3, rich.getAcctBalance(), 0.01);
	}

//	@Test
	void testOverdraft() {
		try {
			typical.withdraw(7777.77);
			fail("Account was permitted to withdraw more than balance!");
		} catch (IllegalArgumentException iae) {
		}
	}
}