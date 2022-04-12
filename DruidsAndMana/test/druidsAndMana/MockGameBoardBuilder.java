package druidsAndMana;

/**
 * 
 * @author pete
 *
 */

public class MockGameBoardBuilder implements IGameBoardBuilder {

	public ISquare[] mockSquares;

	@Override
	public ISquare[] buildGameBoard() {
		return mockSquares;
	}

}
