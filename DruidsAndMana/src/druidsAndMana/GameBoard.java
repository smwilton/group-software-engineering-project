package druidsAndMana;

public class GameBoard {

	private ISquare[] squares;
	
	public GameBoard(IGameBoardBuilder iGameBoardBuilder) {
		this.squares = iGameBoardBuilder.buildGameBoard();
	}
	
	/**
	 * Returns the index of the square the player must move to.
	 * @param playerCurrentPosition
	 * @param placesToMove
	 * @return 
	 */
	public int newsquarePosition(int playerCurrentPosition, int placesToMove) {
		int total = playerCurrentPosition + placesToMove;
		return total > squares.length ? total - 14 : total;
	}
		
	/**
	 * Check if the square is grassland
	 * @param squareIndex
	 */
	public boolean squareIsGrassland(int squareIndex) {
		return squares[squareIndex] instanceof GrasslandBase;
	}
	
	/**
	 * Returns a description of the current square
	 * @param squareIndex
	 * @return
	 */
	public String squareDescription(int squareIndex) {
		return squares[squareIndex].description();
	}
	
	/**
	 * Returns ascii arts for the given square
	 * @param squareIndex
	 * @return
	 */
	public String squareAsciiArt(int squareIndex) {
		return squares[squareIndex].asciiArt();
	}
	
	/**
	 * Charge in mana to be the player, can be +ve or -ve
	 * @param squareIndex
	 * @return
	 */
	public int manaCharge(int squareIndex) {
		return squares[squareIndex].manaCharge();
	}
	
	/**
	 * If the square is owned returns the players id, else returns null:
	 * @param squareIndex
	 * @return 
	 */
	public String getSquareOwnerId(int squareIndex) {
		ISquare square = squares[squareIndex];
		if(square instanceof GrasslandBase) {
			GrasslandBase grasslandSquare = (GrasslandBase)square;
			return grasslandSquare.getOwnerId();
		}
		return null;
	}
	
	/**
	 * If a square is not owned then a player can take ownership
	 * @return
	 */
	public boolean setSquareOwnerId(int squareIndex, String playerId) { //Tighten this method up!
		ISquare square = squares[squareIndex];
		if(square instanceof GrasslandBase) {
			GrasslandBase grasslandSquare = (GrasslandBase)square;
			grasslandSquare.setOwnerId(playerId);
			return true;
		}
		return false;
	}
			
	/**
	 * If the player owns all the grasslands in a realm they can start upgrading the squares:
	 * @param playerId
	 * @param squareIndex
	 * @return
	 */
	public boolean playerCanUpgrade(String playerId, int squareIndex) {
		ISquare currSquare = squares[squareIndex];
		
		// Cannot upgrade a square that is not grass land:
		if(!(currSquare instanceof GrasslandBase)) {
			return false;
		}
		
		GrasslandBase currGrasslandSquare = (GrasslandBase)currSquare;
		
		for(ISquare square : squares) {
			
			if(!(square instanceof GrasslandBase)) { 
				continue; 
			}

			GrasslandBase grasslandSquare = (GrasslandBase)square;
			
			if(currGrasslandSquare.getClass() == grasslandSquare.getClass()) {
				if(playerId != grasslandSquare.getOwnerId()) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * @param squareIndex
	 * @return
	 */
	public int costToUpgrade(String playerId, int squareIndex) {
		ISquare currSquare = squares[squareIndex];
		
		// Cannot upgrade a square that is not grass land:
		if(currSquare instanceof GrasslandBase) {
			GrasslandBase grasslandSquare = (GrasslandBase)currSquare;
			return grasslandSquare.developmentCost();
		}

		return 0;
	}
	
	
	/**
	 * @param squareIndex
	 * @return
	 */
	public SquareStatus getSquareType(int squareIndex) {

		return SquareStatus.Grassland;
	}	
}
