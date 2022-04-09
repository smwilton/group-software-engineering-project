package druidsAndMana;

import druidsAndMana.Square;
import druidsAndMana.IGameBoardBuilder;

public class MockGameBoardBuilder implements IGameBoardBuilder {

	public Square[] mockSquares;
	
	@Override
	public Square[] buildGameBoard(int noSquares) {
		return mockSquares;
	}

}
