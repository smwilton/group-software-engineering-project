package druidsAndMana;

/**
 * 
 * @author sandra
 *
 */
public class Rules {

	private IInputService inputService;
	
	String ruleText = "la la la la ";
	
	public Rules(IInputService inputService) {
		this.inputService = inputService;
	}
	
	public String displayRules() {
		// Display rules in console
				return   ruleText;
	}
	
	//Wait for user input		

	public void exitRules() {
		boolean exitRules = this.inputService.GetUserConfirmation("Have you finished reading the rules?");
	}
}
