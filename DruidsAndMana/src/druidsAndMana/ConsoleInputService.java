package druidsAndMana;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputService implements IInputService {

	private Scanner in;
	
	public ConsoleInputService() {
		this.in = new Scanner(System.in);
	}
	
	@Override
	public String GetUserInput(String prompt, String[] allowedInputs) {
		
		boolean validInput = false;
		
		do
		{
			System.out.println(prompt);
			
			String userInput = this.in.nextLine();
			
			String match = this.InputMatch(userInput, allowedInputs);
			
			if (match == null) {
				
				String nearMatch = this.InputNearMatch(userInput, allowedInputs);
				
				if (nearMatch == null) {
					continue;
				}
				
				if (GetUserConfirmation("Do did you mean " + nearMatch + " ?")) {
					return nearMatch;
				}
				
				continue;
			}
				
			return match;
		}
		while(!validInput);
		
		return null;
	}
	
	@Override
	public boolean GetUserConfirmation(String prompt) {
		System.out.println(prompt + " [ Yes | No ]");
		return this.in.nextLine().equalsIgnoreCase("yes");
	}
	
	private String InputMatch(String userInput, String[] allowedInputs){
		return Arrays.stream(allowedInputs)
					 .filter(x -> x.equalsIgnoreCase(userInput))
					 .findFirst()
					 .orElse(null);
	}
	
	private String InputNearMatch(String userInput, String[] allowedInputs) {
		return null;
	}
}
