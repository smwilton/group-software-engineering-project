package druidsAndMana;

public interface IInputService {

	String GetUserInput(String prompt, String[] allowedInputs);
	
	String GetOpenUserInput(String prompt);

	boolean GetUserConfirmation(String prompt);

}