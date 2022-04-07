package druidsAndMana;

public class GameBoardBuilder implements IGameBoardBuilder {
	
	public ForestSquare[] buildGameBoard(int noSquares) {
		//TODO: some logic here around build the square objects:
		
		ForestSquare[] forestSquares = new ForestSquare[noSquares];
		
		for (int i = 0; i < noSquares; i++) {
			forestSquares[i] = new ForestSquare();
		}
		
		return forestSquares;
	}
}
