package druidsAndMana;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pete
 */

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
	public int GetUserIntInput(String prompt, int[] allowedInputs) {
		
		boolean validInput = false;
		
		do
		{
			String [] strings = new String[allowedInputs.length];
			for (int i=0; i<strings.length; i++) {
				strings[i] = ""+allowedInputs[i]+"";
			}
			
			System.out.println(prompt);
			
			String userInput = this.in.nextLine();
			
			String match = this.InputMatch(userInput, strings);
			
			if (match == null) {
				
				String nearMatch = this.InputNearMatch(userInput, strings);
				
				if (nearMatch == null) {
					continue;
				}
				
				if (GetUserConfirmation("Do did you mean " + nearMatch + " ?")) {
					return Integer.parseInt(nearMatch);
				}
				
				continue;
			}
				
			return Integer.parseInt(match);
		}
		while(!validInput);
		
		return 0;
	}
	
	@Override
	public boolean GetUserConfirmation(String prompt) {
		System.out.println(prompt + " [ Yes | No ]");
		String response = this.in.nextLine().substring(0, 1);
		return response.equalsIgnoreCase("y");
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

	@Override
	public String GetOpenUserInput(String prompt) {
		
			System.out.println(prompt);
			
			String userInput = this.in.nextLine();
				
			return userInput;
	}
}
