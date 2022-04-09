package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import druidsAndMana.ForestSquare;
import druidsAndMana.GameBoard;
import druidsAndMana.IGameBoardBuilder;

class GameBoardTests {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test() {
		
		// Arrange
		// Create the mockGameBoard:
		MockGameBoardBuilder mockBoardBuilder = new MockGameBoardBuilder();
		
		// Create the mockForestSquare:
		ForestSquare mockForestSquare = new ForestSquare();
		mockForestSquare.owner = "Mock";
		
		// Create the mockBoardBuilder:
		mockBoardBuilder.mockSquares = new ForestSquare[] { mockForestSquare };
		
		GameBoard mockGameBoard = new GameBoard(mockBoardBuilder, 0);
		
		// Act
		String owner = mockGameBoard.getsquareOwnerId(0);
		
		// Assert
		assertEquals(owner, "Mock");
	}
	
	

}
