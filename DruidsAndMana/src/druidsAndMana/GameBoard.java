package druidsAndMana;

import java.util.ArrayList;

/**
 * 
 * @author pete
 *
 */

public class GameBoard implements IGameBoard {

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
	@Override
	public int newsquarePosition(int playerCurrentPosition, int placesToMove) {
		int total = playerCurrentPosition + placesToMove;
		return total > squares.length ? total - 14 : total;
	}
		
	/**
	 * Check if the square is grassland
	 * @param squareIndex
	 */
	@Override
	public boolean squareIsGrassland(int squareIndex) {
		return squares[squareIndex] instanceof Grassland;
	}
	
	/**
	 * Returns a description of the current square
	 * @param squareIndex
	 * @return
	 */
	@Override
	public String squareDescription(int squareIndex) {
		return squares[squareIndex].description();
	}
	
	/**
	 * Returns ascii arts for the given square
	 * @param squareIndex
	 * @return
	 */
	@Override
	public String squareAsciiArt(int squareIndex) {
		return squares[squareIndex].asciiArt();
	}
	
	/**
	 * Charge in mana to be the player, can be +ve or -ve
	 * @param squareIndex
	 * @return
	 */
	@Override
	public int manaCharge(int squareIndex) {
		return squares[squareIndex].getChargeForLandingOnSquare();
	}
	
	/**
	 * If the square is owned returns the players id, else returns null:
	 * @param squareIndex
	 * @return 
	 */
	@Override
	public int getSquareOwnerId(int squareIndex) {
		ISquare square = squares[squareIndex];
		if(square instanceof Grassland) {
			Grassland grasslandSquare = (Grassland)square;
			return grasslandSquare.getOwnerId();
		}
		return 0;
	}
	
	/**
	 * Returns the CO2 impact rating for the given square
	 * @param squareIndex
	 * @return 
	 */
	@Override
	public int getCO2Modifier(int squareIndex) {
		ISquare square = squares[squareIndex];
		if(square instanceof Grassland) {
			Grassland grasslandSquare = (Grassland)square;
			return grasslandSquare.getCo2ImpactRating();
		}
		return 0;
	}
	
	/**
	 * Returns an ArrayList of all squares owned by given player.
	 * @param playerNumber
	 * @return
	 */
	@Override
	public ArrayList<Grassland> getAllPlayerOwnedGrasslands(Player currentPlayer) {
		ArrayList<Grassland> ownedGrasslands = new ArrayList<Grassland>();
		for (ISquare square : squares) {
			if(square instanceof Grassland) {
				Grassland grasslandSquare = (Grassland)square;
				if (grasslandSquare.getOwnerId()==currentPlayer.getPlayerNumber()) {
					ownedGrasslands.add(grasslandSquare);
				}
			}
		}
		return ownedGrasslands;
	}
	
	/**
	 * If a square is not owned then a player can take ownership
	 * @return
	 */
	@Override
	public boolean setSquareOwnerId(int squareIndex, int playerId) { //Tighten this method up!
		ISquare square = squares[squareIndex];
		if(square instanceof Grassland) {
			Grassland grasslandSquare = (Grassland)square;
			grasslandSquare.setInitialOwnerId(playerId);
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
	@Override
	public boolean playerCanUpgrade(int playerId, int squareIndex) {
		ISquare currSquare = squares[squareIndex];
	
		
		// Cannot upgrade a square that is not grass land:
		if(!(currSquare instanceof Grassland)) {
			return false;
		}
		
		Grassland currGrasslandSquare = (Grassland)currSquare;
				
		// If the grassland is vacant it can always be upgraded or owned:
		if(currGrasslandSquare.getSquareStatus() == SquareStatus.VACANT) {
			return true;
		}
		
		// The grassland is a wildlife sanctuary it cannot be developed further:
		if(!currGrasslandSquare.canDevelopGrassland()) {
			return false;
		}
		
		for(ISquare square : squares) {
	
			if(!(square instanceof Grassland)) { 
				continue; 
			}

			Grassland grasslandSquare = (Grassland)square;
			
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
	@Override
	public int costToUpgrade(int squareIndex) {
		ISquare currSquare = squares[squareIndex];
		
		// Cannot upgrade a square that is not grass land:
		if(currSquare instanceof Grassland) {
			Grassland grasslandSquare = (Grassland)currSquare;
			return grasslandSquare.getDevelopmentCost();
		}

		return 0;
	}
	
	/**
	 * Method to develop Grassland to it's next tier
	 * @param squareIndex
	 */
	@Override
	public void upgradeGrassland(int squareIndex) {
		ISquare currSquare = squares[squareIndex];
		if(currSquare instanceof Grassland) {
			((Grassland) currSquare).developGrassland();
		}
	}
	
	/**
	 * @param squareIndex
	 * @return
	 */
	@Override
	public SquareStatus getSquareType(int squareIndex) {
		// TODO add reflection to get the type of grassland:
		return SquareStatus.GRASSLAND;
	}	
}
