package druidsAndMana;

public interface IInputService {

	String GetUserInput(String prompt, String[] allowedInputs);

	boolean GetUserConfirmation(String prompt);

}