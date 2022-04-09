package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Testing of the Dice class
 * 
 * @author Nicola
 *
 */
class TestDice {
	
	int upperLimit, lowerLimit;
	Dice dice;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		upperLimit = 4;
		lowerLimit = 1;
	}

	/**
	 * Test method for {@link druidsAndMana.Dice#rollDice()}.
	 */
	@Test
	void testRollDice() {
		fail("Not yet implemented");
	}

}
