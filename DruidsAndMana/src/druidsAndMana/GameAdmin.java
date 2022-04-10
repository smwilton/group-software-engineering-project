/**
 * 
 */
package druidsAndMana;

import java.util.ArrayList;

/**
 * @author Dave
 *
 */
public class GameAdmin {
	
	private IInputService inputService;
	
	public GameAdmin(IInputService inputService) {
		this.inputService = inputService;
	}
	
	/**
	 * This method gets user input for how many Players are joining the game
	 * @return int : number of Players
	 */
	public int numOfPlayers() {
	//Ask number of players
	String numOfPlayers = this.inputService.GetUserInput("How many players are joining the game?", new String[] {"1","2","3","4"});
	
	//confirm selection
	boolean check = this.inputService.GetUserConfirmation("Are you sure?");
	
	//if confirmed, return number of players
	if(check) {
		return Integer.parseInt(numOfPlayers);
	}else {
		return 0;
	}
	}
	
	/**
	 * This method gets all Player names and stores in an ArrayList<String>, then creates a Player object for each name
	 * @param numOfPlayers : an int between 1 and 4
	 * @return ArrayList<String> : An ArrayList of the player names
	 */
	public void playerSetUp(int numOfPlayers) {
		//Create an ArrayList to add Player names to
		ArrayList<String> playerNames = new ArrayList<String>();
		//Get Player names
		for (int i=0; i<numOfPlayers; i++) {
			
			boolean nameCheck = false;
			//Check if each Player name is unique and repeat until they are.
			while(!nameCheck) {
			String playerName = this.inputService.GetOpenUserInput("What is the name of player "+i+"?");
			
			if(!playerNames.contains(playerName)) {
				nameCheck=true;
				playerNames.add(playerName);
				//If unique name chosen, creates a Player object with defualt starting values.
				Player player = new Player(i+1, playerName, 1500, 0, 0);
			}else {
				//Display error message on repeated name input
				System.out.println("This player name already exists. Please choose a unique name.");
			}
			
			}			
		}
	

}
