package druidsAndMana;

import java.util.ArrayList;

/**
 * 
 * @author pete
 *
 */

public interface IGameBoard {

	/**
	 * Returns the index of the square the player must move to.
	 * @param playerCurrentPosition
	 * @param placesToMove
	 * @return 
	 */
	int newsquarePosition(int playerCurrentPosition, int placesToMove);

	/**
	 * Check if the square is grassland
	 * @param squareIndex
	 */
	boolean squareIsGrassland(int squareIndex);

	/**
	 * Returns a description of the current square
	 * @param squareIndex
	 * @return
	 */
	String squareDescription(int squareIndex);

	/**
	 * Returns ascii arts for the given square
	 * @param squareIndex
	 * @return
	 */
	String squareAsciiArt(int squareIndex);

	/**
	 * Charge in mana to be the player, can be +ve or -ve
	 * @param squareIndex
	 * @return
	 */
	int manaCharge(int squareIndex);

	/**
	 * If the square is owned returns the players id, else returns null:
	 * @param squareIndex
	 * @return 
	 */
	int getSquareOwnerId(int squareIndex);

	/**
	 * Returns the CO2 impact rating for the given square
	 * @param squareIndex
	 * @return 
	 */
	int getCO2Modifier(int squareIndex);

	/**
	 * Returns an ArrayList of all squares owned by given player.
	 * @param playerNumber
	 * @return
	 */
	ArrayList<Grassland> getAllPlayerOwnedGrasslands(Player currentPlayer);

	/**
	 * If a square is not owned then a player can take ownership
	 * @return
	 */
	boolean setSquareOwnerId(int squareIndex, int playerId);

	/**
	 * If the player owns all the grasslands in a realm they can start upgrading the squares:
	 * @param playerId
	 * @param squareIndex
	 * @return
	 */
	boolean playerCanUpgrade(int playerId, int squareIndex);

	/**
	 * @param squareIndex
	 * @return
	 */
	int costToUpgrade(int squareIndex);

	/**
	 * @param squareIndex
	 * @return
	 */
	SquareStatus getSquareType(int squareIndex);

	/**
	 * Method to develop Grassland to it's next tier
	 * @param squareIndex
	 */
	void upgradeGrassland(int squareIndex);

}