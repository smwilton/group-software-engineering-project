package druidsAndMana;

import druidsAndMana.ForestSquare;
import druidsAndMana.IGameBoardBuilder;

public class MockGameBoardBuilder implements IGameBoardBuilder {

	public ForestSquare[] mockSquares;
	
	@Override
	public ForestSquare[] buildGameBoard(int noSquares) {
		return mockSquares;
	}

}
