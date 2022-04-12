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

	// instance var
	private int numDice;

	// Constructor
	/**
	 * Default Constructor
	 * <p>
	 * This constructor will create 1 single dice
	 */
	public Dice() {
		this.setNumDice(1);
	}

	/**
	 * Constructor with args
	 * <p>
	 * This constructor expects an int greater than 0 as a param. It allows multiple
	 * Dice to be declared at once.
	 * 
	 * @param numDice
	 * @throws IllegalArgumentException if the number is not greater than or equal
	 *                                  to 0
	 */
	public Dice(int numDice) throws IllegalArgumentException {
		this.setNumDice(numDice);
	}

	// Methods

	/**
	 * Method to get the number of dice that has been set
	 * 
	 * @return the number of Dice in play
	 */
	public int getNumDice() {
		return numDice;
	}

	/**
	 * Method to set the number of dice
	 * 
	 * @param numDice - the number of Dice to set
	 * @throws IllegalArgumentException if the number is not greater than or equal
	 *                                  to 0
	 */
	public void setNumDice(int numDice) throws IllegalArgumentException {
		if (numDice < 1) {
			throw new IllegalArgumentException("Number of Dice must be a positive whole number greater than 0");
		} else {
			this.numDice = numDice;
		}
	}

	/**
	 * Method to Roll the Dice
	 * 
	 * @return - the result as an int
	 */
	public int rollDice() {
		int result = 0;
		Random random = new Random();
		for (int i = 0; i < this.numDice; i++) {
			int roll = (random.nextInt(NUM_SIDES)) + 1;
			result += roll;
		}
		return result;
	}

}
