package druidsAndMana;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author sandra
 *
 */

/*
 * public void displayMenu() throws Exception { 
 *}
 */

// given, when something happens, then

class MenuTests {

	private Menu menu;
	private MockInputService inputService;
	private MockOutputService outputService;

	@BeforeEach
	void setUp() throws Exception {
		inputService = new MockInputService();
		inputService.setUserIntInput(7);
		outputService = new MockOutputService();
		menu = new Menu(inputService, outputService);
	}



	@Test
	void testGetPlayerChoice() {

		// Given
		int highestOptionNumber = 7;

		// When
		int playerChoice = menu.getPlayerChoice(highestOptionNumber);

		// Then
		assertEquals(playerChoice, 7);
	}

	@Test
	void testCreateArray() {

		// Given
		int numOfValues = 5;

		// When
		int[] array = menu.createArray(numOfValues);

		// Then
		assertEquals(array.length, numOfValues + 1);

	}

}
