package druidsAndMana;

public class GameEngine {

	private IInputService inputService;
	
	public GameEngine(IInputService inputService) {
		this.inputService = inputService;
	}
	
	public void TakeTurn() {
		
		// Lots of logic here:
		
		//Getting some user input:
		String selectedValue = this.inputService.GetUserInput("Please enter your pokemon type", new String[] { "Earth", "Wind", "Fire", "Water" });
		
		// 
		boolean val = this.inputService.GetUserConfirmation("test");
		
		// Printing the userInput
		System.out.println(val);
		
		// Store all of the variables
		
		// Game engine -> wraps the turn engine
		
		// Game engine -> persists state 
		
		// Turn engine -> runs in a game
		
		// Game engine creates players before the game starts
		
		// passed into the turn engine:
		
		// Turn engine encapsulates 
		
		//--------------------------------------------
		
		// Game admin -> putting in the players names, knows who playing:
		
		// Board class contains an array of 12 tiles 
		
		// Each turn tile abstact generic -> different types grassland, realm -> enum -> need const values
		
		// Turn - player existing position and dice roll -> [2, 6], Player < - class
		
		// Player set new position.
		
		// dice roll service -> mock out dice roll for testing
				
		// dice object - number of sides -> two dice need two instances. Dice dice = new Dice(6) - int result = dice.roll() + dice.roll()
		
		// Player score and co2 balance and owned grassland is part of the player class
		
		// 
		
	}
}
