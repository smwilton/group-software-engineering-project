package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing of the Dice class
 * 
 * @author Nicola Stirling 40020701
 *
 */
class DiceTests {

	int upperLimit, lowerLimit;
	Dice dice;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		upperLimit = 4;
		lowerLimit = 1;
		dice = new Dice();
	}

	/**
	 * Test method for {@link druidsAndMana.Dice#rollDice()}.
	 */
	@Test
	void testRollDice() {
		int result = dice.rollDice();

		if (result >= lowerLimit && result <= upperLimit) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

}
