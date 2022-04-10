/**
 * 
 */
package druidsAndMana;

/**
 * @author Dave
 *
 */
public class GameAdmin {
	
	private IInputService inputService;
	
	public GameAdmin(IInputService inputService) {
		this.inputService = inputService;
	}
	
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
	
	
	

}
