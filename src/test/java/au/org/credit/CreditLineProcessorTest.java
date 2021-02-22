package au.org.credit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CreditLineProcessorTest {
	
	/**
	 * This test checks the read file method of credit processor.
	 */
	@Test
	void testProcessCredits() {
		CreditLineProcessor processor = new CreditLineProcessor();
		try {
			processor.processCredits();
			Assert.assertNotNull(processor.getTrees());
		} catch (IOException e) {
			Assert.fail("Data file read failiure");
		}
	}

	@Test
	void testCalculateCombinedUtilisation() {
		fail("Not yet implemented");
	}

}
