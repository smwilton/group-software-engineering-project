package druidsAndMana;

public class GameBoard {

	private ForestSquare[] forestSquares;
	
	public GameBoard(IGameBoardBuilder iGameBoardBuilder, int noSquares) {
		this.forestSquares = iGameBoardBuilder.buildGameBoard(noSquares);
	}
	
	/**
	 * Returns the index of the square the player must move to.
	 * @param playerCurrentPosition
	 * @param placesToMove
	 * @return 
	 */
	public int newsquarePosition(int playerCurrentPosition, int placesToMove) {
		int total = playerCurrentPosition + placesToMove;
		return total > forestSquares.length ? total - 14 : total;
	}
		
	/**
	 * If the square is owned returns the players id, else returns null:
	 * @param squareIndex
	 * @return 
	 */
	public String getsquareOwnerId(int squareIndex) {
		return forestSquares[squareIndex].owner;
	}
	
	/**
	 * If a square is not owned then a player can take ownership
	 * @return
	 */
	public void setsquareOwnerId(int squareIndex, String playerId) {
		forestSquares[squareIndex].Name = playerId;
	}
	
	/**
	 * @param squareIndex
	 * @return
	 */
	public int manaCharge(int squareIndex) {
		//TODO: some calculation to determine the cost (if any) incurred by landing on this square
		return 0;
	}
		
	/**
	 * @param playerId
	 * @param squareIndex
	 * @return
	 */
	public boolean playerCanUpdate(String playerId, int squareIndex) {
		//TODO: if the player owns this square and all the others in a realm they can upgrade it etc:
		return false;
	}
	
	/**
	 * @param squareIndex
	 * @return
	 */
	public int costToUpgrade(String playerId, int squareIndex) {
		//TODO: calculate the cost to upgrade the square
		return 0;
	}
		
	/**
	 * @param squareIndex
	 * @return
	 */
	public SquareType getSquareType(int squareIndex) {
		// TODO: get the current square type
		return SquareType.Grassland;
	}	
}
