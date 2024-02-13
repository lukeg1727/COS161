import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClearPasswordTest {

	@Test
	void testGetUserName() {
		ClearPassword user = new ClearPassword("Luke_Gagne", "23255");
		ClearPassword user1 = new ClearPassword("M.Gustave", "Boy_With_Apple");
		assertEquals("M.Gustave", user1.getUserName());
		assertEquals("Luke_Gagne", user.getUserName());

		
	}
@Test
	void testToString() {
	ClearPassword user = new ClearPassword("Luke_Gagne", "23255");
	ClearPassword user1 = new ClearPassword("M.Gustave", "Boy_With_Apple");
	assertEquals("<Luke_Gagne,23255>", user.toString());
	}
}
