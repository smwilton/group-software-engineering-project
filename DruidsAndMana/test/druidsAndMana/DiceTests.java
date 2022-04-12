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

	int upperLimit1Dice, lowerLimit1Dice, upperLimit5Dice, lowerLimit5Dice;
	Dice diceSingle, diceMulti;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		upperLimit1Dice = 4;
		lowerLimit1Dice = 1;
		diceSingle = new Dice();

		upperLimit5Dice = 20; // 5 dice x the max that can be achieved 4 = 20
		lowerLimit5Dice = 5; // 5 dice x the minimum that can be achieved 1 = 5
		diceMulti = new Dice(5);
	}

	/**
	 * Test method for {@link druidsAndMana.Dice#Dice()}.
	 * <p>
	 * Tests that the object is an instance of Dice and that the number of dice is
	 * set to 1.
	 */
	@Test
	void testDefaultConstructor() {
		Dice diceTest = new Dice();
		assertTrue(diceTest instanceof Dice);
		assertEquals(1, diceTest.getNumDice());
	}

	/**
	 * Test method for {@link druidsAndMana.Dice#Dice(int)}.
	 * <p>
	 * Tests that the object is an instance of Dice and that the number of dice is
	 * set to 5 (i.e. with a valid param).
	 */
	@Test
	void testConstructorwithArgsValid() {
		Dice diceTest = new Dice(5);
		assertTrue(diceTest instanceof Dice);
		assertEquals(5, diceTest.getNumDice());
	}

	/**
	 * Test method for {@link druidsAndMana.Dice#Dice(int)}.
	 * <p>
	 * Tests that an exception is thrown when an invalid param is entered.
	 */
	@Test
	void testConstructorwithArgsInvalid() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			Dice diceTest = new Dice(0);
		});
		assertEquals("Number of Dice must be a positive whole number greater than 0", e.getMessage());
	}

	/**
	 * Test method for {@link druidsAndMana.Dice#getNumDice()} and
	 * {@link druidsAndMana.Dice#setNumDice(int)}.
	 * <p>
	 * Tests the getter and setter for the Number of Dice with valid data
	 */
	@Test
	void testSetAndGetNumDiceValid() {
		assertNotEquals(20, diceMulti.getNumDice());
		diceMulti.setNumDice(20);
		assertEquals(20, diceMulti.getNumDice());
	}

	/**
	 * Test method for {@link druidsAndMana.Dice#getNumDice()} and
	 * {@link druidsAndMana.Dice#setNumDice(int)}.
	 * <p>
	 * Tests the getter and setter for the Number of Dice with invalid data
	 */
	@Test
	void testSetAndGetNumDiceInvalid() {
		// Testing with 0
		assertNotEquals(0, diceMulti.getNumDice());
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			diceMulti.setNumDice(0);
		});
		assertEquals("Number of Dice must be a positive whole number greater than 0", e.getMessage());
		
		// Testing with a negative number
		assertNotEquals(-5, diceMulti.getNumDice());
		e = assertThrows(IllegalArgumentException.class, () -> {
			diceMulti.setNumDice(-5);
		});
		assertEquals("Number of Dice must be a positive whole number greater than 0", e.getMessage());
	}

	/**
	 * Test method for {@link druidsAndMana.Dice#rollDice()}.
	 */
	@Test
	void testRollDice() {
		// Single Dice
		int result1 = diceSingle.rollDice();

		if (result1 >= lowerLimit1Dice && result1 <= upperLimit1Dice) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		// Multiple Dice
		int result2 = diceMulti.rollDice();

		if (result2 >= lowerLimit5Dice && result2 <= upperLimit5Dice) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

}
