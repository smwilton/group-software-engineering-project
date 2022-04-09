package druidsAndMana;

public class GameBoardBuilder implements IGameBoardBuilder {
	
	public Square[] buildGameBoard(int noSquares) {
		//TODO: some logic here around build the square objects:
		
		Square[] squares = new Square[noSquares];
		
		for (int i = 0; i < noSquares; i++) {
			squares[i] = new Tropical();
		}
		
		return squares;
	}
}
