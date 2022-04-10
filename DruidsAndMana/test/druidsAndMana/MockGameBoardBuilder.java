package druidsAndMana;

import druidsAndMana.Square;
import druidsAndMana.IGameBoardBuilder;

public class MockGameBoardBuilder implements IGameBoardBuilder {

	public ISquare[] mockSquares;
	
	@Override
	public ISquare[] buildGameBoard() {
		return mockSquares;
	}

}
