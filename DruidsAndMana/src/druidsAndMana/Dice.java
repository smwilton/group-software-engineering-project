package druidsAndMana;

import java.util.Random;

/**
 * Class the represents one dice object
 * 
 * @author Nicola
 *
 */
public class Dice {

	// Declare Constant
	/**
	 * Given that the boardgame consists of 12 squares the design decision has been
	 * made to use a 4 sided dice so Players will not lap the board during their
	 * turn.
	 * 
	 * If the game was to expand this constant could be updated by the developer
	 */
	private static final int NUM_SIDES = 4;

	// Constructor
	/**
	 * Default Constructor
	 */
	public Dice() {

	}

	// Method
	/**
	 * Method to Roll the Dice
	 * 
	 * @return - the result as an int
	 */
	public int rollDice() {
		int result = 0;
		Random random = new Random();
		result = (random.nextInt(NUM_SIDES)) + 1;
		return result;
	}

}
