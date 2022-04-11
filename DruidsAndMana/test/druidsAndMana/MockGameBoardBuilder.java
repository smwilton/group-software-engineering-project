package druidsAndMana;

public class MockGameBoardBuilder implements IGameBoardBuilder {

	public ISquare[] mockSquares;

	@Override
	public ISquare[] buildGameBoard() {
		return mockSquares;
	}

}
